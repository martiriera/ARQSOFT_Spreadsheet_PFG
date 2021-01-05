/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Visitor;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.Argument;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class Cell implements Argument {

    public Content cellContent;

    public Cell(Content cellContent) {
        this.cellContent = cellContent;
    }

    public Content getCellContent() {
        return cellContent;
    }
    
    public String getFormula(){
        return cellContent.getValueAsString();
    }

    @Override
    public double getArgumentValue() {
        return cellContent.getValueAsDouble();
    }
    
    @Override
    public double getFormulaComponentValue() {
        throw new UnsupportedOperationException("Cell getFormulaComponentValue Exception"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        throw new UnsupportedOperationException("Cell acceptVisitor Exception"); //To change body of generated methods, choose Tools | Templates.
    }

}
