import org.example.tdd.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DisplayName("Calculator TDD Demo")
public class CalculatorTest {
    @BeforeEach
    public void setup() {
        Calculator calculator = new Calculator();
    }

    @Test
    @DisplayName("Should add two positive numbers")
    public void shouldAddTwoPositiveNumbers() {
        int a = 1;
        int b = 2;
        int expected = 3;
        int actual = new Calculator().add(a, b);
        assertEquals(expected, actual);
    }

}