package org.example.trig;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Csc {
    private double sinX;

    public double calculate(double e) {
        if (Math.abs(sinX) < e)
            throw new ArithmeticException("Csc is not defined if sin equals zero!");
        return 1 / sinX;
    }
}
