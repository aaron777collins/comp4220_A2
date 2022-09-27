package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideTest {

    Calculator calculator;

    @BeforeEach
    void beforeEach() {
        calculator = new Calculator(System.in);
    }

    @Test
    void TC1() {
        float res = calculator.divide(1, 1);
        assertEquals (res, 1);
    }

    @Test
    void TC2() {
        float res = calculator.divide(0, 1);
        assertEquals (res, 0);
    }

    @Test
    void TC3() {
        float res = calculator.divide(2, 1);
        assertEquals (res, 2);
    }

    @Test
    void TC4() {
        float res = calculator.divide(3.4028235E38f, 1);
        assertEquals (res, 3.4028235E38f);
    }

    @Test
    void TC5() {
        float res = calculator.divide(3.4028235E38f, 2);
        assertEquals (res, 1.7014117331926443E38);
    }

    @Test
    void TC6() {
        float res = calculator.divide(1, 3.4028235E38f);//TODO
        assertEquals (res, 2.9387358770557188E-39);
    }

    @Test
    void TC7() {
        float res = calculator.divide(3.4028235E38f, 3.4028235E38f);
        assertEquals (res, 1 );
    }

    @Test
    void TC8() {
        float res = calculator.divide(3.4028235f, 1.0E-37f);
        assertEquals (res, 3.4028234663852886E37);
    }

    @Test
    void TC9() {
        float res = calculator.divide(-3.4028235f, 1.0E-37f);
        assertEquals (res, -3.4028234663852886E37);
    }

    @Test
    void TC10() {
        float res = calculator.divide(3.4028235f, 1.0E-38f);
        assertEquals (res, Float.POSITIVE_INFINITY);
    }

    @Test
    void TC11() {
        float res = calculator.divide(-3.4028235f, 1.0E-38f);
        assertEquals (res, Float.NEGATIVE_INFINITY);
    }

    @Test
    void TC12() {
        float res = calculator.divide(1, 0);
        assertEquals (res, Float.POSITIVE_INFINITY);
    }

    @Test
    void TC13() {
        float res = calculator.divide(-1, 0);
        assertEquals (res, Float.NEGATIVE_INFINITY);
    }

    @Test
    void TC14() {
        float res = calculator.divide(0, 0);
        assertEquals (res, Float.NaN);
    }


    @Test
    void TC15() {
        boolean error = false;
        try {
            float res = calculator.divide(1, Float.parseFloat("a"));
        } catch(NumberFormatException e) {
            error = true;
        }
        assert(error);
    }

    @Test
    void TC16() {
        boolean error = false;
        try {
            float res = calculator.divide(Float.parseFloat("a"), 1);
        } catch(NumberFormatException e) {
            error = true;
        }
        assert(error);
    }

    @Test
    void TC17() {
        boolean error = false;
        try {
            float res = calculator.divide(Float.parseFloat("a"), Float.parseFloat("a"));
        } catch(NumberFormatException e) {
            error = true;
        }
        assert(error);
    }

}
