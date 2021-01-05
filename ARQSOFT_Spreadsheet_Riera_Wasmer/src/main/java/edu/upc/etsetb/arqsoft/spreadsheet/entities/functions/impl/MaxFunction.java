/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.Argument;
import java.util.Iterator;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class MaxFunction extends FunctionImpl {

    @Override
    public String getName() {
        return "MAX";
    }

    public double calculateFunction() {
        Iterator<Argument> it = replaceCoordinatesByCells(argumentsArrayList).iterator();
        double maxValue = it.next().getArgumentValue();
        while (it.hasNext()) {
            if (it.next().getArgumentValue() > maxValue) {
                maxValue = it.next().getArgumentValue();
            }
        }
        return maxValue;
    }

    @Override
    public double getArgumentValue() {
        return this.calculateFunction();
    }

    @Override
    public double getFormulaComponentValue() {
       return this.calculateFunction();
    }

}
