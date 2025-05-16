package org.example.trig;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Sec {
    private double cosX;

    public double calculate(double e) {
        if (Math.abs(cosX) < e) 
            throw new ArithmeticException("Sec is not defined if cos equals zero!");
        return 1 / cosX;
    }
}
