/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Visitor;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class ANumberImpl implements ANumber {

    public double value;

    public ANumberImpl(double value) {
        this.value = value;
    }

    @Override
    public double getValueAsDouble() {
        return value;
    }

    @Override
    public String getValueAsString() {
        return String.valueOf(value);
    }

    @Override
    public double getArgumentValue() {
        return value;
    }
    
    @Override
    public double getFormulaComponentValue() {
        return value;
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitANumber(this);
    }

  

}
