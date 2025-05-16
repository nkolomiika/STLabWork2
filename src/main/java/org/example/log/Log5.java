package org.example.log;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class Log5 {
    private double lnX;
    private double ln5;

    public double calculate() {
        return lnX / ln5;
    }
}
