/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Formula;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.FormulaComponent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.FormulaEvaluator;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.FormulaImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.FormulaException;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.PostFixGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class SpreadsheetHashMapImpl implements Spreadsheet {
    public HashMap<CellCoordinate, Cell> cellMap;
    public SpreadsheetFactory factory;
    public FormulaEvaluator formulaEvaluator;

    public SpreadsheetHashMapImpl() {
        this.cellMap = new HashMap<>();
    }

    @Override
    public void setFactory(SpreadsheetFactory factory) {
        this.factory = factory;
    }

    @Override
    public void setFormulaEvaluator(FormulaEvaluator formulaEvaluator) {
        this.formulaEvaluator = formulaEvaluator;
    }

    @Override
    public void setCellContent(String cellCoord, String content) throws ContentException, BadCoordinateException {
        if (CellCoordinate.coordinateValidation(cellCoord)) { //TODO: This can throw an exception
            try {
                Content classifiedContent = classifyContent(content);
                cellMap.put(factory.createCellCoordinate(cellCoord), new Cell(classifiedContent));
            } catch (ContentException e) {
                throw e;
            }
        } else {
            throw new BadCoordinateException("Wrong cellCoordinate format.");
        }
    }

    public Content classifyContent(String content) throws ContentException {

        if (content.charAt(0) == '=') {
            String formulaString = content.substring(1);
            PostFixGenerator postfixGenerator = factory.createPostFixGenerator();
            postfixGenerator.setFactory(factory);
            try {
                postfixGenerator.generateFromString(formulaString);
                List<FormulaComponent> formulaComponentsList = postfixGenerator.getResultQueue();
                Formula formula = factory.createFormula(formulaComponentsList);
                return formula;
            } catch (FormulaException e) {
                throw new ContentException(e.getMessage());
            }
        } else {
            try {
                double value = Double.parseDouble(content);
                return factory.createNumber(value);

            } catch (NumberFormatException e) {
                return factory.createText(content);
            }
        }
    }

    @Override
    public Cell getCell(CellCoordinate cellCoord) {
        return cellMap.get(cellCoord);
    }

    public HashMap<CellCoordinate, Cell> fillRangeOfCells(RangeImpl rangeMap) {

        HashMap<CellCoordinate, Cell> outputRangeMap = new HashMap<>();
        CellCoordinateImpl initialCoordinate = rangeMap.initialCellCoordinate;
        CellCoordinateImpl finalCoordinate = rangeMap.finalCellCoordinate;

        List<String> columnsToIterate = this.getColumnsList(initialCoordinate.getColumnComponent(), 
                finalCoordinate.getColumnComponent());
        
        int numberOfColumns = columnsToIterate.size();
//        int numberOfRows = Math.abs(finalCellCoord.rowComponenent - originCellCoord.rowComponenent);

        for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
            for (int rowIndex = initialCoordinate.getRowComponenent(); rowIndex <= finalCoordinate.getRowComponenent(); rowIndex++) {

                CellCoordinate coordinateOfCellToPut = factory.createCellCoordinate(columnsToIterate.get(columnIndex) + String.valueOf(rowIndex));
                Cell cellToPut = this.getCell(coordinateOfCellToPut);
                if (cellToPut != null) {
                    outputRangeMap.put(coordinateOfCellToPut, cellToPut);
                } else {
                    // Put to the range the cell already, but with content 0
                    outputRangeMap.put(coordinateOfCellToPut, new Cell(new ANumberImpl(0)));
                }
            }
        }
        return outputRangeMap;

    }

    public List<String> getColumnsList(String initialColumn, String finalColumn) {
        // Prevent second coord "smaller" than first coord. If so, swap coordinates.
//        if (initialColumn.charAt(0) > finalColumn.charAt(0) || initialColumn.length() > finalColumn.length()) {
//            String temp = initialColumn;
//            initialColumn = finalColumn;
//            finalColumn = temp;
//        }

        ArrayList<String> columnArray = new ArrayList();
        int i = 0;
        String aux = "";
        while (!aux.equals(finalColumn)) {
            char c = (char) ('A' + (i % 26)); // From 'A' to 'Z' 
            aux = c + "";
            if (i > 25) { // When finalColumn is greater than 'Z'
                aux = columnArray.get((i / 26) - 1) + "" + c;
            }
            columnArray.add(aux);
            i++;
        }
        // Trim array starting with 'A' from initial column to final column
        int fromIndex = columnArray.indexOf(initialColumn);
        int toIndex = columnArray.indexOf(finalColumn) + 1;
        return (columnArray.subList(fromIndex, toIndex));

    }

    @Override
    public String getCellContentAsString(String b11) throws BadCoordinateException {
        if (CellCoordinate.coordinateValidation(b11)) { //TODO: This will return NULL if the cell is not on the map
            Cell cell = this.getMatchingCell(b11);
            Content content = cell.getCellContent();
            if (content instanceof Formula) {
                return String.valueOf(formulaEvaluator.evaluateFormula((FormulaImpl) content));
            } else {
                return content.getValueAsString();
            }
        } else {
            throw new BadCoordinateException("Bad coordinate format");
        }
    }

    @Override
    public double getCellContentAsDouble(String b11) throws BadCoordinateException, NoNumberException {
        if (CellCoordinate.coordinateValidation(b11)) {
            Cell cell = this.getMatchingCell(b11); //TODO: This will return NULL if the cell is not on the map
            Content content = cell.getCellContent();
            if (content instanceof ANumber) {
                return cell.getCellContent().getValueAsDouble();
            } else if (content instanceof Formula) {
                return formulaEvaluator.evaluateFormula((FormulaImpl) content); //TODO: IMPL HERE?
            } else {
                String stringContent = content.getValueAsString();
                if (stringContent.isEmpty()) {
                    return 0.0;
                } else {
                    throw new NoNumberException("No number exception");
                }
            }
        } else {
            throw new BadCoordinateException("Bad coordinate format");
        }
    }

    
    public Cell getMatchingCell(String cellCoord) {
        Iterator it = cellMap.keySet().iterator();
        while (it.hasNext()) {
            CellCoordinateImpl cc = (CellCoordinateImpl) it.next();
            String stringCoord = cc.getColumnComponent() + String.valueOf(cc.getRowComponenent());
            if (cellCoord == null ? stringCoord == null : cellCoord.equals(stringCoord)) {
                return cellMap.get(cc);
            }
        }
        return null;
    }
    
    public Set<CellCoordinate> getMapKeys(){
        return this.cellMap.keySet();
    }

}
