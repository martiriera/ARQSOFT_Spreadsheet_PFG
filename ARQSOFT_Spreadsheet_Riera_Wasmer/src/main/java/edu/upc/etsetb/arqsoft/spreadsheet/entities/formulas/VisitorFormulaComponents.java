/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.ANumber;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.CellCoordinate;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.Function;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class VisitorFormulaComponents implements Visitor {

    private Stack<FormulaComponent> stack = new Stack();
    private Spreadsheet spreadsheet;
    private SpreadsheetFactory factory;
    
    public VisitorFormulaComponents(Spreadsheet spreadsheet,SpreadsheetFactory factory ) {
        this.spreadsheet = spreadsheet;
        this.factory = factory;
    }

    @Override
    public void visitOperator(Operator operator) {
        double result = 0;
        
        FormulaComponent rightOperand = stack.pop();
        FormulaComponent leftOperand = stack.pop();

        result = operator.operate(leftOperand, rightOperand);
        stack.push(factory.createNumber(result));
    }

    @Override
    public void visitANumber(ANumber aNumber) {
        stack.push(aNumber);
    }

    @Override
    public void visitCellCoordinate(CellCoordinate cellCoordinate) {
        //TODO: Same trick as on Function? (having the spreadsheet available here, to locate the cell)
        Iterator it = spreadsheet.getMapKeys().iterator();
        while(it.hasNext()){
            System.out.println("Provided coord " + cellCoordinate);
            System.out.println("Map coord " + it.next());
            System.out.println(cellCoordinate.equals(((CellCoordinate) it.next())));
        }
        double cellContentDoubleValue = spreadsheet.getCell(cellCoordinate).getCellContent().getValueAsDouble();
        stack.push(factory.createNumber(cellContentDoubleValue));
    }

    @Override
    public void visitFunction(Function function) {
        stack.push(function);
    }

    public double getResult() {
        return stack.pop().getFormulaComponentValue();
    }
    
}