import org.example.tdd.MoneyConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyConverterTest {
    private MoneyConverter converter;
    @BeforeEach
    public void setUp() {
        converter = new MoneyConverter();
    }

    @Test
    @DisplayName("Should convert 100 usd to 92 euro")
    public void usdToEuro() {
        BigDecimal amount = new BigDecimal("100.0");
        assertThat(converter.usdToEuro(amount)).isEqualTo("92.00");
    }
    @Test
    @DisplayName("Should maintain value round-trip")
    public void maintainValueRoundTrip() {
        BigDecimal amount = new BigDecimal("100.0");
        assertThat(converter.usdToEuro(converter.euroToUsd(amount))).isEqualTo("100.00");
    }
}
