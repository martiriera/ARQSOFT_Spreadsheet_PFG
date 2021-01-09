/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.FunctionsRegister;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.Token;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.Tokenizer;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.UnknownTokenTypeException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Operator;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.ANumber;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.ANumberImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.CellCoordinate;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.CellCoordinateImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Range;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Text;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.TextImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Formula;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.PostFixGenerator;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.impl.SyntaxCheckerImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.impl.PostFixGeneratorImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.impl.TokenImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.impl.TokenizerImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.SyntaxChecker;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.TokenType;
import java.util.List;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.FormulaComponent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.FormulaEvaluator;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.FormulaImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.Function;

/**
 *
 * @author JuanCarlos
 */
public class MyFactory extends SpreadsheetFactory {

    @Override
    public Token createToken(TokenType tokenType, String tokenText) throws UnknownTokenTypeException {
        if (!(tokenType instanceof TokenType)) {
            throw new UnknownTokenTypeException("The object passed as token type, whose class is \'"
                    + tokenType.getClass().getName() + "\'");
        }
        return TokenImpl.getInstance((TokenType) tokenType, tokenText);
    }

    @Override
    public Tokenizer createTokenizer() {
        return TokenizerImpl.getInstance();
    }

    @Override
    public SyntaxChecker createSyntaxChecker() {
        return SyntaxCheckerImpl.getInstance();
    }

    @Override
    public PostFixGenerator createPostFixGenerator() {
        return PostFixGeneratorImpl.getInstance();
    }

    @Override
    public Operator createOperator(String opText) throws IllegalArgumentException {
        throw new UnsupportedOperationException("createOperator() not supported yet.");
    }

    @Override
    public Function createFunction(String funcName)
            throws IllegalArgumentException {
        throw new UnsupportedOperationException("createFunction() not supported yet.");
    }

    @Override
    public FunctionsRegister createFunctionsRegister() {
        throw new UnsupportedOperationException("createFunctionsRegister() not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CellCoordinate createCellCoordinate(String cellCoord) {
        // (?<=\\D)(?=\\d) matches a position between a non-digit (\D) and a digit (\d)
        String[] separateCoordinate = cellCoord.split("(?<=\\D)(?=\\d)");
        return new CellCoordinateImpl(separateCoordinate[0], Integer.parseInt(separateCoordinate[1]));
    }

    @Override
    public Range createCellsRange(String cCoord1, String cCoord2)
            throws IllegalArgumentException {
        throw new UnsupportedOperationException("createCellsRange() not supported yet.");
    }

    @Override
    public ANumber createNumber(String value) throws IllegalArgumentException {
        throw new UnsupportedOperationException("createNumber() not supported yet.");
    }

    @Override
    public Formula createFormula(List<FormulaComponent> comps) {
        return new FormulaImpl(comps);
    }

    @Override
    public ANumber createNumber(double val) {
        return new ANumberImpl(val);
    }

    @Override
    public FormulaEvaluator createFormulaEvaluator() {
        return new FormulaEvaluator();
    }

    @Override
    public Text createText(String value) {
        return new TextImpl(value);
    }

}
