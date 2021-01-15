/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.FunctionsRegister;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class FunctionRegisterImpl implements FunctionsRegister {

    @Override
    public boolean isRegistered(String funcName) {
        for (FunctionType c : FunctionType.values()) {
            if (c.name().equals(funcName)) {
                return true;
            }
        }
        return false;
    }

}
