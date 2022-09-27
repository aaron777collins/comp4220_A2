package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtractTest {

    Calculator calculator;

    @BeforeEach
    void beforeEach() {
        calculator = new Calculator(System.in);
    }

    @Test
    void TC1() {
        float res = calculator.subtract(0, 0);
        assertEquals (res, 0);
    }

    @Test
    void TC2() {
        float res = calculator.subtract(0, 1);
        assertEquals (res, -1);
    }

    @Test
    void TC3() {
        float res = calculator.subtract(1, 1);
        assertEquals (res, 0);
    }

    @Test
    void TC4() {
        float res = calculator.subtract(3.4028235E38f, 0);
        assertEquals (res, 3.4028235E38f);
    }

    @Test
    void TC5() {
        float res = calculator.subtract(3.4028235E38f, 3.4028235E38f);
        assertEquals (res, 0);
    }

    @Test
    void TC6() {
        float res = calculator.subtract(-3.4028235E38f, 3.4028235E38f);
        assertEquals (res, Float.NEGATIVE_INFINITY);
    }

    @Test
    void TC7() {
        float res = calculator.subtract(3.4028235E38f, -3.4028235E38f);
        assertEquals (res, Float.POSITIVE_INFINITY );
    }

    //
    @Test
    void TC8() {
        boolean error = false;
        try {
            float res = calculator.subtract(1, Float.parseFloat("a"));
        } catch(NumberFormatException e) {
            error = true;
        }
        assert(error);
    }

    @Test
    void TC9() {
        boolean error = false;
        try {
            float res = calculator.subtract(Float.parseFloat("a"), 1);
        } catch(NumberFormatException e) {
            error = true;
        }
        assert(error);
    }

    @Test
    void TC10() {
        boolean error = false;
        try {
            float res = calculator.subtract(Float.parseFloat("a"), Float.parseFloat("a"));
        } catch(NumberFormatException e) {
            error = true;
        }
        assert(error);
    }

}
