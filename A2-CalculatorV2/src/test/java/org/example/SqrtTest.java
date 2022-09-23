package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqrtTest {

    Calculator calculator;

    @BeforeEach
    void beforeEach() {
        calculator = new Calculator();
    }

    @Test
    void TC1() {
        float res = calculator.sqrt(1);
        assertEquals (res, 1);
    }

    @Test
    void TC2() {
        float res = calculator.sqrt(0);
        assertEquals (res, 0);
    }

    @Test
    void TC3() {
        float res = calculator.sqrt(4);
        assertEquals (res, 2);
    }

    @Test
    void TC4() {
        float res = calculator.sqrt(3.4028235E38f);
        assertEquals (res, 1.8446742974197924E19);
    }


    @Test
    void TC5() {
        float res = calculator.sqrt(3.4028235E38f * 3.4028235E38f);
        assertEquals (res, Float.POSITIVE_INFINITY);
    }

    @Test
    void TC6() {
        float res = calculator.sqrt(-1);
        assertEquals (res, Float.NaN);
    }


    @Test
    void TC7() {
        boolean error = false;
        try {
            float res = calculator.sqrt(Float.parseFloat("a"));
        } catch(NumberFormatException e) {
            error = true;
        }
        assert(error);
    }


}
