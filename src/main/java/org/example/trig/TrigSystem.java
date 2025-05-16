package org.example.trig;

public class TrigSystem {
    public static double calculate(double x, double e) {
        if (x > 0)
            throw new IllegalArgumentException("For positive x use another function!");

        double sin = Sin.calculate(x, e);
        Cos cosFunc = new Cos(sin);
        Tan tanFunc = new Tan(sin, cosFunc.calculate());
        // Cot cotFunc = new Cot(tanFunc.calculate(e));
        Csc cscFunc = new Csc(sin);
        Sec secFunc = new Sec(cosFunc.calculate());

        double cos = cosFunc.calculate();
        double tan = tanFunc.calculate(e);
        double csc = cscFunc.calculate(e);
        double sec = secFunc.calculate(e);
        // double cot = cotFunc.calculate(e);

        if (Math.abs(sin) < e || Math.abs(cos) < e) {
            return 0.0;
        }

        return ((Math.pow(((((Math.pow(tan, 6) + cos) * sin) * tan) - (tan + sin)) * (tan * (tan + sin)), 6))
                - ((csc + (tan / cos + sec)) - ((cos - Math.pow(csc, 3)) / sec)) * sin)
                / csc;
    }
}
