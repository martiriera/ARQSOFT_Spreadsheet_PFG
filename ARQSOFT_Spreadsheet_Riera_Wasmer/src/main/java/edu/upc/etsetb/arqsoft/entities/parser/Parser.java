/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.entities.parser;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.BadCoordinateException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.SpreadsheetFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public interface Parser {

    public void setFactory(SpreadsheetFactory factory);

    public ArrayList<String[]> getContentsFromFile(String path) throws FileNotFoundException, IOException;

    public Spreadsheet generateSpreadsheetFromContents(ArrayList<String[]> contents);

    public void generateFileFromSpreadsheet(Spreadsheet spreadsheet, String path) throws IOException, BadCoordinateException;

}
