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

    public float calculateFunction() {
        Iterator<Argument> it = replaceCoordinatesByCells(argumentsArrayList).iterator();
        float minValue = it.next().getArgumentValue();
        while (it.hasNext()) {
            if (it.next().getArgumentValue() < minValue) {
                minValue = it.next().getArgumentValue();
            }
        }
        return minValue;
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
