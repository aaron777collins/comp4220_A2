package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnterNumTest {


    @Test
    void enterNumbersTest() {
        String input = "a\n1.0\nn\n2.0\nn\ne\n";
        InputStream mockInputStream = new ByteArrayInputStream(input.getBytes());
        Calculator calculator = new Calculator(mockInputStream);

        calculator.doCalculations();

        assertEquals(calculator.calculating, false);

    }

}
