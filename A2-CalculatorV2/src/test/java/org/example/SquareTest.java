package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {

    Calculator calculator;

    @BeforeEach
    void beforeEach() {
        calculator = new Calculator(System.in);
    }

    @Test
    void TC1() {
        float res = calculator.square(1);
        assertEquals (res, 1);
    }

    @Test
    void TC2() {
        float res = calculator.square(0);
        assertEquals (res, 0);
    }

    @Test
    void TC3() {
        float res = calculator.square(4);
        assertEquals (res, 16);
    }

    @Test
    void TC4() {
        float res = calculator.square(1.844674352395373E19f);
        assertEquals (res, 3.4028232635611926E38); //slightly different from max float because of approximation
    }


    @Test
    void TC5() {
        float res = calculator.square(3.4028235E38f);
        assertEquals (res, Float.POSITIVE_INFINITY);
    }

    @Test
    void TC6() {
        float res = calculator.square(-1);
        assertEquals (res, 1);
    }


    @Test
    void TC7() {
        boolean error = false;
        try {
            float res = calculator.square(Float.parseFloat("a"));
        } catch(NumberFormatException e) {
            error = true;
        }
        assert(error);
    }


}
