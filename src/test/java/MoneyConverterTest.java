import org.example.tdd.MoneyConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyConverterTest {
    private MoneyConverter converter;
    @BeforeEach
    public void setUp() {
        converter = new MoneyConverter();
    }

    @Nested
    @DisplayName("USD to EUR conversion")
    class USDToEURTests
     {
        @Test
        @DisplayName("Should convert 100 usd to 92 euro")
        public void usdToEuro () {
            BigDecimal amount = new BigDecimal("100.0");
            assertThat(converter.usdToEuro(amount)).isEqualTo("92.00");
        }
        @Test
        @DisplayName("Should convert 0 USD to 0 EUR")
         public void usdToEuro0 () {
            BigDecimal amount = new BigDecimal("0.00");
            assertThat(converter.usdToEuro(amount)).isEqualTo("0.00");
        }
        @Test
         @DisplayName("Should round result to 2 decimal places")
         public void usdToEuro2DecimalPlaces () {
            BigDecimal amount = new BigDecimal("2.001");
            assertThat(converter.usdToEuro(amount)).isEqualTo("1.84");
        }
        @Test
         @DisplayName("Should throw exception for negative USD")
         public void usdToEuroNegative () {
            BigDecimal amount = new BigDecimal("-100");

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> converter.usdToEuro(amount)
            );

            assertEquals("Cannot convert negative amount", exception.getMessage());
        }
    }
    @Nested
    @DisplayName("EUR to USD conversion")
    class EuroToUSDTests {
        @Test
        @DisplayName("Should convert 92 euro to 100 usd")
        public void eurToUsd () {
            BigDecimal amount = new BigDecimal("92.00");
            assertThat(converter.euroToUsd(amount)).isEqualTo("100.00");
        }
        @Test
        @DisplayName("Should maintain value round-trip conversion")
        public void maintainValueRoundTrip() {
            BigDecimal amount = new BigDecimal("100.0");
            assertThat(converter.usdToEuro(converter.euroToUsd(amount))).isEqualTo("100.00");
        }
    }
    @Nested
    @DisplayName("USD to SEK conversion")
    class USDToSEKTests {
        @Test
        @DisplayName("Should convert 100 USD to 1050 SEK")
        public void usdToSek100 () {
            BigDecimal amount = new BigDecimal("100.0");
            assertThat(converter.usdToSek(amount)).isEqualTo("1050.00");
        }
        @Test
        @DisplayName("Should convert 10 USD to 105 SEK")
        public void usdToSek10 () {
            BigDecimal amount = new BigDecimal("10.00");
            assertThat(converter.usdToSek(amount)).isEqualTo("105.00");
        }
    }
    @Nested
    @DisplayName("SEK to USD conversion")
    class SEKToUSDTests {
        @Test
        @DisplayName("Should convert 1050 SEK to 100 USD")
        public void sekToUsd () {
            BigDecimal amount = new BigDecimal("1050.00");
            assertThat(converter.sekToUsd(amount)).isEqualTo("100.00");
        }
        @Test
        @DisplayName("Should maintain value through round-trip")
        public void maintainValueRoundTrip() {
            BigDecimal amount = new BigDecimal("1050.00");
            assertThat(converter.sekToUsd(converter.usdToSek(amount))).isEqualTo("1050.00");
        }
    }
    @Nested
    @DisplayName("Money Addition")
    class MoneyAdditionTests {
        @Test
        @DisplayName("Should add two money amounts")
        public void addTwoMoneyAmounts() {
            BigDecimal amount1 = new BigDecimal("100.00");
            BigDecimal amount2 = new BigDecimal("100.00");
            assertEquals(new BigDecimal("200.00"), converter.add(amount1, amount2));
        }
        @Test
        @DisplayName("Should add zero to amount")
        public void addZeroToAmount() {
            BigDecimal amount1 = new BigDecimal("100.00");
            BigDecimal amount2 = new BigDecimal("0.00");
            assertEquals(new BigDecimal("100.00"), converter.add(amount1, amount2));
        }
        @Test
        @DisplayName("Should throw exception for negative")
        public void shouldThrowExceptionForNegative () {
            BigDecimal amount1 = new BigDecimal("100");
            BigDecimal amount2 = new BigDecimal("-100");
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> converter.add(amount1, amount2));
            assertEquals("Cannot add negative amounts", exception.getMessage());
        }
    }
    @Nested
    @DisplayName("Tax calculations")
    class TaxCalculationsTests {
        @Test
        @DisplayName("Should calculate 25% tax")
        public void calculate25PercentTax() {
            BigDecimal amount = new BigDecimal("100.00");
            BigDecimal taxRate = new BigDecimal("0.25");
            assertThat(converter.taxCalculation(amount, taxRate)).isEqualTo("25.00");
        }
        @Test
        @DisplayName("Should add tax to amount")
        public void addTaxToAmount() {
            BigDecimal amount = new BigDecimal("100.00");
            BigDecimal taxRate = new BigDecimal("0.25");
            assertThat(amount.add(converter.taxCalculation(amount, taxRate))).isEqualTo("125.00");
        }
        @Test
        @DisplayName("Should handle zero tax rate")
        public void handleZeroTaxRate() {
            BigDecimal amount = new BigDecimal("100.00");
            BigDecimal taxRate = new BigDecimal("0.00");
            assertThat(amount.add(converter.taxCalculation(amount, taxRate))).isEqualTo("100.00");
        }
        @Test
        @DisplayName("Should throw exception for negative tax rate")
        public void shouldThrowExceptionForNegativeTaxRate() {
            BigDecimal amount = new BigDecimal("100.00");
            BigDecimal taxRate = new BigDecimal("-0.10");
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> converter.taxCalculation(amount, taxRate));
            assertEquals("Cannot calculate negative tax", exception.getMessage());
        }
    }
}
