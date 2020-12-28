/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.SpreadsheetFactory;
import java.util.List;

/**
 *
 * @author JuanCarlos
 */
public interface Tokenizer {
    
    /**
     * Sets the concrete factory for creating the concrete tokens of each 
     * implementation
     * 
     * @param factory the concrete factory
     */
    public void setFactory(SpreadsheetFactory factory) ;
    
    /**
     * Method that analizes the input String str and gets all the tokens that 
     * are present in it.
     * 
     * @param str the string containing the tokens
     * 
     * @throws BadTokenException if some non allowed character is present or some 
     * error happesn during the analysis of the string
     */
    public void tokenize(String str) throws BadTokenException ;
    
    /**
     * Method for returning an ordered list of found tokens in the input String.
     * 
     * @return the ordered list of tokens in the order they appeared in the 
     * input String
     */
    public List<Token> getResult() ;
    
}
