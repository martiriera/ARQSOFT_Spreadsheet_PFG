/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.ANumber;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.CellCoordinate;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.Function;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public interface Visitor {

    void visitANumber(ANumber aNumber);

    void visitCellCoordinate(CellCoordinate cellCoordinate); // TODO: Impl correct (others not)?

    void visitFunction(Function function);

    void visitOperator(Operator operator);

}
