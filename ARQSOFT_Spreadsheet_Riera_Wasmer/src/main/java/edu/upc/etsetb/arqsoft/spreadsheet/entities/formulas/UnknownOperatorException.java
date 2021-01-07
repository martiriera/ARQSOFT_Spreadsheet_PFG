/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class UnknownOperatorException extends RuntimeException {

    /**
     * Creates a new instance of <code>UnknownOperatorException</code> without
     * detail message.
     */
    public UnknownOperatorException() {
    }

    /**
     * Constructs an instance of <code>UnknownOperatorException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UnknownOperatorException(String msg) {
        super(msg);
    }
}
