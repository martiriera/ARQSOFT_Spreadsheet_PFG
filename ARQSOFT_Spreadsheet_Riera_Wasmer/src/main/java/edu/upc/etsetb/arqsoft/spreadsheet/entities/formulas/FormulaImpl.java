/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class FormulaImpl implements Formula {

    List<FormulaComponent> formulaComponents;

    public FormulaImpl(List<FormulaComponent> formulaComponents) {
        this.formulaComponents = formulaComponents;
    }

    @Override
    public double getValueAsDouble() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getValueAsString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
