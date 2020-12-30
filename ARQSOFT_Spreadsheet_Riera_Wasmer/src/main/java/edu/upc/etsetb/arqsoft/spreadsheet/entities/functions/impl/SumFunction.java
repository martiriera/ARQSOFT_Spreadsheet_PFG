/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.Argument;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class SumFunction extends FunctionImpl {

    @Override
    public String getName() {
        return "SUM";
    }

    @Override
    public float getValue() {
        float result = 0;
        for (Argument argument : argumentsArrayList) {
            result = result + argument.getValue();
        }
        return result;
    }

}
