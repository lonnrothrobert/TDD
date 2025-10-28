package org.example.tdd;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyConverter {
    private static final BigDecimal USD_TO_EUR = new BigDecimal("0.92");
    private static final BigDecimal USD_TO_SEK = new BigDecimal("10.50");
    public BigDecimal usdToEuro(BigDecimal amount) {
        if (amount.signum() == -1) {
            throw new IllegalArgumentException("Cannot convert negative amount");
        }
        return amount.multiply(USD_TO_EUR).setScale(2, RoundingMode.HALF_UP);
    }
    public BigDecimal usdToSek(BigDecimal amount) {
        if (amount.signum() == -1) {
            throw new IllegalArgumentException("Cannot convert negative amount");
        }
        return amount.multiply(USD_TO_SEK).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal euroToUsd(BigDecimal amount) {
        if (amount.signum() == -1) {
            throw new IllegalArgumentException("Cannot convert negative amount");
        }
        return amount.divide(USD_TO_EUR, 2, RoundingMode.HALF_UP);
    }
    public BigDecimal sekToUsd(BigDecimal amount) {
        if (amount.signum() == -1) {
            throw new IllegalArgumentException("Cannot convert negative amount");
        }
        return amount.divide(USD_TO_SEK, 2, RoundingMode.HALF_UP);
    }
    public BigDecimal add(BigDecimal amount1, BigDecimal amount2) {
        if (amount1.signum() == -1 || amount2.signum() == -1) {
            throw new IllegalArgumentException("Cannot add negative amounts");
        }
        BigDecimal result = amount1.add(amount2);
        return result.setScale(2, RoundingMode.HALF_UP);
    }
    public BigDecimal taxCalculation(BigDecimal amount, BigDecimal taxRate) {
        if (taxRate.signum() == -1) {
            throw new IllegalArgumentException("Cannot calculate negative tax");
        }
        BigDecimal result = amount.multiply(taxRate);
        return result.setScale(2, RoundingMode.HALF_UP);
    }
}
