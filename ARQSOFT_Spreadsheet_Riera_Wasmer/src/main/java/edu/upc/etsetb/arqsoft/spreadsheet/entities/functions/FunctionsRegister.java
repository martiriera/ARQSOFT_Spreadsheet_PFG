/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions;

/**
 *
 * @author JuanCarlos
 */
public interface FunctionsRegister{

/**
 * Reports whether a certain function name is registered as a function 
 * implemented in the program.
 * 
 * @param funcName the name of the function
 * @return true if the name is registered, false otherwise
 */    
    public boolean isRegistered(String funcName) ;
}
