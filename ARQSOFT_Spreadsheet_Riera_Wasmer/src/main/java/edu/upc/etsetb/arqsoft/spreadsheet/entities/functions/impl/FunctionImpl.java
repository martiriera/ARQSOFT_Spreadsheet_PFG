/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.Cell;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.CellCoordinateImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.RangeImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Visitor;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.Argument;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public abstract class FunctionImpl implements Function {

    protected ArrayList<Argument> argumentsArrayList;
//    protected Spreadsheet spreadsheet;

    public FunctionImpl() {
        this.argumentsArrayList = new ArrayList<>();
    }

    @Override
    public void addArgument(Argument arg) {
        argumentsArrayList.add(arg);
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitFunction(this);
    }
    
    //TODO: Validate this substitution
    //TODO: Cal que els args segueixin amb al matiex ordre que tal com arriben?
//    public ArrayList<Argument> replaceCoordinatesByCells(ArrayList<Argument> args) {
//        for (Argument argument : args) {
//            if (argument instanceof CellCoordinateImpl) {
//                args.set(args.indexOf(argument), spreadsheet.getCell((CellCoordinateImpl) argument));
//            }else if(argument instanceof RangeImpl){
//                Iterator it = ((RangeImpl) argument).cellRangeMap.values().iterator();
//                while(it.hasNext()){
//                    args.add((Cell) it.next());
//                }
//            }
//        }
//        return args;
//    }
}
