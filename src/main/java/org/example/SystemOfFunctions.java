package org.example;

import lombok.AllArgsConstructor;
import org.example.log.LogSystem;
import org.example.trig.TrigSystem;

import java.util.function.Function;

@AllArgsConstructor
public class SystemOfFunctions {
    public static double calculate(double x, double e) {
        if (x <= 0) return TrigSystem.calculate(x, e);
        else if (x > 0) return LogSystem.calculate(x, e);
        else throw new IllegalArgumentException("Invalid input");
    }
}
