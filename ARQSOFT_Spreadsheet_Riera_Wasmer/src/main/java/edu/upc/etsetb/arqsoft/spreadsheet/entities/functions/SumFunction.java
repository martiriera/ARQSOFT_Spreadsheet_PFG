/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions;

import java.util.ArrayList;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class SumFunction implements Function {

    private ArrayList<Argument> argumentsArrayList;

    @Override
    public void addArgument(Argument arg) {
        argumentsArrayList.add(arg);
    }

    @Override
    public String getName() {
        return "SUM";
    }

    @Override
    public float calculateFunction() {
        float result = 0;
        for (Argument argument : argumentsArrayList) {
            result = result + argument.getValue();
        }
        return result;
    }

    @Override
    public float getValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
