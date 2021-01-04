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

    public Cell getCell(CellCoordinate cellCoord) {
        return cellMap.get(cellCoord);
    }

    public Range getRangeofCells(CellCoordinateImpl originCellCoord, CellCoordinateImpl finalCellCoord) {

        List<String> columnsToIterate = this.getColumnArray(originCellCoord.columnComponent, finalCellCoord.columnComponent);
        int numberOfColumns = columnsToIterate.size();
        int numberOfRows = Math.abs(finalCellCoord.rowComponenent - originCellCoord.rowComponenent);

        HashMap<CellCoordinate, Cell> rangeMap = new HashMap<>();

        for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
            for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
                CellCoordinateImpl cellToPutCoordinate = new CellCoordinateImpl(columnsToIterate.get(columnIndex), rowIndex);
                Cell cellToPut = this.getCell(cellToPutCoordinate);
                if (cellToPut != null) {
                    rangeMap.put(finalCellCoord, cellToPut);
                }
            }
        }
        return new RangeImpl(rangeMap);

    }

    public List<String> getColumnArray(String initialColumn, String finalColumn) {
        ArrayList<String> columnArray = new ArrayList();
        int i = 0;
        String aux = initialColumn;
        while (!aux.equals(finalColumn)) {
            char c = (char) ('A' + (i % 26));
            aux = c + "";
            System.out.println(aux);
            if (i > 25) {
                aux = columnArray.get((i / 26) - 1) + "" + c;
            }
            i++;
            columnArray.add(aux);
        }
        int fromIndex = columnArray.indexOf(initialColumn);
        int toIndex = columnArray.indexOf(finalColumn) + 1;
        // Trim array from initial column to final column
        return (columnArray.subList(fromIndex, toIndex));

    }
}
