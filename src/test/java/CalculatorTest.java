import org.example.tdd.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Calculator TDD Demo")
public class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    public void setup() {
         calculator = new Calculator();
    }

    @Test
    @DisplayName("Should add two positive numbers")
    public void shouldAddTwoPositiveNumbers() {
        int a = 1;
        int b = 2;
        int expected = 3;
        int actual = calculator.add(a, b);
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Should add zero to a number")
    public void shouldAddZeroToANumber() {
        int a = 10;
        int b = 0;
        int expected = 10;
        int actual = calculator.add(a, b);
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Should add negative numbers")
    public void shouldAddNegativeNumbers() {
        int a = 10;
        int b = -1;
        int expected = 9;
        int actual = calculator.add(a, b);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should subtract two numbers")
    public void shouldSubStartTwoNumbers() {
        int a = 3;
        int b = 2;
        int expected = 1;
        int actual = calculator.sub(a, b);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should handle negative result in subtraction")
    public void shouldHandleNegativeResultInSubtraction() {
        int a = -1;
        int b = 2;
        int expected = -3;
        int actual = calculator.sub(a, b);
        assertEquals(expected, actual);

    }
    @Test
    @DisplayName("Should multiply two numbers")
    public void shouldMultiplyTwoNumbers() {
        int a = 3;
        int b = 2;
        int expected = 6;
        int actual = calculator.multiply(a, b);
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Should return zero when multiplying by zero")
    public void shouldReturnZeroWhenMultiplyingByZero() {

        int a = 3;
        int b = 0;
        int expected = 0;
        int actual = calculator.multiply(a, b);
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Should divide two numbers")
    public void shouldDivideTwoNumbers() {
        double a = 4;
        double b = 2;
        double expected = 2;
        double actual = calculator.divide(a, b);
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Should handle decimal division")
    public void shouldHandleDecimalDivision() {
        double a = 4.0;
        double b = 2.0;
        double expected = 2.0;
        double actual = calculator.divide(a, b);
        assertEquals(expected, actual);

    }
    @Test
    @DisplayName("Should throw exception when dividing by zero")
    public void shouldThrowExceptionWhenDividingByZero() {
        double a = 4;
        double b = 0;
        assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
    }
    @Test
    @DisplayName("Should calculate power of a number")
    public void shouldCalculatePowerOfANumber() {
        double a = 3;
        double b = 2;
        double expected = 9;
        double actual = calculator.power(a, b);
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Should handle power of zero")
    public void shouldHandlePowerOfZero() {
        double a = 4;
        double b = 0;
        double expected = 1;
        double actual = calculator.power(a, b);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should calculate square root")
    public void shouldCalculateSquareRoot() {
        double a = 4;
        double expected = 2;
        double actual = calculator.squareRoot(a);
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Should throw exception for negative square root")
    public void shouldThrowExceptionForNegativeSquareRoot() {
        double a = -4;
        java.lang.ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.squareRoot(a));
        assertEquals("Cannot take square root of a negative number", exception.getMessage());
    }

    @Test
    @DisplayName("Should handle maximum integer values in addition")
    public void shouldHandleMaximumIntegerValuesInAddition() {


        int result = calculator.add(Integer.MAX_VALUE, 1);
        assertEquals(Integer.MIN_VALUE, result);
    }
    @Test
    @DisplayName("Should handle negative exponents")
    public void shouldHandleNegativeExponents() {
        assertEquals(0.25, calculator.power(2,-2));
    }


}