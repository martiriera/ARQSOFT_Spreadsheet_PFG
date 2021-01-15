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
import edu.upc.etsetb.arqsoft.spreadsheet.entities.RangeImpl;
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
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.OperatorImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.Function;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.impl.AverageFunction;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.impl.FunctionImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.impl.FunctionRegisterImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.impl.MaxFunction;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.impl.MinFunction;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.impl.SumFunction;

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
        OperatorImpl op = new OperatorImpl(opText);
        if (op.isAdd() || op.isDiv() || op.isMult() || op.isSubs()) {
            return op;
        } else {
            throw new IllegalArgumentException("Illegal operator");
        }
    }

    @Override
    public Function createFunction(String funcName) throws IllegalArgumentException {
        FunctionsRegister fr = this.createFunctionsRegister();
        if (fr.isRegistered(funcName)) {
            switch (funcName) {
                case "SUM":
                    return new SumFunction();
                case "AVG":
                    return new AverageFunction();
                case "MAX":
                    return new MaxFunction();
                default:
                    return new MinFunction();
            }
        } else {
            throw new IllegalArgumentException("Illegal function (not registered)");
        }
    }

    @Override
    public FunctionsRegister createFunctionsRegister() {
        return new FunctionRegisterImpl();
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
        if (!CellCoordinate.coordinateValidation(cCoord1)) {
            throw new IllegalArgumentException("First range coordinate format is incorrect");
        } else if (!CellCoordinate.coordinateValidation(cCoord2)) {
            throw new IllegalArgumentException("Second range coordinate format is incorrect");
        } else {
            String[] separateCoordinate1 = cCoord1.split("(?<=\\D)(?=\\d)");
            String[] separateCoordinate2 = cCoord2.split("(?<=\\D)(?=\\d)");
            CellCoordinateImpl coord1 = new CellCoordinateImpl(separateCoordinate1[0], Integer.parseInt(separateCoordinate1[1]));
            CellCoordinateImpl coord2 = new CellCoordinateImpl(separateCoordinate2[0], Integer.parseInt(separateCoordinate2[1]));
            return new RangeImpl(coord1, coord2);
        }
    }

    @Override
    public ANumber createNumber(String value) throws IllegalArgumentException {
        try {
            return new ANumberImpl(Double.parseDouble(value));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
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
