package org.example.trig;

public class Sin {
    public static double calculate(double x, double e) {
        x = normalizeAngle(x);
        double term = x;
        double sum = x;
        int n = 1;
        while (Math.abs(term) > e) {
            term *= -x * x / ((2 * n) * (2 * n + 1));
            sum += term;
            n++;
        }
        return sum;
    }

    private static double normalizeAngle(double x) {
        while (x > Math.PI) x -= 2 * Math.PI;
        while (x < -Math.PI) x += 2 * Math.PI;
        return x;
    }
}
