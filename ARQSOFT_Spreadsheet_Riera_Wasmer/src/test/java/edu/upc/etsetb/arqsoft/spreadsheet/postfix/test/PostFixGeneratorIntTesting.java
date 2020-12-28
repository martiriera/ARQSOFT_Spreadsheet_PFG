/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.postfix.test;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.PostFixGenerator;

/**
 * 
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class PostFixGeneratorIntTesting {

    public static void main(String[] args) {
        String[] in = {
            /*
            "A1+A2*A3",
            
            "A1-A2*(A4-A5)*B6",
            
            "A1*(A2*(A3+A4)+A5)",
           
            "A1-A2*(A4-(A5*V4)-V6)*B6",  
             */
            "SUM(13+A8;SUM(A1:A2;A3;A5*(A4-A3));B5/(B6-B5*(A27-A32)))",
            "SUM(SUM(A1:A2;A3;A5*(A4-A3));13+A8;B5/(B6-B5*(A27-A32)))",
            "SUM(A1;A2)",
            "SUM(SUM(A1:A2;A3);13+A8)",
            "SUM(SUM(A1:A2;A3;A5*(A4-A3));(13+A8);B5/(B6-B5*(A27-A32)))",
            "A3+SUM(MEAN(B5:B30);C1:C20)*(D2*(D4-D5))",
            "A3+A5*B4-((B7*C7)/(A4-D6))+(B16*C17-C12)",
            "(MEAN(SUM(A1:A2);MIN(A5;A8);A9;A10)+(A1*(A9-A3)))/A8"

        /*            
            "SUM(MEAN(MIN(A1;A2;A4:A6);B1:B7);C3)",
         */
        };
        for (String input : in) {
            try {
                SpreadsheetFactory factory = SpreadsheetFactory.getInstance("DEFAULT");
                PostFixGenerator gen = factory.createPostFixGenerator();
                gen.setFactory(factory);
                System.out.println("\n\n" + input);
                gen.generateFromString(input);
                System.out.println("Postfix generation OK. Result generated: " + gen.result2String());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Error while trying to generate the postfix expression. Details follow. " + ex.getMessage());
                continue;
            }
        }
    }

}
