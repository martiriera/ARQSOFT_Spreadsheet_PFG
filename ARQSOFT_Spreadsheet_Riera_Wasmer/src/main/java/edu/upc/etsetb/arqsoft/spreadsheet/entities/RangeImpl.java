/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Visitor;
import java.util.HashMap;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class RangeImpl implements Range {
    
    public HashMap<CellCoordinate, Cell> cellRangeMap;
    public CellCoordinateImpl initialCellCoordinate;
    public CellCoordinateImpl finalCellCoordinate;

    public RangeImpl(CellCoordinateImpl initialCellCoord, CellCoordinateImpl finalCellCoord) {
        this.initialCellCoordinate = initialCellCoord;
        this.finalCellCoordinate = finalCellCoord;
        this.cellRangeMap = new HashMap<>(); 
    }
    
    @Override
    public double getArgumentValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        throw new UnsupportedOperationException("RangeImpl acceptVisitor Exception"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getFormulaComponentValue() {
        throw new UnsupportedOperationException("RangeImpl getFormulaComponentValue Exception"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
