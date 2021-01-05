/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities;

import static java.lang.Float.parseFloat;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class TextImpl implements Text {

    public String value;

    public TextImpl(String value) {
        this.value = value;
    }

    @Override
    public String getValueAsString() {
        return value;
    }

    @Override
    public double getValueAsDouble() {
        throw new UnsupportedOperationException("TextImpl Exception");
    }

}
