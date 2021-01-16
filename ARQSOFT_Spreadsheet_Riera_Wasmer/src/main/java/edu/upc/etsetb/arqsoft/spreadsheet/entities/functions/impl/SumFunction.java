/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.Cell;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.CellCoordinate;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.CellCoordinateImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.RangeImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.Argument;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
public class SumFunction extends FunctionImpl {

    Spreadsheet spreadsheet;

    public SumFunction(Spreadsheet spreadsheet) {
        this.spreadsheet = spreadsheet;
    }

    @Override
    public String getName() {
        return "SUM";
    }

    public double calculateFunction() {
        double result = 0;
        for (Argument argument : replaceCoordinatesByCells(argumentsArrayList)) {
            result = result + argument.getArgumentValue();
        }
        return result;
    }

    // TODO: Review gets
    @Override
    public double getArgumentValue() {
        return this.calculateFunction();
    }

    @Override
    public double getFormulaComponentValue() {
        return this.calculateFunction();
    }

    public ArrayList<Argument> replaceCoordinatesByCells(ArrayList<Argument> args) {
        ArrayList<Argument> outputArgs = new ArrayList<Argument>();
        for (Argument argument : args) {
            if (argument instanceof CellCoordinateImpl) {
                outputArgs.add(spreadsheet.getCell((CellCoordinateImpl) argument));
            } else if (argument instanceof RangeImpl) {
                HashMap<CellCoordinate, Cell> rangeMap = spreadsheet.fillRangeOfCells((RangeImpl) argument);
                Iterator it = rangeMap.values().iterator();
                while (it.hasNext()) {
                    outputArgs.add((Cell) it.next());
                }
            } else {
                outputArgs.add(argument);
            }
        }
        return outputArgs;
    }

}
