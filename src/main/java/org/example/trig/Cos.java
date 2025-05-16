package org.example.trig;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Cos {
    private double sinX;

    public double calculate() {
        return Math.sqrt(1 - sinX * sinX);
    }
}
