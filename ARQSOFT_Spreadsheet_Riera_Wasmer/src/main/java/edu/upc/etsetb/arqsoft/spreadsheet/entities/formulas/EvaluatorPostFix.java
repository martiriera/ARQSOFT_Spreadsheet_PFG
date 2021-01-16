/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.SpreadsheetFactory;
import java.util.List;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class EvaluatorPostFix {

    private Spreadsheet spreadsheet;
    private SpreadsheetFactory factory;

    public EvaluatorPostFix(Spreadsheet spreadsheet, SpreadsheetFactory factory) {
        this.spreadsheet = spreadsheet;
        this.factory = factory;
    }

    public double evaluatePostFix(List<FormulaComponent> formulaComponents) {
        VisitorFormulaComponents visitor = new VisitorFormulaComponents(spreadsheet, factory);
        for (FormulaComponent component : formulaComponents) {
            System.out.println(component);
            component.acceptVisitor(visitor);
        }
        return visitor.getResult();
    }
}
