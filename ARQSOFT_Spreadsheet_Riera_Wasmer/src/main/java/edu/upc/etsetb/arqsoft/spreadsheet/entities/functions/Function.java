/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Operand;

/**
 *
 * @author JuanCarlos
 */
public interface Function extends Argument, Operand {

    public void addArgument(Argument arg);

    public String getName();

    public float calculateFunction();
}
