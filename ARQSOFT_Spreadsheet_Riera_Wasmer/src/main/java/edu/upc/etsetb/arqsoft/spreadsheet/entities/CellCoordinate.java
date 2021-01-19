/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.Operand;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.Argument;

/**
 *
 * @author JuanCarlos
 */
public interface CellCoordinate extends Operand, Argument {
    
    public String getColumnComponent();
    
    public int getRowComponent();

    public static boolean coordinateValidation(String coordinate) {
        // "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)" matches a position between a non-digit (\D) and a digit (\d)
        String[] separateCoordinate = coordinate.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)|(?<=\\d)(?=\\d)|(?<=\\D)(?=\\D)");
        return isValidColumn(separateCoordinate[0]) & isValidRow(separateCoordinate[1]);
    }

    public static boolean isValidRow(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }

        return true;
    }

    public static boolean isValidColumn(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= 'A' && c <= 'Z')) {
                return false;
            }
        }
        return true;

    }
    
    @Override
    public int hashCode();
    
    @Override
    public boolean equals(Object obj);
    
}
