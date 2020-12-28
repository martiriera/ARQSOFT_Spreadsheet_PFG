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
public class MaxFunction implements Function {

    private ArrayList<Argument> argumentsArrayList;

    @Override
    public void addArgument(Argument arg) {
        argumentsArrayList.add(arg);
    }

    @Override
    public String getName() {
        return "MAX";
    }

    @Override
    public float calculateFunction() {
        float maxValue = argumentsArrayList.get(0).getValue();
        for (int i = 1; i < argumentsArrayList.size(); i++) {
            if (argumentsArrayList.get(i).getValue() > maxValue) {
                maxValue = argumentsArrayList.get(i).getValue();
            }
        }
        return maxValue;
    }
}
