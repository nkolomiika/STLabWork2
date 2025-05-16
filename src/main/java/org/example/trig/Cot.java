package org.example.trig;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class Cot {
    private double tanX;

    public double calculate(double e) {
        if (Math.abs(tanX) < e)
            throw new ArithmeticException("Cot is not defined if tan equals zero!");
        return 1 / tanX;
    }
}
