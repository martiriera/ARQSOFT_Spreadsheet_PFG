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
public interface SyntaxChecker {
    
    public void setFactory(SpreadsheetFactory factory) ;
    
    public List<Token> getTokens() ;
    
    public void check(String input) throws SyntaxException ;
    
}
