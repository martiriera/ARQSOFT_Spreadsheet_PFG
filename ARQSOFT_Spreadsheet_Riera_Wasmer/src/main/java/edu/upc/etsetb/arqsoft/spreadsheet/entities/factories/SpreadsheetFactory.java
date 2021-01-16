/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.factories;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.ANumber;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.impl.DefaultFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.FunctionsRegister;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Operand;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Operator;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.CellCoordinate;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Range;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Text;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.impl.MyFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Formula;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.PostFixGenerator;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.Token;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.Tokenizer;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.UnknownTokenTypeException;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.SyntaxChecker;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.TokenType;
import java.util.List;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.FormulaComponent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.FormulaEvaluator;

/**
 * The abstract factory class of the Abstract Factory Design Pattern; you will
 * have to modify the method getInstance for allowing to return YOUR concrete
 * factory and SUPPRESSING the return of DefaultFactory; when you do that, you
 * will have to remove the import of the DefaultFactory
 *
 */
public abstract class SpreadsheetFactory {

    public static final char EQUAL_CHAR = '=';

    public static SpreadsheetFactory getInstance(String which) throws UnkownFactoryException {
        if (which.toUpperCase().equals("DEFAULT")) {
            return new DefaultFactory();
        } else if (which.toUpperCase().equals("MYFACTORY")) {
            return new MyFactory();
        } else {
            throw new UnkownFactoryException("Unknown factory code \'" + which + "\'.");
        }
    }
    
    public abstract void setSpreadsheet(Spreadsheet spreadsheet);
    /**
    SpreadsheetFactory factory = SpreadsheetFactory.getInstance("MYFACTORY");
     */
    
    /**
     * Factory method for creating a new Token object.
     *
     * @param tokenType an object identifying the type of the token. The
     * specific object shall be implementation-dependent, and its
     * class/enumerated type shall be declared as implementing the TokenType
     * interface
     *
     * @param tokenText the text of the token
     *
     * @return the Token object. Its specific class will depend on the
     * implementation
     *
     * @throws UnknownTokenTypeException if the object passed as first argument
     * does not correspond to any token as per implementation
     */
    public abstract Token createToken(TokenType tokenType, String tokenText)
            throws UnknownTokenTypeException;

    /**
     * Factory method for creating a new Tokenizer
     *
     * @return the Tokenizer object
     */
    public abstract Tokenizer createTokenizer();

    /**
     * Factory method for creating a new SyntaxChecker
     *
     * @return the SyntaxChecker object
     */
    public abstract SyntaxChecker createSyntaxChecker();

    /**
     * Factory method for creating the object FunctionsRegister
     *
     * @return the FunctionsRegister object
     */
    public abstract FunctionsRegister createFunctionsRegister();

    /**
     * Factory method for creating a new PostFixGenerator
     *
     * @return the PostFixGenerator object
     */
    public abstract PostFixGenerator createPostFixGenerator();

    /**
     * Factory method for creating a new Operator.
     *
     * @param opText the operator text ("+", "/", "*", "-"
     * @return the created operator object
     */
    public abstract Operator createOperator(String opText) throws IllegalArgumentException;

    /**
     * Creates the object of one of the subclasses of Function corresponding to
     * the name passed as argument to the method.
     *
     * @param funcName the function name
     * @return the Function object
     * @throws IllegalArgumentException if there is a problem for creating the
     * object corresponding to the specific function
     */
    public abstract Operand createFunction(String funcName)
            throws IllegalArgumentException;

    /**
     * Creates a Cell coordinate object, whose value is the String passed as
     * argument to the method.
     *
     * @param cellCoord the coordinate of the cell
     * @return the object of class CellCoordinate
     *
     * @throws IllegalArgumentException if the String is not a correct cell
     * coordinate
     */
    public abstract CellCoordinate createCellCoordinate(String cellCoord) throws IllegalArgumentException;

    /**
     * Creates a Range object.
     *
     * @param range a string representing the range
     * @return the Range object created
     *
     * @throws IllegalArgumentException if the string passed as argument does
     * not correspond to any cells range.
     */
    /**
     * Creates a Range object.
     *
     * @param cCoord1 the cell coordinate of the first limit of the range
     * @param cCoord2 the cell coordinate of the second limit of the range
     * @return the Range object created
     * @throws IllegalArgumentException if some of the strings passed as
     * argument does not correspond to a cell coordinate.
     */
    public abstract Range createCellsRange(String cCoord1, String cCoord2) throws IllegalArgumentException;

    /**
     * Creates a number operand whose value is the numeric value represented by
     * the string passed as argument
     *
     * @param value the textual representation of the value of the number
     * @return the object number
     *
     * @throws IllegalArgumentException if the string passed does not represent
     * any number
     */
    public abstract ANumber createNumber(String value) throws IllegalArgumentException;

    public abstract ANumber createNumber(double val);

    public abstract Text createText(String value);
    /**
     * Creates a formula of operands and operators (formula components).
     *
     * @param comps the list of operands and operators (formula components) that
     * represent the formula.
     *
     * @return the expression object
     */
    public abstract Formula createFormula(List<FormulaComponent> comps);

    public abstract FormulaEvaluator createFormulaEvaluator();
}
