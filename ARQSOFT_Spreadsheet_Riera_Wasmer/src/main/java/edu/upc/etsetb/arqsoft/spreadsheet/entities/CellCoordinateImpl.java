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

    private String columnComponent;
    private int rowComponent;

    public CellCoordinateImpl(String columnComponent, int rowComponenent) {
        this.columnComponent = columnComponent;
        this.rowComponent = rowComponenent;
    }

    public String getColumnComponent() {
        return columnComponent;
    }

    public int getRowComponenent() {
        return rowComponent;
    }

    @Override
    public double getArgumentValue() {
        throw new UnsupportedOperationException("CellCoordinateImpl getArgumentValue");
    }

    @Override
    public double getFormulaComponentValue() {
        throw new UnsupportedOperationException("CellCoordinateImpl getFormulaComponentValue");
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitCellCoordinate(this);
    }

    @Override
    public int hashCode() {
        return 31 * this.columnHashCode() + this.rowHashCode();
    }

    public int columnHashCode() {
        int hash = 0;
        hash += (columnComponent != null ? columnComponent.hashCode() : 0);
        return hash;
    }

    public int rowHashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + rowComponent;
        return result;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof CellCoordinate)) {
            return false;
        }
        CellCoordinateImpl other = (CellCoordinateImpl) object;
        if ((this.columnComponent == null || other.columnComponent == null)
                || (!this.columnComponent.equals(other.columnComponent))) {
            return false;
        }
        if (this.rowComponent != other.rowComponent) {
            return false;
        }
        return true;
    }

}
