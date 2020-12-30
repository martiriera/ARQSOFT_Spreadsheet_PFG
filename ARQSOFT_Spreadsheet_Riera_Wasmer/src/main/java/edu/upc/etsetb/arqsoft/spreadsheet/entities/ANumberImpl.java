/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class ANumberImpl implements ANumber {

    public float value; 

    public ANumberImpl(float value) {
        this.value = value;
    }

    @Override
    public float getValue() {
        return value;
    }

}
