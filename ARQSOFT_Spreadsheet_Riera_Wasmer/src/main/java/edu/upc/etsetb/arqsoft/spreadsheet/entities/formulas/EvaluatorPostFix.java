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
public class EvaluatorPostFix {

    public float evaluatePostFix(List<FormulaComponent> formulaComponents) {
        VisitorFormulaComponents visitor = new VisitorFormulaComponents();
        
        for(FormulaComponent component : formulaComponents){
           component.acceptVisitor(visitor);
        }
        return visitor.getResult();       
    }
}
