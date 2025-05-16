package org.example.log;

public class Ln {
    public static double calculate(double x, double e) {
        if (x <= e)
            throw new IllegalArgumentException("Ln defined only for positive x!");

        double y = (x - 1) / (x + 1),
                y2 = y * y,
                sum = 0,
                term = y;
        int n = 1;

        while (Math.abs(term) > e) {
            sum += term / n;
            term *= y2;
            n += 2;
        }
        return 2 * sum;
    }
}
