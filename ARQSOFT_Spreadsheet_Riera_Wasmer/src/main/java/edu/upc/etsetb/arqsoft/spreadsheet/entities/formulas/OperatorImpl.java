/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class OperatorImpl implements Operator {

    String operator;

    public OperatorImpl(String operator) {
        this.operator = operator;
    }

    @Override
    public boolean isAdd() {
        return "+".equals(operator);
    }

    @Override
    public boolean isSubs() {
        return "-".equals(operator);

    }

    @Override
    public boolean isMult() {
        return "*".equals(operator);
    }

    @Override
    public boolean isDiv() {
        return "/".equals(operator);
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitOperator(this);
    }

    @Override
    public double getFormulaComponentValue() {
        throw new UnsupportedOperationException("OperatorImpl Exception");
    }

    @Override
    public double operate(FormulaComponent leftOperand, FormulaComponent rightOperand) {
        if (this.isAdd()) {
            return leftOperand.getFormulaComponentValue() + rightOperand.getFormulaComponentValue();
        } else if (this.isSubs()) {
            return leftOperand.getFormulaComponentValue() - rightOperand.getFormulaComponentValue();
        } else if (this.isMult()) {
            return leftOperand.getFormulaComponentValue() * rightOperand.getFormulaComponentValue();
        } else if (this.isDiv()) {
            return leftOperand.getFormulaComponentValue() / rightOperand.getFormulaComponentValue();
        }
        throw new UnknownOperatorException("Unknown Operator: " + this.operator);

    }

}
