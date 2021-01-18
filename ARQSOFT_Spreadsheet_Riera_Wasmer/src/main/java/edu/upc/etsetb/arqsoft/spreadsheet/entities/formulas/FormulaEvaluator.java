/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.SpreadsheetFactory;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class FormulaEvaluator {

    SpreadsheetFactory factory;
    Spreadsheet spreadsheet;

    public void setFactory(SpreadsheetFactory factory) {
        this.factory = factory;
    }

    public void setSheet(Spreadsheet spreadsheet) {
        this.spreadsheet = spreadsheet;
    }

    public double evaluateFormula(FormulaImpl formula) {//TODO: Formula o formula impl?
        EvaluatorPostFix evaluator = new EvaluatorPostFix(spreadsheet, factory);
        double formulaResult = evaluator.evaluatePostFix(formula.formulaComponents);
        formula.formulaResult = formulaResult;
        return formulaResult;
    }
}
