package it.unibo.sweng.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    // invalid tokens -> IllegalArgumentException
    // division by zero -> ArithmeticException
    // division
    // product
    // expression with all operators
    // expression with inverted precedence

    // null -> IllegalArgumentException
    @Test
    void computeWithNullParameterShouldRaiseIllegalArgumentException() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class,
            () -> calculator.compute(null));
    }

    // empty string -> IllegalArgumentException
    @Test
    void computeWithEmptyStringParameterShouldRaiseIllegalArgumentException() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class,
            () -> calculator.compute(""));
    }

    // just a number
    @Test
    void computeWithSingleNumberShouldReturnItsValue() {
        Calculator calculator = new Calculator();
        assertEquals(123, calculator.compute("123"));
    }
 
    // numbers must not be longer than 3 digits
    @Test
    void computeWithSingleLongNumberShouldRaiseIllegalArgumentException() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class,
            () -> calculator.compute("1234"));
    }
    
    // sum
    @Test
    void computeWithSingleSumShouldReturnItsValue() {
        Calculator calculator = new Calculator();
        assertEquals(235, calculator.compute("1+234"));
    }

    // subtraction
    @Test
    void computeWithSingleSubtractionShouldReturnItsValue() {
        Calculator calculator = new Calculator();
        assertEquals(965, calculator.compute("971-6"));
    }

}
