/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.ANumber;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.ANumberImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.CellCoordinate;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.SpreadsheetHashMapImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.Function;
import java.util.Stack;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class VisitorFormulaComponents implements Visitor {

    private Stack<FormulaComponent> stack = new Stack();
    private SpreadsheetHashMapImpl spreadsheet;

    @Override
    public void visitOperator(Operator operator) { //TODO: Validate this code
        float result = 0;
        FormulaComponent rightOperand = stack.pop();
        FormulaComponent leftOperand = stack.pop();
        
        if (operator.isAdd()) {
            result = leftOperand.getFormulaComponentValue() + rightOperand.getFormulaComponentValue();
        } else if (operator.isSubs()) {
            result = leftOperand.getFormulaComponentValue() - rightOperand.getFormulaComponentValue();
        } else if (operator.isMult()) {
            result = leftOperand.getFormulaComponentValue() * rightOperand.getFormulaComponentValue();
        } else if (operator.isDiv()) {
            result = leftOperand.getFormulaComponentValue() / rightOperand.getFormulaComponentValue();
        }
        
        stack.push(new ANumberImpl(result));
        
    }

    @Override
    public void visitANumber(ANumber aNumber) {
        stack.push(aNumber);
    }

    @Override
    public void visitCellCoordinate(CellCoordinate cellCoordinate) {
        //TODO: Same trick as on Function? (having the spreadsheet available here, to locate the cell)
        float cellContentFloatValue = spreadsheet.getCell(cellCoordinate).getCellContent().getFloatValue();
        stack.push(new ANumberImpl(cellContentFloatValue));
    }

    @Override
    public void visitFunction(Function function) {
        stack.push(function);
    }

    public float getResult() {
        return stack.pop().getFormulaComponentValue();
    }

}