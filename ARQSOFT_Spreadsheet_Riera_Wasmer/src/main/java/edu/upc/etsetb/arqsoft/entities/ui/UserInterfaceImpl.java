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
        ArrayList<Character> columnsArray = spreadsheet.getSpreadsheetColumnsArray();
        ArrayList<Integer> rowsArray = spreadsheet.getSpreadsheetRowsArray();
        for (char ca : columnsArray) {
            System.out.print(String.format("%1$" + 3 + "s", "") + ca + String.format("%1$" + 7 + "s", ""));
        }
        System.out.println("");
        for (int row : rowsArray) {
            System.out.print(row + " ");
            for (char column : columnsArray) {
                if (spreadsheet.getCellMap().keySet().contains(new CellCoordinateImpl(column + "", row))) {
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
