/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.entities.ui;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.BadCoordinateException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.ContentException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.SpreadsheetFactory;
import java.io.IOException;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public interface UserInterface {

    public void setSpreadsheetAndFactory(Spreadsheet spreadsheet, SpreadsheetFactory factory);
    
    public String initSpreadsheetDialog() throws IOException;
    
    public boolean editSpreadsheetDialog() throws IOException, BadCoordinateException, ContentException;
    
    public void printSpreadSheet();

    public String closeSpreadsheetDialog() throws IOException;
    
}
