/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// CHANGE THE PACKAGE AT YOUR CONVENIENCE
package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

// CHANGE THESE IMPORTS AS PER YOUR OWN PACKAGES
import edu.upc.etsetb.arqsoft.entities.parser.ParserS2V;
import edu.upc.etsetb.arqsoft.entities.ui.UserInterface;
import edu.upc.etsetb.arqsoft.entities.ui.UserInterfaceImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.BadCoordinateException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.CellCoordinate;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.CellCoordinateImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.ContentException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.SpreadsheetHashMapImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.UnkownFactoryException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formulas.FormulaEvaluator;
import java.util.HashMap;

// KEEP THESE IMPORTS (for JUnit 4.12)
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class ParserTest {

    // DECLARE THE INSTANCE AS A REFERENCE OF AN OBJECT TO YOUR SPREADSHEET INTERFACE OR CLASS
    private Spreadsheet instance;
    private ParserS2V parser;
    UserInterface ui;

    public ParserTest()
            throws ContentException, UnkownFactoryException, BadCoordinateException {
        // IMPORTANT: REPLACE WITH A SET OF SENTENCES THAT GENERATE AN 
        // ENVIRONMENT READY FOR SETTING CONTENTS IN CELLS OF THE SPREADSHEET 
        // AND FOR COMPUTING VALUES FOR THESE CONTENTS.
        SpreadsheetFactory factory = SpreadsheetFactory.getInstance("MYFACTORY");
        parser = new ParserS2V();
        parser.setFactory(factory);
        instance = parser.generateSpreadsheetFromContents(parser.getContentsFromFile("/home/reir/Desktop/s2v_test.txt"));
        this.instance.setFactory(factory);
        FormulaEvaluator formEvaluator = factory.createFormulaEvaluator();
        formEvaluator.setFactory(factory);
        formEvaluator.setSheet(instance);
        this.instance.setFormulaEvaluator(formEvaluator);

        ui = new UserInterfaceImpl();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void testParser() throws Exception {
//        instance = parser.generateSpreadsheet(parser.getAllContents("/home/reir/Desktop/s2v_test.txt"));
//    }
//    
//    @Test
//    public void testParserBeyZ() throws Exception {
//        instance = parser.generateSpreadsheetFromContents(parser.getContentsFromFile("/home/reir/Desktop/s2v_test_beyond_z.txt"));
//    }
//    @Test
//    public void testPrinter() throws Exception {
//        ui.printSpreadSheet(instance);
//    }

    @Test
    public void testParserFile() throws Exception {
        parser.generateFileFromSpreadsheet(instance, "/home/reir/Desktop/toFile_test.txt");
    }

}
