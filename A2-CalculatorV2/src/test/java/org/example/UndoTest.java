package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UndoTest {

    @Test
    void enterNumbersNoUndoTest() {
        String input = "1\n1\n1\n2\nn\n1\n2\n1\n2.0\nn\n4.0\nn\n2\n";
        InputStream mockInputStream = new ByteArrayInputStream(input.getBytes());
        Calculator calculator = new Calculator(mockInputStream);

        calculator.doCalculations();

        assertEquals(calculator.calculating, false);

    }

    @Test
    void enterNumbersWithUndoTest() {
        String input = "1\n1\n1\n2\ny\n3\nn\n1\n2\n1\n2.0\ny\n4.0\nn\n4.0\ny\n7.4\nn\n2\n";
        InputStream mockInputStream = new ByteArrayInputStream(input.getBytes());
        Calculator calculator = new Calculator(mockInputStream);

        calculator.doCalculations();

        assertEquals(calculator.calculating, false);

    }

}
