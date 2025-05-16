package org.example.log;

public class LogSystem {
    public static double calculate(double x, double e) {
        if (x <= 0)
            throw new IllegalArgumentException("For negative x use another function!");

        double lnX = Ln.calculate(x, e);
        double ln5 = Ln.calculate(5, e);
        double ln3 = Ln.calculate(3, e);

        Log5 log5Func = new Log5(lnX, ln5);
        Log3 log3Func = new Log3(lnX, ln3);

        double log5 = log5Func.calculate();
        double log3 = log3Func.calculate();

        if (Math.abs(x - 1) < e) {
            return 0.0;
        }
        return Math.pow((((log5 + log3) / (lnX * log5)) - log5 / lnX) / (log3 / log5 - log5), 2);
    }
}
