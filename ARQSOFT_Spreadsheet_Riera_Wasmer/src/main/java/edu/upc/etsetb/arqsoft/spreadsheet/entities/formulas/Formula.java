/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.Content;
import java.util.List;

/**
 *
 * @author JuanCarlos
 */
public interface Formula extends Content {

    public void setFormulaString(String formulaString);
    
    public String getFormulaString();
    
    public void setFormulaResult(double formulaResult);
    
    public List<FormulaComponent> getFormulaComponents();
}
