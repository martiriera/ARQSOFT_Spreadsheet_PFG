/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.entities.parser;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.BadCoordinateException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Cell;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.CellCoordinateImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.ContentException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.SpreadsheetHashMapImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Formula;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class ParserS2V implements Parser {

    public SpreadsheetFactory factory;

    @Override
    public void setFactory(SpreadsheetFactory factory) {
        this.factory = factory;
    }

    @Override
    public ArrayList<String[]> getContentsFromFile(String path) throws FileNotFoundException, IOException {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw e;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String strLine;
        ArrayList<String[]> allContents = new ArrayList<String[]>();
        try {
            while ((strLine = reader.readLine()) != null) {
                String[] rowContents = strLine.split(";");
                allContents.add(rowContents);
            }
        } catch (IOException e) {
            throw e;
        }
        try {
            reader.close();
        } catch (IOException e) {
            throw e;
        }
        return allContents;
    }

    @Override
    public Spreadsheet generateSpreadsheetFromContents(ArrayList<String[]> allContents) {
        Spreadsheet spreadsheet = new SpreadsheetHashMapImpl();
        spreadsheet.setFactory(factory);

        int rowIndex = 1;
        for (String[] rowContents : allContents) {
            ArrayList<String> columnArray = new ArrayList();
            int i = 0; // columnIndex
            String columnLetter = "";
            for (String content : rowContents) {
                char c = (char) ('A' + (i % 26));
                columnLetter = c + "";
                columnArray.add(columnLetter);
                if (content.equals("")) {
                    i++;
                } else {
                    if (i > 25) {
                        columnArray.remove(columnArray.size() - 1); //TODO: Revise this patch
                        columnLetter = columnArray.get((i / 26) - 1) + "" + c;
                        columnArray.add(columnLetter);
                    }
                    try {
                        spreadsheet.setCellContent(columnLetter + String.valueOf(rowIndex), content);
//                        System.out.println("Content " + content + " set on coordinate " + columnLetter + String.valueOf(rowIndex));
                    } catch (ContentException | BadCoordinateException e) {
                        System.out.println(e.getMessage());
                    }
                    i++;
                }
            }
            columnArray.clear();
            rowIndex++;
        }
        return spreadsheet;
    }

    @Override
    public void generateFileFromSpreadsheet(Spreadsheet spreadsheet, String path) {
        ArrayList<Character> columnsArray = spreadsheet.getSpreadsheetColumnsArray();
        ArrayList<Integer> rowsArray = spreadsheet.getSpreadsheetRowsArray();
        try {
            FileWriter myWriter = new FileWriter(path);
            for (int row : rowsArray) {
                for (char column : columnsArray) {
                    String cellContentString;
                    CellCoordinateImpl cellCoordinate = new CellCoordinateImpl(column + "", row); //TODO: Do this with the factory
                    if (spreadsheet.getCellMap().keySet().contains(cellCoordinate)) {
                        Cell cell = spreadsheet.getCell(cellCoordinate);
                        if (cell.cellContent instanceof Formula) { // If formula get the formula string NOT COMPUTED
                            Formula formula = (Formula) cell.cellContent;
                            cellContentString = formula.getFormulaString();
                        } else {
                            cellContentString = spreadsheet.getCellContentAsString(column + "" + row); // If Text or ANumber get it as string
                        }
                        myWriter.write(cellContentString);
                        if (columnsArray.indexOf(column) != columnsArray.size() - 1) {
                            myWriter.write(";");
                        }
                    } else {
                        myWriter.write(";");
                    }
                }
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException | BadCoordinateException e) {
            System.out.println("Error on saving the Spreadsheet");
            e.printStackTrace();
        }
    }

}
