/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.entities.ui;

import edu.upc.etsetb.arqsoft.entities.parser.Parser;
import edu.upc.etsetb.arqsoft.entities.parser.ParserS2V;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.SpreadsheetHashMapImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.UnkownFactoryException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.FormulaEvaluator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Víctor Wasmer and Martí Riera
 */
class Main {

    public static void main(String[] args) throws IOException, UnkownFactoryException {
        final UserInterface ui = new UserInterfaceImpl();
        final SpreadsheetFactory factory = SpreadsheetFactory.getInstance("MYFACTORY");
        final Parser parser = new ParserS2V();
        Spreadsheet controller = new SpreadsheetHashMapImpl();

        parser.setFactory(factory);
        FormulaEvaluator formEvaluator = factory.createFormulaEvaluator();
        formEvaluator.setFactory(factory);

        String path = ui.initSpreadsheetDialog();
        if (!path.isEmpty()) {
            boolean validPath = false;
            while (validPath == false) {
                try {
                    ArrayList<String[]> contents = parser.getContentsFromFile(path);
                    controller = parser.generateSpreadsheetFromContents(contents);
                    validPath = true;
                } catch (FileNotFoundException e) {
                    System.out.println("File \"" + path + "\" not found\n");
                    path = ui.initSpreadsheetDialog();
                    if (path.isEmpty()) {
                        validPath = true;
                    };
                }
            }
        }
        controller.setFactory(factory);
        controller.setFormulaEvaluator(formEvaluator);
        formEvaluator.setSheet(controller);
        ui.printSpreadSheet(controller);
    }
}
