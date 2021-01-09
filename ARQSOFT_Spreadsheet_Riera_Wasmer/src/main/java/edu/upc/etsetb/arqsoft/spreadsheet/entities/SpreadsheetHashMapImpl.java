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
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.BadTokenException;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.FormulaException;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.PostFixGenerator;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.SyntaxChecker;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.SyntaxException;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.Token;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.Tokenizer;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class SpreadsheetHashMapImpl implements Spreadsheet {

    public HashMap<CellCoordinate, Cell> cellMap;
    public SpreadsheetFactory factory;
    public FormulaEvaluator formEvaluator;

    @Override
    public void setFactory(SpreadsheetFactory factory) {
        this.factory = factory;
    }

    @Override
    public void setFormulaEvaluator(FormulaEvaluator formEvaluator) {
        this.formEvaluator = formEvaluator;
    }

    @Override
    public void setCellContent(String cellCoord, String content) throws ContentException, BadCoordinateException {

        if (CellCoordinate.coordinateValidation(cellCoord)){
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

            Tokenizer tokenizer = factory.createTokenizer();
            SyntaxChecker syntaxChecker = factory.createSyntaxChecker();
            PostFixGenerator postfixGenerator = factory.createPostFixGenerator();
            List<Token> tokenList; //TODO: Inicialitzar
            try {
                
                tokenizer.tokenize(formulaString);
                //tokenizer.getResult();
                syntaxChecker.check(formulaString);
                tokenList = syntaxChecker.getTokens();
                postfixGenerator.generateFromTokens(tokenList);
                List<FormulaComponent> formulaComponentList = postfixGenerator.getResultQueue();       
                Formula formula = factory.createFormula(formulaComponentList);
                return formula;//TODO: Return formula o result?
                
                
            } catch (BadTokenException | SyntaxException | FormulaException e) {
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
    public double getCellContentAsDouble(String b11) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cell getCell(CellCoordinate cellCoord) {
        return cellMap.get(cellCoord);
    }

    public Range getRangeofCells(CellCoordinateImpl originCellCoord, CellCoordinateImpl finalCellCoord) {

        HashMap<CellCoordinate, Cell> rangeMap = new HashMap<>();

        List<String> columnsToIterate = this.getColumnsList(originCellCoord.columnComponent, finalCellCoord.columnComponent);
        int numberOfColumns = columnsToIterate.size();
//        int numberOfRows = Math.abs(finalCellCoord.rowComponenent - originCellCoord.rowComponenent);

        for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
            for (int rowIndex = originCellCoord.rowComponenent; rowIndex <= finalCellCoord.rowComponenent; rowIndex++) {

                CellCoordinate coordinateOfCellToPut = factory.createCellCoordinate(columnsToIterate.get(columnIndex) + String.valueOf(rowIndex));
                Cell cellToPut = this.getCell(coordinateOfCellToPut);
                if (cellToPut != null) {
                    rangeMap.put(coordinateOfCellToPut, cellToPut);
                } else {
                    // Put to the range the cell already, but with content 0
                    rangeMap.put(coordinateOfCellToPut, new Cell(new ANumberImpl(0)));
                }
            }
        }
        return new RangeImpl(rangeMap);

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
    public String getCellContentAsString(String b11) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
