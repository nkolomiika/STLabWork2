package org.example.log;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Log3 {
    private double lnX;
    private double ln3;

    public double calculate() {
        return lnX / ln3;
    }
}
