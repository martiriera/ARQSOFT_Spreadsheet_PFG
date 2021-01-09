/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.FormulaEvaluator;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public interface Spreadsheet {

    public Cell getCell(CellCoordinate cellCoordinate);

    public void setCellContent(String coordinate, String content) throws ContentException, BadCoordinateException;

    public double getCellContentAsDouble(String b11);
    
    public void setFactory(SpreadsheetFactory factory);
    
    public void setFormulaEvaluator(FormulaEvaluator formEvaluator);
    
    public String getCellContentAsString(String b11);
    
}
