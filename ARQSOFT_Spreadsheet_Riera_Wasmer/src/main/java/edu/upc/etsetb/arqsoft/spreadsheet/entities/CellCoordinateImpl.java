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
        final int prime = 31;
        return columnComponent.charAt(0) * prime + rowComponent;  
    }
 
    //Compare only account numbers
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CellCoordinateImpl other = (CellCoordinateImpl) obj;
        return !(columnComponent != other.columnComponent || other.rowComponent != rowComponent);
    }
    
}
