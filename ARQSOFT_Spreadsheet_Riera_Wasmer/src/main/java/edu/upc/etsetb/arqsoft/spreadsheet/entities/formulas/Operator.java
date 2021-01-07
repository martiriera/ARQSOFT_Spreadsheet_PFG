/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas;

/**
 * You will have to create the class(es) that you consider suitable for 
 * managing the arithmetic operators; the method listed is the method required 
 * by the postfix generator class; it is your job to identify, design, and 
 * code any other method that your complete program may require from this(these)
 * class(es).
 * 
 * @author JuanCarlos
 */
public interface Operator extends FormulaComponent{
        
    /**
     * Reports whether the operator is the addition (+) operator
     * 
     * @return true if the operator is the addition (+) operator, false otherwise
     */
    public boolean isAdd() ;
    
    /**
     * Reports whether the operator is the substraction (-) operator
     * 
     * @return true if the operator is the addition (-) operator, false otherwise
     */    
    public boolean isSubs() ;
    
    /**
     * Reports whether the operator is the multiplication (*) operator
     * 
     * @return true if the operator is the multiplication (*) operator, false otherwise
     */    
    public boolean isMult() ;
    
    /**
     * Reports whether the operator is the division (/) operator
     * 
     * @return true if the operator is the division (/) operator, false otherwise
     */    
    public boolean isDiv() ;

    public double operate(FormulaComponent leftOperand, FormulaComponent rightOperand);
    
}
