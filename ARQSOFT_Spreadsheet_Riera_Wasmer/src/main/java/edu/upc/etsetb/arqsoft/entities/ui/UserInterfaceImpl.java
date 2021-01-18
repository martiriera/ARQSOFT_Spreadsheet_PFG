/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.entities.ui;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.BadCoordinateException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Cell;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.CellCoordinate;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.CellCoordinateImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class UserInterfaceImpl implements UserInterface {

    public void printSpreadSheet(Spreadsheet spreadsheet) {
        Set<CellCoordinate> keyCoordinates = spreadsheet.getCellMap().keySet();

        char greaterColumn = 'A';
        int greaterRow = 1;
        ArrayList<Character> columnsArray = new ArrayList<Character>();
        ArrayList<Integer> rowsArray = new ArrayList<Integer>();

        for (CellCoordinate key : keyCoordinates) {
            if (key.getColumnComponent().charAt(0) > greaterColumn) {
                greaterColumn = key.getColumnComponent().charAt(0);
            }
            if (key.getRowComponent() > greaterRow) {
                greaterRow = key.getRowComponent();
            }
        }

        for (char c = 'A'; c <= greaterColumn; c++) {
            columnsArray.add(c);
        }
        for (int r = 1; r <= greaterRow; r++) {
            rowsArray.add(r);
        }

        for (char ca : columnsArray) {
            System.out.print(String.format("%1$" + 3 + "s", "") + ca + String.format("%1$" +  7 + "s", ""));
        }
        System.out.println("");
        for (int row : rowsArray) {
            System.out.print(row + " ");
            for (char column : columnsArray) {
                if (keyCoordinates.contains(new CellCoordinateImpl(column + "", row))) {
                    try {
                        System.out.print(spreadsheet.getCellContentAsString(column + "" + row));
                        System.out.print(String.format("%1$" + 8 + "s", ""));
                    } catch (BadCoordinateException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.print(String.format("%1$" + 13 + "s", ""));
                }
            }
            System.out.println("");
        }

    }
}
