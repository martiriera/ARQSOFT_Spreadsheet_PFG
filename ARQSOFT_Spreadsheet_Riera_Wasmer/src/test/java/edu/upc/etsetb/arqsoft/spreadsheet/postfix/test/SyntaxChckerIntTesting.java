/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.postfix.test;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.UnkownFactoryException;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.SyntaxException;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.impl.SyntaxCheckerImpl;

/**
 * 
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class SyntaxChckerIntTesting {

    public static void main(String[] args) {
        String[] in = {
            "13,2",
            "/A1",
            "*A1",
            ")A1",
            ":A1",
            ";A1",
            ",A1",
            "+FUNCTA(FUNCTB(FUNCTC(A1;A2;A4:A6);B1:B7);C3)",
            "+A",
            "+12+13,2+SUM(A27:A45",
            "+12+13,2+SUM(B23:C47/",
            "+12+13,2+SUM(/A1+B2*AAA()B12+CA112",
            "+12 + 13,2+(SUM(A1:B5;C7;SUMA(C8:C20)) +B12)+CA112",
            "+12 + 13,2+(SUM(A1:B5;C7;SUMA(C8:C20))  ?  +B12)+CA112",
            "(A1:A2)",
            "()",
            "(A1+A2)+",
            "(A1+A2)+B",
            "A1A2:A3",
            "A:A1",
            ":A1",
            "A1:A2A3",
            "A1:A",
            "A1:"

        };
        for (String input : in) {
            try {
                SpreadsheetFactory factory = SpreadsheetFactory.getInstance("DEFAULT");
                SyntaxCheckerImpl parser = (SyntaxCheckerImpl) factory.createSyntaxChecker();
                System.out.println("\n\n" + input);
                parser.setFactory(factory);
                parser.check(input);
                System.out.println("Checking OK. Tokens found: " + parser.result2String());
            } catch (Exception ex) {
                System.out.println("An error has occurred while trying to run "
                        + "the syntax checker. Details follow. " + ex.getMessage());
            }

        }
    }

}
