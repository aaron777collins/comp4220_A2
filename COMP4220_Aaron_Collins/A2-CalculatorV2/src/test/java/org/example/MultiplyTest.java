package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyTest {

    Calculator calculator;

    @BeforeEach
    void beforeEach() {
        calculator = new Calculator(System.in);
    }

    @Test
    void TC1() {
        float res = calculator.multiply(0, 0);
        assertEquals (res, 0);
    }

    @Test
    void TC2() {
        float res = calculator.multiply(0, 1);
        assertEquals (res, 0);
    }

    @Test
    void TC3() {
        float res = calculator.multiply(1, 1);
        assertEquals (res, 1);
    }

    @Test
    void TC4() {
        float res = calculator.multiply(-1.844674352395373E19f, 1);
        assertEquals (res, -1.844674352395373E19f);
    }

    @Test
    void TC5() {
        float res = calculator.multiply(-1.844674352395373E19f, -1.844674352395373E19f);
        assertEquals (res, 3.4028232635611926E38);
    }

    @Test
    void TC6() {
        float res = calculator.multiply(1.844674352395373E19f, 1.844674352395373E19f);
        assertEquals (res, 3.4028232635611926E38);
    }

    @Test
    void TC7() {
        float res = calculator.multiply(1, 3.4028235E38f);
        assertEquals (res, 3.4028235E38f );
    }

    @Test
    void TC8() {
        float res = calculator.multiply(3.4028235E38f, 3.4028235E38f);
        assertEquals (res, Float.POSITIVE_INFINITY);
    }

    @Test
    void TC9() {
        float res = calculator.multiply(3.4028235E38f, -3.4028235E38f);
        assertEquals (res, Float.NEGATIVE_INFINITY);
    }

    //
    @Test
    void TC10() {
        boolean error = false;
        try {
            float res = calculator.multiply(1, Float.parseFloat("a"));
        } catch(NumberFormatException e) {
            error = true;
        }
        assert(error);
    }

    @Test
    void TC11() {
        boolean error = false;
        try {
            float res = calculator.multiply(Float.parseFloat("a"), 1);
        } catch(NumberFormatException e) {
            error = true;
        }
        assert(error);
    }

    @Test
    void TC12() {
        boolean error = false;
        try {
            float res = calculator.multiply(Float.parseFloat("a"), Float.parseFloat("a"));
        } catch(NumberFormatException e) {
            error = true;
        }
        assert(error);
    }

}
