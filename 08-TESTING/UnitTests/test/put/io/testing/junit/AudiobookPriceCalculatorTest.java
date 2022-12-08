package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import put.io.testing.audiobooks.Audiobook;
import put.io.testing.audiobooks.AudiobookPriceCalculator;
import put.io.testing.audiobooks.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AudiobookPriceCalculatorTest {
    private AudiobookPriceCalculator calculator;
    private Audiobook audiobook;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        calculator = new AudiobookPriceCalculator();
        audiobook = new Audiobook("Lord of the Rings", 30);
    }

    @Test
    void testCalculateStandard() {
        customer = new Customer("Test", Customer.LoyaltyLevel.STANDARD, false);
        assertEquals(calculator.calculate(customer, audiobook), 30 * 1.0);

    }
    @Test
    void testCalculateGold() {
        customer = new Customer("Test", Customer.LoyaltyLevel.GOLD, false);
        assertEquals(calculator.calculate(customer, audiobook), 30 * 0.8);

    }
    @Test
    void testCalculateSilver() {
        customer = new Customer("Test", Customer.LoyaltyLevel.SILVER, false);
        assertEquals(calculator.calculate(customer, audiobook), 30 * 0.9);

    }
    @Test
    public void testSubscriber() {
        customer = new Customer("Test", Customer.LoyaltyLevel.STANDARD, true);
        assertEquals(calculator.calculate(customer, audiobook), 0);
    }


}
