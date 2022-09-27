package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnterPreciseNumTest {

    @Test
    void enterPreciseNumbersTest() {
        String input = "1\n2\n1\n1.999999\nn\n2.444444\nn\n2\n";
        InputStream mockInputStream = new ByteArrayInputStream(input.getBytes());
        Calculator calculator = new Calculator(mockInputStream);

        calculator.doCalculations();

        assertEquals(calculator.calculating, false);

    }

    @Test
    void addTest() {
        Calculator calculator = new Calculator(System.in);

        // This is an example function.
        // The rest should be implemented in their respective test classes
        // as floats as well!
        float ret = calculator.add(4.999999f, 2.44444f);

        assertEquals(ret, 7.444438934326172);
    }

}
