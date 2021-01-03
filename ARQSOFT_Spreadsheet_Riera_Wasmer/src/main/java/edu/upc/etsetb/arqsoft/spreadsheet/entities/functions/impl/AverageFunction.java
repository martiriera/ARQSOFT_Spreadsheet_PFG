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

    public float calculateFunction() {
        float average = 0;
        for (Argument argument : replaceCoordinatesByCells(argumentsArrayList)) {
            average = average + argument.getArgumentValue();
        }
        average = average / argumentsArrayList.size();

        return average;
    }

    @Override
    public float getArgumentValue() {
        return this.calculateFunction();
    }

    @Override
    public float getFormulaComponentValue() {
        return this.calculateFunction();
    }

}
