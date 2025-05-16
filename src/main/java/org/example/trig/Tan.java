package org.example.trig;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Tan {
    private double sinX;
    private double cosX;
    public double calculate(double e) {
        if (Math.abs(cosX) < e) 
            throw new ArithmeticException("Tan is not defined if cos equals zero!");
        return sinX / cosX;
    }
}
