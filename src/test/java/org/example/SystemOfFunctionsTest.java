package org.example;

import org.example.log.LogSystem;
import org.example.trig.TrigSystem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SystemOfFunctionsTest {
    private static final double EPSILON = 1e-9;

    @Test
    @DisplayName("Test LogSystem with negative x throws IllegalArgumentException")
    void testLogSysCalcWithNegativeXThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> LogSystem.calculate(-1, EPSILON));
    }

    @Test
    @DisplayName("Test LogSystem with zero x throws IllegalArgumentException")
    void testLogSysCalcWithZeroXThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> LogSystem.calculate(0, EPSILON));
    }

    @Test
    @DisplayName("Test LogSystem with x close to one")
    void testLogSysCalcWithXCloseToOne() {
        double result = LogSystem.calculate(1.0, EPSILON);
        assertEquals(0.0, result, EPSILON);
    }

    @Test
    @DisplayName("Test LogSystem with valid x")
    void testLogSysCalcWithValidX() {
        double x = 2.0;
        double lnX = Math.log(x);
        double log5 = lnX / Math.log(5);
        double log3 = lnX / Math.log(3);

        double expected = Math.pow((((log5 + log3) / (lnX * log5)) - log5 / lnX) / (log3 / log5 - log5), 2);
        double actual = LogSystem.calculate(x, EPSILON);
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    @DisplayName("Test TrigSystem with positive x throws IllegalArgumentException")
    void testTrigSysCalcWithPositiveXThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> TrigSystem.calculate(1, EPSILON));
    }

    @Test
    @DisplayName("Test TrigSystem with zero x throws ArithmeticException")
    void testTrigSysCalcWithZeroX() {
        assertThrows(ArithmeticException.class, () -> TrigSystem.calculate(0, EPSILON));
    }

    @Test
    @DisplayName("Test TrigSystem with negative x")
    void testTrigSysCalcWithNegativeX() {
        double x = -Math.PI / 4;
        double sin = Math.sin(x);
        double cos = Math.cos(x);
        double tan = Math.tan(x);
        double sec = 1.0 / cos;
        double csc = 1.0 / sin;

        double expected = ((Math.pow(((((Math.pow(tan, 6) + cos) * sin) * tan) - (tan + sin)) * (tan * (tan + sin)), 6))
                - ((csc + (tan / cos + sec)) - ((cos - Math.pow(csc, 3)) / sec)) * sin)
                / csc;

        double actual = TrigSystem.calculate(x, EPSILON);
        assertEquals(expected, actual, 1e-5);
    }
}