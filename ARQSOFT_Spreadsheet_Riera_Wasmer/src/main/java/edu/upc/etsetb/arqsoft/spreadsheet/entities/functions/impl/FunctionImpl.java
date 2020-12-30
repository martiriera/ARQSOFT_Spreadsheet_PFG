/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.Argument;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.Function;
import java.util.ArrayList;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public abstract class FunctionImpl implements Function {

    protected ArrayList<Argument> argumentsArrayList;

    @Override
    public void addArgument(Argument arg) {
        argumentsArrayList.add(arg);
    }
}
