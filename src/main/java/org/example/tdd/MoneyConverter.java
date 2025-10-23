package org.example.tdd;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyConverter {
    private static final BigDecimal USD_TO_EUR = new BigDecimal("0.92");
    private static final BigDecimal USD_TO_SEK = new BigDecimal("10.50");
    public BigDecimal usdToEuro(BigDecimal amount) {
        return amount.multiply(USD_TO_EUR).setScale(2, RoundingMode.HALF_UP);
    }
    public BigDecimal usdToSek(BigDecimal amount) {
        return amount.multiply(USD_TO_SEK).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal euroToUsd(BigDecimal amount) {
        return amount.divide(USD_TO_EUR, 2, RoundingMode.HALF_UP);
    }
}
