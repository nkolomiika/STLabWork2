package org.example;

import org.example.report.CSVWriter;

public class App {
    public static void main(String[] args) {
        double e = 1e-5;
        CSVWriter.saveResults("negative_x.csv", -2, 0, 0.01, "->",
                x -> SystemOfFunctions.calculate(x, e));

        CSVWriter.saveResults("positive_x.csv", 0.01, 10, 0.01, "->",
                x -> SystemOfFunctions.calculate(x, e));
    }
}
