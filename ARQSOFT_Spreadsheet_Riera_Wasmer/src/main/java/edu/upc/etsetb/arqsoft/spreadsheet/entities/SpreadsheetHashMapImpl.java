/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities;

import static java.lang.Math.abs;
import java.util.HashMap;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class SpreadsheetHashMapImpl implements Spreadsheet {

    public HashMap<CellCoordinate, Cell> cellMap;

    public Cell getCell(CellCoordinate cellCoord) {
        return cellMap.get(cellCoord);
    }

    public Range getRangeofCells(CellCoordinateImpl originCellCoord, CellCoordinateImpl finalCellCoordinate) {

        int numberOfColumns = 0;
        String[] columnsToIterate = getColumnArray(numberOfColumns);
        int numberOfRows = finalCellCoordinate.rowComponenent - originCellCoord.rowComponenent;
        numberOfRows = Math.abs(numberOfRows);

        HashMap<CellCoordinate, Cell> rangeMap = new HashMap<>();

        for (int i = 0; i < columnsToIterate.length; i++) {
            for (int j = 0; j < numberOfRows; j++) {
             
                
            }
        }
    

    return  new RangeImpl(rangeMap);

}

public static String[] getColumnArray(String initialColumn, String finalColumn) {

        String[] columnArray = new String[0];
        int i = 0;
        int arrayLength = 0;
        String aux = initialColumn;
        while(aux != finalColumn) {
            char c = (char) ('A' + (i % 26));
            aux = c + "";
            if (i > 25) {
                aux = columnArray[(i / 26) - 1] + "" + c;
            }
            columnArray[i] = aux;
            arrayLength++;
            i++;
        }
        return columnArray;
    }

}
