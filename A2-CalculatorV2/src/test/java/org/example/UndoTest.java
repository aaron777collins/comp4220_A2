package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UndoTest {

    @Test
    void enterNumbersNoUndoTest() {
        String input = "a\n1.0\nn\n2.0\nn\ne\n";
        InputStream mockInputStream = new ByteArrayInputStream(input.getBytes());
        Calculator calculator = new Calculator(mockInputStream);

        calculator.doCalculations();

        assertEquals(calculator.calculating, false);

    }

    @Test
    void enterNumbersWithUndoTest() {
        String input = "a\n1.0\ny\n2.0\nn\n2.0\ny\n4.9\nn\ne\n";
        InputStream mockInputStream = new ByteArrayInputStream(input.getBytes());
        Calculator calculator = new Calculator(mockInputStream);

        calculator.doCalculations();

        assertEquals(calculator.calculating, false);

    }

}
