package org.example;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    Calculator calc = new Calculator();

    public String  readUserInput() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please insert desired unit: ");
        return userInput.nextLine();

    }

    @Test
    public void checkAddition()
    {
        //read user input doesn't work in tests.
        //to check this functionality please run the main function from App.java
        //String unit = readUserInput();
        String unit = "cm";

        assertEquals("10.2 cm", calc.calculate("10 cm + 2 mm", unit));
    }

    @Test
    public void checkSubtraction()
    {
        String unit = "mm";

        assertEquals("920.0 mm", calc.calculate("10 dm - 8 cm", unit));
    }

    @Test
    public void checkMixed()
    {
        String unit = "m";

        assertEquals("1024.5919999999999 m", calc.calculate("1 km + 25 m - 40 cm - 8 mm", unit));
    }

    @Test
    public void invalidOperand()
    {

        String unit = "cm";
        assertEquals("Given expression contains invalid operands.", calc.calculate("10 cm * 2 mm", unit) );
    }
}
