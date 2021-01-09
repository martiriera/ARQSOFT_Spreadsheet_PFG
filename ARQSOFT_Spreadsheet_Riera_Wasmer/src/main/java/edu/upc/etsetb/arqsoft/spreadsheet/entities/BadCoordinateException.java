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
public class BadCoordinateException extends Exception {

    /**
     * Creates a new instance of <code>BadCoordinateException</code> without
     * detail message.
     */
    public BadCoordinateException() {
    }

    /**
     * Constructs an instance of <code>BadCoordinateException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BadCoordinateException(String msg) {
        super(msg);
    }
}
