/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// CHANGE THE PACKAGE AT YOUR CONVENIENCE
package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

// CHANGE THESE IMPORTS AS PER YOUR OWN PACKAGES
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
public class FunctionsTest {

    // DECLARE THE INSTANCE AS A REFERENCE OF AN OBJECT TO YOUR SPREADSHEET INTERFACE OR CLASS
    private Spreadsheet instance;

    public FunctionsTest()
            throws ContentException, UnkownFactoryException, BadCoordinateException {
        // IMPORTANT: REPLACE WITH A SET OF SENTENCES THAT GENERATE AN 
        // ENVIRONMENT READY FOR SETTING CONTENTS IN CELLS OF THE SPREADSHEET 
        // AND FOR COMPUTING VALUES FOR THESE CONTENTS.
        this.instance = new SpreadsheetHashMapImpl();
        SpreadsheetFactory factory = SpreadsheetFactory.getInstance("MYFACTORY");
        this.instance.setFactory(factory);
        FormulaEvaluator formEvaluator = factory.createFormulaEvaluator();
        formEvaluator.setFactory(factory);
        formEvaluator.setSheet(instance);
        this.instance.setFormulaEvaluator(formEvaluator);

        //IMPORTANT: KEEP THE SENTENCES BELOW.
        instance.setCellContent("A1", "1");
        instance.setCellContent("A2", "2");
        instance.setCellContent("A3", "3");
        instance.setCellContent("A4", "4");
        instance.setCellContent("A5", "5");
        instance.setCellContent("A6", "6");
        instance.setCellContent("A7", "7");
        instance.setCellContent("A8", "8");
        instance.setCellContent("A9", "9");
        instance.setCellContent("A10", "10");
        instance.setCellContent("A11", "11");
        instance.setCellContent("A12", "12");
        instance.setCellContent("A13", "13");
        instance.setCellContent("A14", "14");
        instance.setCellContent("A15", "15");
        instance.setCellContent("A16", "16");
        instance.setCellContent("A17", "17");
        instance.setCellContent("A18", "18");
        instance.setCellContent("A19", "19");
        instance.setCellContent("A20", "20");
        instance.setCellContent("A21", "21");
        instance.setCellContent("A22", "22");
        instance.setCellContent("A23", "23");
        instance.setCellContent("A24", "24");
        instance.setCellContent("C1", "This is a string");
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
//    public void testSetSum1() throws Exception {
//        System.out.println("setting cell content to a formula with: numbers, "
//                + "cell references, function (arguments: numbers)");
//        this.instance.setCellContent("B7", "=SUMA(1;2;-3;4;5)");
//        double content = this.instance.getCellContentAsDouble("B7");
//        Assert.assertEquals(9.0, content, 0.0);
//    }

//    @Test
//    public void testSetMax1() throws Exception {
//        System.out.println("setting cell content to a formula with: numbers, "
//                + "cell references, function (arguments: numbers)");
//        this.instance.setCellContent("B7", "=MAX(1;1;3'2;4;5'9)");
//        double content = this.instance.getCellContentAsDouble("B7");
//        Assert.assertEquals(5.9, content, 0.0);
//    }
//
//    @Test
//    public void testSetMax2() throws Exception {
//        System.out.println("setting cell content to a formula with: numbers, "
//                + "cell references, function (arguments: numbers)");
//        this.instance.setCellContent("B7", "=MAX(1;-1;3.2;4;5.9;5.9)");
//        double content = this.instance.getCellContentAsDouble("B7");
//        Assert.assertEquals(5.9, content, 0.0);
//    }
//    
//    @Test
//    public void testSetAvg1() throws Exception {
//        System.out.println("setting cell content to a formula with: numbers, "
//                + "cell references, function (arguments: numbers)");
//        this.instance.setCellContent("B7", "=AVG(1;2)");
//        double content = this.instance.getCellContentAsDouble("B7");
//        Assert.assertEquals(1.5, content, 0.0);
//    }
//    
//    @Test
//    public void testSetMin1() throws Exception {
//        System.out.println("setting cell content to a formula with: numbers, "
//                + "cell references, function (arguments: numbers)");
//        this.instance.setCellContent("B7", "=MIN(5.9;-3.2;5.6;-8)");
//        double content = this.instance.getCellContentAsDouble("B7");
//        Assert.assertEquals(-8, content, 0.0);
//    }


}
