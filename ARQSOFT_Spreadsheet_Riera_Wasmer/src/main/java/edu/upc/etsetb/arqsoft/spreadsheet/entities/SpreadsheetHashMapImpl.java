/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities;

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

    public void setCellContent(String cellCoord, String content) throws ContentException, BadCoordinateException {
        // (?<=\\D)(?=\\d) matches a position between a non-digit (\D) and a digit (\d)
        String[] separateCoordinate = cellCoord.split("(?<=\\D)(?=\\d)");
        
        CellCoordinateImpl targetCoordinate = new CellCoordinateImpl(separateCoordinate[0], Integer.parseInt(separateCoordinate[1]));
        Cell targetCell = new Cell(new TextImpl(content));
        cellMap.put(targetCoordinate, targetCell);
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
                CellCoordinateImpl coordinateOfCellToPut = new CellCoordinateImpl(columnsToIterate.get(columnIndex), rowIndex);
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
}
