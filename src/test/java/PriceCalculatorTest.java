import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceCalculatorTest {
    @Test
    public void if_full_single_then_price_of_single() {
        int calculatedPrice = PriceCalculator.compute();
        assertEquals(610, calculatedPrice);
    }
}
