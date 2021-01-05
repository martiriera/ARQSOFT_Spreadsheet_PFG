/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Formula;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public interface Content {
    public float getFloatValue();
    public String getStringValue();
    public String getFormula();
}
