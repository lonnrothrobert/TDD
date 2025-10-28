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

    }
    @Nested
    @DisplayName("SEK to USD conversion")
    class SEKToUSDTests {

    }
    @Nested
    @DisplayName("Money Addition")
    class MoneyAdditionTests {

    }
    @Nested
    @DisplayName("Tax calculations")
    class TaxCalculationsTests {

    }
}
