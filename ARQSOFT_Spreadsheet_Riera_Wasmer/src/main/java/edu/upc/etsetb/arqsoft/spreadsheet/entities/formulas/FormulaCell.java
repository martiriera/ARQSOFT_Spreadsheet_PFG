/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.Cell;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.TextImpl;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class FormulaCell extends Cell {
    
    public FormulaCell(String formulaString) {
        super(new TextImpl(formulaString));
    }

}
