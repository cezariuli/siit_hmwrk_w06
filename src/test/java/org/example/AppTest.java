package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Calculator calc = new Calculator();

        calc.calculate("10 cm + 2 mm", "cm");

        assertTrue( true );
    }

    @Test
    public void invalidOperand()
    {
        Calculator calc = new Calculator();
        assertEquals("Given expression contains invalid operands.", calc.calculate("10 cm * 2 mm", "cm") );
    }
}
