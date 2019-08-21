import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceCalculatorTest {
    @Test
    public void when_book_a_single_room_then_return_a_single_room_price() {
        int calculatedPrice = PriceCalculator.compute();
        int expectedPrice = 610;
        assertEquals(expectedPrice, calculatedPrice);
    }
}
