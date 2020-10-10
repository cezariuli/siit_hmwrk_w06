package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Calculator calc = new Calculator();

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please insert desired unit: ");
        String unit = keyboard.nextLine();

        System.out.println(calc.calculate("7 cm - 2 dm + 6 mm", unit));
    }
}
