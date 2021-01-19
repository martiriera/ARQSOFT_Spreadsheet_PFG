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
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Content;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.ContentException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Formula;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class UserInterfaceImpl implements UserInterface {

    Spreadsheet spreadsheet;
    SpreadsheetFactory factory;

    @Override
    public void setSpreadsheetAndFactory(Spreadsheet spreadsheet, SpreadsheetFactory factory) {
        this.spreadsheet = spreadsheet;
        this.factory = factory;
    }

    @Override
    public String initSpreadsheetDialog() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;

        System.out.println("0 - Create a new spreadsheet");
        System.out.println("1 - Load an existing spreadsheet");

        command = reader.readLine();

        switch (command) {
            case "0":
                return "";
            case "1":
                System.out.println("Enter the path of the spreadsheet");
                String path = reader.readLine();
                return path;
            default:
                this.wrongComand();
                return this.initSpreadsheetDialog();
        }
    }

    public void wrongComand() {
        System.out.println("Oops, something wrong with your command\n");
    }

    @Override
    public boolean editSpreadsheetDialog() throws IOException, BadCoordinateException, ContentException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;

        System.out.println("\ne - Edit a cell");
        System.out.println("c - Close spreadsheet");

        command = reader.readLine();

        switch (command) {
            case "e":
                System.out.println("\nIntroduce the coordinate of the cell to edit");
                String coordinate = reader.readLine();
                if (CellCoordinate.coordinateValidation(coordinate)) {
                    Cell cell = spreadsheet.getCell(factory.createCellCoordinate(coordinate));
                    if (cell == null) {
                        System.out.println("\nEmpty cell");
                    } else {
                        Content actualContent = cell.cellContent;
                        String actualContentString;
                        if (actualContent instanceof Formula) {
                            actualContentString = ((Formula) actualContent).getFormulaString();
                        } else {
                            actualContentString = actualContent.getValueAsString();
                        }
                        System.out.println("\nContent of the cell: " + actualContentString);
                    }
                    System.out.println("Introduce a new content for the cell");
                    String newContent = reader.readLine();
                    try {
                        spreadsheet.setCellContent(coordinate, newContent);
                        this.printSpreadSheet();
                        return false;
                    } catch (ContentException e) {
                        throw e;
                    }

                } else {
                    throw new BadCoordinateException("Bad coordinate format");
                }
            case "c":
                return true;
            default:
                this.wrongComand();
                return false;
        }
    }

    @Override
    public void printSpreadSheet() {
        ArrayList<Character> columnsArray = spreadsheet.getSpreadsheetColumnsArray();
        ArrayList<Integer> rowsArray = spreadsheet.getSpreadsheetRowsArray();
        for (char ca : columnsArray) {
            System.out.print(String.format("%1$" + 3 + "s", "") + ca + String.format("%1$" + 7 + "s", ""));
        }
        System.out.println("");
        for (int row : rowsArray) {
            System.out.print(row + "| ");
            for (char column : columnsArray) {
                CellCoordinate coordinate = factory.createCellCoordinate(column + "" + row);
                String cellContentToPrint = "";
                if (spreadsheet.getCellMap().keySet().contains(coordinate)) {
                    Content cellContent = spreadsheet.getCell(coordinate).cellContent;
                    if (cellContent instanceof Formula) {
                        Formula formula = (Formula) cellContent;
                        try {
                            cellContentToPrint = spreadsheet.getCellContentAsString(column + "" + row) + formula.getFormulaString();
                        } catch (BadCoordinateException ex) {
                            Logger.getLogger(UserInterfaceImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        cellContentToPrint = cellContent.getValueAsString();
                    }
                    System.out.print(cellContentToPrint);
                    System.out.print(String.format("%1$" + 8 + "s", "") + "|");
                } else {
                    System.out.print(String.format("%1$" + 13 + "s", "") + "|");
                }
            }
            System.out.println("");
        }
    }

    @Override
    public String closeSpreadsheetDialog() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;

        System.out.println("");
        System.out.println("Do you want to save the spreadsheet? (y/n)");

        command = reader.readLine();

        if (command.equals("y")) {
            System.out.println("\nIntroduce an absolute path to store the file");
            String pathToSave = reader.readLine();
            return pathToSave;
        } else {
            return "";
        }
    }
}
