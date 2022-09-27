package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CubeTest {

    Calculator calculator;

    @BeforeEach
    void beforeEach() {
        calculator = new Calculator(System.in);
    }

    @Test
    void TC1() {
        float res = calculator.cube(1);
        assertEquals (res, 1);
    }

    @Test
    void TC2() {
        float res = calculator.cube(0);
        assertEquals (res, 0);
    }

    @Test
    void TC3() {
        float res = calculator.cube(4);
        assertEquals (res, 64);
    }

    @Test
    void TC4() {
        float res = calculator.cube(6.981463519622336E11f);
        assertEquals (res, 3.4028234346940236E35);
    }

    @Test
    void TC5() {
        float res = calculator.cube(6.981463519622336E12f);
        assertEquals (res, Float.POSITIVE_INFINITY);
    }


    @Test
    void TC6() {
        float res = calculator.cube(3.4028235E38f);
        assertEquals (res, Float.POSITIVE_INFINITY);
    }

    @Test
    void TC7() {
        float res = calculator.cube(-1);
        assertEquals (res, -1);
    }


    @Test
    void TC8() {
        boolean error = false;
        try {
            float res = calculator.cube(Float.parseFloat("a"));
        } catch(NumberFormatException e) {
            error = true;
        }
        assert(error);
    }


}
