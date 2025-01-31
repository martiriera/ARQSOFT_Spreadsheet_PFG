/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas;

import java.util.List;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class FormulaImpl implements Formula {

    List<FormulaComponent> formulaComponents;
    double formulaResult;
    String formulaString;

    public FormulaImpl(List<FormulaComponent> formulaComponents) {
        this.formulaComponents = formulaComponents;
        this.formulaResult = 0;
    }
    
    @Override
    public List<FormulaComponent> getFormulaComponents() {
        return formulaComponents;
    }

    @Override
    public void setFormulaResult(double formulaResult) {
        this.formulaResult = formulaResult;
    }

    @Override
    public void setFormulaString(String formulaString) {
        this.formulaString = formulaString;
    }

    public String getFormulaString() {
        return formulaString;
    }

    @Override
    public double getValueAsDouble() {
        return formulaResult;
    }

    @Override
    public String getValueAsString() {
        return formulaString;
    }

}
