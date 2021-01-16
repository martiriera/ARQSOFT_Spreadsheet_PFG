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
public class SpreadsheetTest {

    // DECLARE THE INSTANCE AS A REFERENCE OF AN OBJECT TO YOUR SPREADSHEET INTERFACE OR CLASS
    private Spreadsheet instance;

    public SpreadsheetTest()
            throws ContentException, UnkownFactoryException, BadCoordinateException {
        // IMPORTANT: REPLACE WITH A SET OF SENTENCES THAT GENERATE AN 
        // ENVIRONMENT READY FOR SETTING CONTENTS IN CELLS OF THE SPREADSHEET 
        // AND FOR COMPUTING VALUES FOR THESE CONTENTS.
        this.instance = new SpreadsheetHashMapImpl();
        SpreadsheetFactory factory = SpreadsheetFactory.getInstance("MYFACTORY");
        factory.setSpreadsheet(this.instance);
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
//    public void testSetCellContent_TextContent() throws Exception {
//        System.out.println("setting cell content to a text");
//        String content = this.instance.getCellContentAsString("C1");
//        Assert.assertEquals("This is a string", content);
//    }
//    /**
//     * Test of setCellContent method, of class SpreadsheetImpl.
//     */
//    @Test
//    public void testSetCellContent_NumContent() throws Exception {
//        System.out.println("setting cell content to a number");
//        double content = this.instance.getCellContentAsDouble("A24");
//        Assert.assertEquals(24.0, content, 0);
//    }
//
//    @Test
//    public void testSetCellContent_Formula_Numbers() throws Exception {
//        System.out.println("setting cell content to a formula with: numbers");
//        this.instance.setCellContent("B1", "=1+2");
//        double content = this.instance.getCellContentAsDouble("B1");
//        Assert.assertEquals(3.0, content, 0.0);
//    }
//
//    @Test
//    public void testSetCellContent_Formula_Numbers_1LevelRBs() throws Exception {
//        System.out.println("setting cell content to a formula with: numbers, "
//                + "1 level of round brackets");
//        this.instance.setCellContent("B2", "=20/(5+5)");
//        double content = this.instance.getCellContentAsDouble("B2");
//        Assert.assertEquals(2.0, content, 0.0);
//    }
//
//    @Test
//    public void testSetCellContent_Formula_Numbers_2Level2RBs() throws Exception {
//        System.out.println("setting cell content to a formula with: numbers, "
//                + "2 levels of round brackets");
//        this.instance.setCellContent("B3", "=100/(5+(25/5))");
//        double content = this.instance.getCellContentAsDouble("B3");
//        Assert.assertEquals(10.0, content, 0.0);
//    }

//    @Test
//    public void testSetCellContent_Formula_Numbers_CellRefs() throws Exception {
//        System.out.println("setting cell content to a formula with: numbers, "
//                + "cell references");
//        this.instance.setCellContent("B4", "=A1*10-5");
//        double content = this.instance.getCellContentAsDouble("B4");
//        Assert.assertEquals(5.0, content, 0.0);
//    }
//
//    @Test
//    public void testSetCellContent_Formula_Numbers_CellRefs_1LevelRBs() throws Exception {
//        System.out.println("setting cell content to a formula with: numbers, "
//                + "cell references, 1 level of round brackets");
//        this.instance.setCellContent("B5", "=(A5*4)/(A2+A2)");
//        double content = this.instance.getCellContentAsDouble("B5");
//        Assert.assertEquals(5.0, content, 0.0);
//    }
//
//    @Test
//    public void testSetCellContent_Formula_Numbers_CellRefs_2Level2RBs() throws Exception {
//        System.out.println("setting cell content to a formula with: numbers, "
//                + "cell references, 2 levels of round brackets");
//        this.instance.setCellContent("B6", "=100/(A5+(A5*A5/5))");
//        double content = this.instance.getCellContentAsDouble("B6");
//        Assert.assertEquals(10.0, content, 0.0);
//    }
//
//    @Test
//    public void testSetCellContent_Formula_Numbers_CellRefs_Func_NumArgs() throws Exception {
//        System.out.println("setting cell content to a formula with: numbers, "
//                + "cell references, function (arguments: numbers)");
//        this.instance.setCellContent("B7", "=(A5*4)/(A2+A2)+SUM(1;2;3;4;5)");
//        double content = this.instance.getCellContentAsDouble("B7");
//        Assert.assertEquals(20.0, content, 0.0);
//    }
    
//
//    @Test
//    public void testSetCellContent_Formula_Numbers_CellRefs_Func_NumCellRefsArgs() throws Exception {
//        System.out.println("setting cell content to a formula with: numbers, "
//                + "cell references, function (arguments: numbers, cell "
//                + "references)");
//        this.instance.setCellContent("B8", "=(A5*4)/(A2+A2)+SUM(A1;A2;3;4;5)");
//        double content = this.instance.getCellContentAsDouble("B8");
//        Assert.assertEquals(20.0, content, 0.0);
//    }
//
//    @Test
//    public void testSetCellContent_Formula_Numbers_CellRefs_Func_NumCellRefsRangesArgs() throws Exception {
//        System.out.println("setting cell content to a formula with: numbers, "
//                + "cell references, function (arguments: numbers,cell "
//                + "references,ranges)");
//        this.instance.setCellContent("B9", "=(A5*4)/(A2+A2)+SUM(A1;A2;3;4;5;A6:A12)");
//        double content = this.instance.getCellContentAsDouble("B9");
//        Assert.assertEquals(83.0, content, 0.0);
//    }
//
    @Test
    public void testSetCellContent_Formula_Numbers_CellRefs_Func_NumCellRefsRangesFunctionsArgs_1() throws Exception {
        System.out.println("setting cell content to a formula with: numbers, "
                + "cell references, function (arguments: numbers,cell "
                + "references,ranges,functions) - case 1");
        this.instance.setCellContent("B10", "=(A5*4)/(A2+A2)+SUM(A1;A2;3;4;5;A6:A12;MIN(A13:A20))"
                + "");
        double content = this.instance.getCellContentAsDouble("B10");
        Assert.assertEquals(96.0, content, 0.0);
    }

    @Test
    public void testSetCellContent_Formula_Numbers_CellRefs_Func_NumCellRefsRangesFunctionsArgs_2() throws Exception {
        System.out.println("setting cell content to a formula with: numbers, "
                + "cell references, function (arguments: numbers,cell "
                + "references,ranges,functions) - case 2");
        this.instance.setCellContent("B11", "=(A5*4)/(A2+A2)+SUM(A1;A2;3;4;5;"
                + "A6:A12;MAX(A13:A20))"
                + "");
        double content = this.instance.getCellContentAsDouble("B11");
        Assert.assertEquals(103.0, content, 0.0);
    }

    @Test
    public void testSetCellContent_Formula_Numbers_CellRefs_Func_NumCellRefsRangesFunctionsArgs_3() throws Exception {
        System.out.println("setting cell content to a formula with: numbers, "
                + "cell references, function (arguments: numbers,cell "
                + "references,ranges,functions) - case 3");
        this.instance.setCellContent("B12", "=(A5*4)/(A2+A2)+SUM(A1;A2;3;4;5;"
                + "A6:A12;AVG(A13:A20))");
        double content = this.instance.getCellContentAsDouble("B12");
        Assert.assertEquals(99.5, content, 0.0);
    }

    @Test
    public void testSetCellContent_Formula_Numbers_CellRefs_Func_NumCellRefsRangesFunctionsArgs_4() throws Exception {
        System.out.println("setting cell content to a formula with: numbers, "
                + "cell references, function (arguments: numbers,cell "
                + "references,ranges,functions) - case 4");
        this.instance.setCellContent("B13", "=(A5*4)/(A2+A2)+SUM(A1;A2;3;4;5;"
                + "A6:A12;AVG(A13:A20;SUM(A21;A22);MAX(A23;A24);MIN(A4;A3)))");
        double content = this.instance.getCellContentAsDouble("B13");
        Assert.assertEquals(101.363636, content, 0.0001);
    }

}
