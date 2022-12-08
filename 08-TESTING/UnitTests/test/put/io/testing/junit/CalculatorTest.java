package put.io.testing.junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }
    @Test
    public void testAdd() {
        int res = calculator.add(10, 5);
        assertEquals(15, res);
        res = calculator.add(0, 0);
        assertEquals(0, res);
        res = calculator.add(2, 10);
        assertEquals(12, res);
    }

    @Test
    public void testMultiply() {
        int res = calculator.multiply(10, 5);
        assertEquals(50, res);
        res = calculator.multiply(0, 0);
        assertEquals(0, res);
        res = calculator.multiply(5, 1);
        assertEquals(5, res);
    }

    @Test
    public void testAddPositiveNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.addPositiveNumbers(-5, 10);
        });

        assertEquals("The arguments must be positive", exception.getMessage());


    }
}