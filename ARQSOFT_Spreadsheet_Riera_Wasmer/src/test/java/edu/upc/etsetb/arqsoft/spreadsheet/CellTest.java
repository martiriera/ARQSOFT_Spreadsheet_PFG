/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.CellCoordinate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JuanCarlos
 */
public class CellTest {

//    Cell a1, b1, b2, b4, b5;
//
//    public CellTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        a1 = new FormulaCell("=B1+B2");
//        b1 = new FormulaCell("=B5");
//        b2 = new FormulaCell("=B4+3");
//        b5 = new FormulaCell("=4");
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getFormula method, of class Cell.
//     */
//    @Test
//    public void testGetFormula() {
//        System.out.println("getFormula");
//        Cell instance = new CellImpl();
//        String expResult = "";
//        String result = instance.getFormula();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getValueAsDouble method, of class Cell.
//     */
//    @Test
//    public void testGetValueAsDouble() {
//        System.out.println("getValueAsDouble");
//        Cell instance = new CellImpl();
//        Double expResult = null;
//        Double result = instance.getValueAsDouble();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getValueAsString method, of class Cell.
//     */
//    @Test
//    public void testGetValueAsString() {
//        System.out.println("getValueAsString");
//        Cell instance = new CellImpl();
//        String expResult = "";
//        String result = instance.getValueAsString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of clearDependents method, of class Cell.
//     */
//    @Test
//    public void testClearDependents() {
//        System.out.println("clearDependents");
//        Cell instance = new CellImpl();
//        instance.clearDependents();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//        /**
//     * Test of addDependent method, of class Cell. 
//     * B6 = B6 ;
//     */
//    @Test
//    public void testAddDependentOK0() throws Exception {
//        System.out.print("addDependentOK0: there should not be thrown any exception...");
//        FormulaCell b6 = new FormulaCell("=B6+3") ;
//        CellCoordinate cb6 =CellCoordinate.getInstance("B6") ;
//        b6.addDependent(cb6, new Tuple(cb6,b6));
//        System.out.println("and no exception is thrown");
//        
//    }
//
//    /**
//     * Test of addDependent method, of class Cell. B4 = B5. No circular
//     * dependencies between A1 y B4.
//     */
//    @Test
//    public void testAddDependentOK1() throws Exception {
//        System.out.print("addDependentOK1: there should not be thrown any exception...");
//        CellCoordinate cA1 =CellCoordinate.getInstance("A1");
//        a1.addDependent(cA1, new Tuple(CellCoordinate.getInstance("B1"), this.b1));
//        a1.addDependent(cA1, new Tuple(CellCoordinate.getInstance("B2"), this.b2));
//        this.b4 = new FormulaCell("=B5");
//        b2.addDependent(CellCoordinate.getInstance("B2"), new Tuple(CellCoordinate.getInstance("B4"), this.b4));
//        b4.addDependent(CellCoordinate.getInstance("B4"), new Tuple(CellCoordinate.getInstance("B5"), this.b5));
//        System.out.println("and no exception is thrown");
//    }
//
//    /**
//     * Test of addDependent method, of class Cell. circular direct dependency
//     * between B6 and B7
//     *
//     */
//    @Test(expected = CircularDependencyException.class)
//    public void testAddDependentKO1() throws Exception {
//        System.out.println("addDependentKO1: An exception should be thrown...") ;
//        FormulaCell b6 = new FormulaCell("=B7+1") ;
//        FormulaCell b7 = new FormulaCell("=5*B6") ;
//        CellCoordinate cb7 =CellCoordinate.getInstance("B7");
//        CellCoordinate cb6 =CellCoordinate.getInstance("B6");
//        b6.addDependent(cb6, new Tuple(cb7,b7));
//        b7.addDependent(cb7, new Tuple(cb6,b6));
//        System.out.println("BUT NO EXCEPTION IS THROWN:  FAILED TEST") ;
//    }
//
//    /**
//     * Test of addDependent method, of class Cell. B4 = A1 + 5. Circular
//     * indirect dependency between A1 and B4.
//     */
//    @Test(expected = CircularDependencyException.class)
//    public void testAddDependentKO2() throws Exception {
//        System.out.println("addDependentKO2: An exception should be thrown...");
//        CellCoordinate cA1 =CellCoordinate.getInstance("A1");
//        a1.addDependent(cA1, new Tuple(CellCoordinate.getInstance("B1"), this.b1));
//        a1.addDependent(cA1, new Tuple(CellCoordinate.getInstance("B2"), this.b2));
//        this.b4 = new FormulaCell("=A1+5");
//        b2.addDependent(CellCoordinate.getInstance("B2"), new Tuple(CellCoordinate.getInstance("B4"), this.b4));
//        b4.addDependent(CellCoordinate.getInstance("B4"), new Tuple(CellCoordinate.getInstance("A1"), this.a1));
//        System.out.println("BUT NO EXCEPTION IS THROWN:  FAILED TEST") ;
//    }
//
//    /**
//     * Test of checkNonCircularDependencyOnCell method, of class Cell.
//     */
////    @Test
////    public void testCheckNonCircularDependencyOnCellOK() throws Exception {
////        System.out.println("checkNonCircularDependencyOnCellOK");
////        CellCoordinate thisCoord = null;
////        Tuple<CellCoordinate, Cell> tbAdded = null;
////        Cell instance = new CellImpl();
//////        instance.checkNonCircularDependencyOnCell(thisCoord, tbAdded);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//    /**
//     * Test of removeDependent method, of class Cell.
//     */
//    @Test
//    public void testRemoveDependent() {
//        System.out.println("removeDependent");
//        CellCoordinate coord = null;
//        Cell instance = new CellImpl();
//        instance.removeDependent(coord);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    public class CellImpl extends Cell {
//
//        public String getFormula() {
//            return "";
//        }
//
//        public Double getValueAsDouble() {
//            return null;
//        }
//
//        public String getValueAsString() {
//            return "";
//        }
//    }

}
