/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Operand;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.Argument;

/**
 *
 * @author JuanCarlos
 */
public interface ANumber extends Content, Argument, Operand {
    @Override
    float getValue();
}
