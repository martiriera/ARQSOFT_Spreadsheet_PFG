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
public class CellCoordinateImpl implements CellCoordinate {

    public String columnComponent;

    public int rowComponenent;

    public CellCoordinateImpl(String columnComponent, int rowComponenent) {
        this.columnComponent = columnComponent;
        this.rowComponenent = rowComponenent;
    }

    @Override
    public float getArgumentValue() {
        throw new UnsupportedOperationException("CellCoordinateImpl getArgumentValue");
    }

    @Override
    public float getFormulaComponentValue() {
        throw new UnsupportedOperationException("ellCoordinateImpl getFormulaComponentValue");
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitCellCoordinate(this);
    }

}
