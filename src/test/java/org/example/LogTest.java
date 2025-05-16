package org.example;

import org.example.log.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogTest {
    private static final double EPSILON = 1e-5;

    @Test
    @DisplayName("Test ln(1)")
    public void testLn() {
        assertEquals(Math.log(1), Ln.calculate(1, EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test ln(2)")
    public void test2Ln() {
        assertEquals(Math.log(2), Ln.calculate(2, EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test ln(10)")
    public void test3Ln() {
        assertEquals(Math.log(10), Ln.calculate(10, EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test ln(0.5)")
    public void test4Ln() {
        assertEquals(Math.log(0.5), Ln.calculate(0.5, EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test ln(16)")
    public void testLnBig() {
        assertEquals(Math.log(16), Ln.calculate(16, EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test log5(125)")
    public void testLog2() {
        double lnX = Ln.calculate(125, EPSILON);
        double ln5 = Ln.calculate(5, EPSILON);
        Log5 log5 = new Log5(lnX, ln5);
        assertEquals(Math.log(125) / Math.log(5), log5.calculate(), EPSILON);
    }

    @Test
    @DisplayName("Test log3(8)")
    public void testLog3() {
        double lnX = Ln.calculate(8, EPSILON);
        double ln3 = Ln.calculate(3, EPSILON);
        Log3 log3 = new Log3(lnX, ln3);
        assertEquals(Math.log(8) / Math.log(3), log3.calculate(), EPSILON);
    }

    @Test
    @DisplayName("Test log5(125) with stubs")
    public void testLog5WithStubs() {
        Log5 log5 = new Log5(4.8283137373, 1.60943791243);
        assertEquals(Math.log(125) / Math.log(5), log5.calculate(), EPSILON);
    }

    @Test
    @DisplayName("Test log3(8) with stubs")
    public void testLog3WithStubs() {
        Log3 log3 = new Log3(2.07944154168, 1.09861228867);
        assertEquals(Math.log(8) / Math.log(3), log3.calculate(), EPSILON);
    }

    @Test
    @DisplayName("Test ln(-1) throws IllegalArgumentException")
    public void testLnNegative() {
        assertThrows(IllegalArgumentException.class, () -> Ln.calculate(-1, EPSILON));
    }

    @Test
    @DisplayName("Test log5(-5) throws IllegalArgumentException")
    public void testLog5Negative() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Log5(Ln.calculate(-5, EPSILON), Ln.calculate(5, EPSILON)).calculate()
        );
    }

    @Test
    @DisplayName("Test log3(-3) throws IllegalArgumentException")
    public void testLog3Negative() {
        assertThrows(IllegalArgumentException.class,
                () -> new Log3(Ln.calculate(-3, EPSILON), Ln.calculate(3, EPSILON)).calculate()
        );
    }
}