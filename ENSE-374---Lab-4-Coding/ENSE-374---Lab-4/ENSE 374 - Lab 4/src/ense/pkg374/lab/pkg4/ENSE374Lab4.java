/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ense.pkg374.lab.pkg4;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
/**
 *
 * @author Clayton
 */
public class ENSE374Lab4 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Park park = new Park(150,150);
        park.initializeParkElements();
        park.printPark();
    }
    
}
