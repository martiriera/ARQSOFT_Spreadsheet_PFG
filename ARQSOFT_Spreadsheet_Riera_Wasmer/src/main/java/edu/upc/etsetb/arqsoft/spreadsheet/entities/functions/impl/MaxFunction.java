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

    @Override //TODO: Revisar que faci el que toca
    public float getValue() {
        Iterator<Argument> it = argumentsArrayList.iterator();
        float maxValue = it.next().getValue();
        while (it.hasNext()) {
            if (it.next().getValue() > maxValue) {
                maxValue = it.next().getValue();
            }
        }
        return maxValue;
    }

}
