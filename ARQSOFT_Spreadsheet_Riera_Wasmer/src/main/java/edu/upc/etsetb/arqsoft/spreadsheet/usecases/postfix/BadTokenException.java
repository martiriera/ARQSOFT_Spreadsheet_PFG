/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix;


/**
 *
 * @author JuanCarlos
 */
public class BadTokenException extends Exception{

    /**
     * Creates a new instance of <code>SyntaxException</code> without detail
     * message.
     */
    public BadTokenException() {
    }

    /**
     * Constructs an instance of <code>SyntaxException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public BadTokenException(String msg) {
        super(msg);
    }
}
