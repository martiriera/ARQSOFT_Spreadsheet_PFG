/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class CellCoordinate_Impl implements CellCoordinate{
    public String columnComponent;
    public int rowComponenent;

    public CellCoordinate_Impl(String columnComponent, int rowComponenent) {
        this.columnComponent = columnComponent;
        this.rowComponenent = rowComponenent;
    }
    
    public Cell getCell(String column, int row){
        //Returns a cell
    }

    @Override
    public float getValue() { //TODO: Get the content of the cell using Cell's method getContent
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
