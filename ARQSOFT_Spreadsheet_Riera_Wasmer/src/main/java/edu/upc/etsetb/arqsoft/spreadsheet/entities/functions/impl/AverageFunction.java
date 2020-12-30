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
public class AverageFunction extends FunctionImpl {

    @Override
    public String getName() {
        return "AVG";
    }

    @Override
    public float getValue() { 
        float average = 0;
        for (Argument argument : argumentsArrayList) {
            average = average + argument.getValue();
        }
        average = average / argumentsArrayList.size();
        
        return average;
    }

}
