/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.EvaluatorPostFix;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Formula;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.FormulaComponent;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.BadTokenException;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.FormulaException;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.PostFixGenerator;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.SyntaxChecker;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.Token;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.Tokenizer;
import java.util.List;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class SpreadsheetController {

    Spreadsheet spreadsheet;
    SpreadsheetFactory factory;
    //TODO: Afegir atribut interfície d'usuari

    public SpreadsheetController(Spreadsheet spreadsheet, SpreadsheetFactory factory) {
        this.spreadsheet = spreadsheet;
        this.factory = factory;
    }

    public void classifyInputContent(String inputContent) throws BadTokenException, FormulaException {
        // declaración de switch
        if (inputContent.charAt(0) == '=') {
            String formulaString = inputContent.substring(1);
            try {
                Tokenizer tokenizer = factory.createTokenizer();
                SyntaxChecker syntaxChecker = factory.createSyntaxChecker();
                PostFixGenerator postfixGenerator = factory.createPostFixGenerator();

                tokenizer.tokenize(formulaString);
                List<Token> tokenList = tokenizer.getResult();
                postfixGenerator.generateFromTokens(tokenList);
                List<FormulaComponent> formulaComponentList = postfixGenerator.getResultQueue();
                
                Formula formula = factory.createFormula(formulaComponentList);
                
                EvaluatorPostFix evaluator = new EvaluatorPostFix(spreadsheet, factory);
                double formulaResult = evaluator.evaluatePostFix(formulaComponentList);
                //TODO: Trobar lloc on s'ha de fer aixo i ordre
                   
            } catch (BadTokenException e) {

            };
        }//TODO: Comprovar la resta de possibles inputs
    }
}
