import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceCalculatorTest {

    @Test
    public void acceptance_test_complete_price_scenario() {
        int[] expected = {610, 510, 410, 240};
        RoomType[] input = {RoomType.SINGLE, RoomType.DOUBLE, RoomType.TRIPLE, RoomType.NO_ACCOMMODATION};
        for (int i = 0; i < expected.length; i++) {
            RoomType roomType = input[i];
            int calculatedPrice = PriceCalculator.computePrice(roomType);
            int expectedPrice = expected[i];
            assertEquals(expectedPrice, calculatedPrice);
        }
    }

    @Test
    public void when_book_a_single_room_with_full_stay_then_return_a_single_room_full_price() {
        int calculatedPrice = PriceCalculator.computePrice(RoomType.SINGLE);
        int singleRoomFullPrice = 610;
        assertEquals(singleRoomFullPrice, calculatedPrice);
    }

    @Test
    public void when_book_double_room_with_full_stay_then_return_double_room_full_price() {
        int calculatedPrice = PriceCalculator.computePrice(RoomType.DOUBLE);
        int doubleRoomFullPrice = 510;
        assertEquals(doubleRoomFullPrice, calculatedPrice);
    }
}
