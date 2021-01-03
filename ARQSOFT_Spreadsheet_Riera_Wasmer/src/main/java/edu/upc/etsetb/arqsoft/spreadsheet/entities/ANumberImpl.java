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

    public float value;

    public ANumberImpl(float value) {
        this.value = value;
    }

    @Override
    public float getFloatValue() {
        return value;
    }

    @Override
    public String getStringValue() {
        return String.valueOf(value);
    }

    @Override
    public float getArgumentValue() {
        return value;
    }

    @Override
    public float getFormulaComponentValue() {
        return value;
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitANumber(this);
    }

}
