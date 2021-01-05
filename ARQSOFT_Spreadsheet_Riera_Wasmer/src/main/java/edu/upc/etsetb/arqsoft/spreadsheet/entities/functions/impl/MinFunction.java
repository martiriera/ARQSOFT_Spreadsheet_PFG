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
public class MinFunction extends FunctionImpl {

    @Override
    public String getName() {
        return "MIN";
    }

    public double calculateFunction() {
        Iterator<Argument> it = replaceCoordinatesByCells(argumentsArrayList).iterator();
        double minValue = it.next().getArgumentValue();
        while (it.hasNext()) {
            if (it.next().getArgumentValue() < minValue) {
                minValue = it.next().getArgumentValue();
            }
        }
        return minValue;
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
