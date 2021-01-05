/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.FormulaComponent;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public interface Argument extends FormulaComponent{
    double getArgumentValue();
    //TODO: If this if extends FormulaComponent, Cell has to implement acceptVisitor method
}
