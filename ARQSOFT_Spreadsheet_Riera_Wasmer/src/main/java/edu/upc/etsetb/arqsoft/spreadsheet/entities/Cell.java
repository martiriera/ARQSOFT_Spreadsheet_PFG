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
class Cell {
    private CellCoordinate cellCoord; //Necessary?
    private Content cellContent;

    public Cell(Content cellContent) {
        this.cellContent = cellContent;
    }

    public Content getCellContent() {
        return cellContent;
    }
    
    
    
}
