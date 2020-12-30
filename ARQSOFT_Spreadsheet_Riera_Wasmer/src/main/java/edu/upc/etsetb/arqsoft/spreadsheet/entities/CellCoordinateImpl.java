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
public class CellCoordinateImpl implements CellCoordinate{
    public String columnComponent;
    public int rowComponenent;

    public CellCoordinateImpl(String columnComponent, int rowComponenent) {
        this.columnComponent = columnComponent;
        this.rowComponenent = rowComponenent;
    }
  
}
