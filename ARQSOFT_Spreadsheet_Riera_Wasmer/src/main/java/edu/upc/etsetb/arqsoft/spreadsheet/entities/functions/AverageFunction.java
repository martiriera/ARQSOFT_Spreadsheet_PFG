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
public class AverageFunction implements Function {

    private ArrayList<Argument> argumentsArrayList;

    @Override
    public void addArgument(Argument arg) {
        argumentsArrayList.add(arg);
    }

    @Override
    public String getName() {
        return "AVG";
    }

    @Override
    public float calculateFunction() {
        float average = 0;
        for (Argument argument : argumentsArrayList) {
            average = average + argument.getValue();
        }
        average = average / argumentsArrayList.size();
        
        return average;
    }

}
