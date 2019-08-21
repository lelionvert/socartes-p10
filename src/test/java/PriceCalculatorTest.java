import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PriceCalculatorTest {

    @Test
    public void acceptance_test_complete_price_scenario() {
        int mealPrice = 40;
        CheckinDate confStart = new CheckinDate(LocalDate.now(), LocalTime.MIN);
        CheckinDate confEnd = new CheckinDate(LocalDate.now(), LocalTime.MAX);
        Map<RoomType, Integer> roomTypePrices = new HashMap<>();

        roomTypePrices.put(RoomType.SINGLE, 610);
        roomTypePrices.put(RoomType.DOUBLE, 510);
        roomTypePrices.put(RoomType.TRIPLE, 410);
        roomTypePrices.put(RoomType.NO_ACCOMMODATION, 240);

        PriceCalculator priceCalculator = new PriceCalculator(mealPrice, confStart, confEnd, roomTypePrices);

        CheckinDate checkInDate = new CheckinDate(LocalDate.now(), LocalTime.MIN);
        CheckinDate checkOutDate = new CheckinDate(LocalDate.now(), LocalTime.MAX);

        int[] expected = {610, 510, 410, 240};
        RoomType[] input = {RoomType.SINGLE, RoomType.DOUBLE, RoomType.TRIPLE, RoomType.NO_ACCOMMODATION};
        for (int i = 0; i < expected.length; i++) {
            RoomType roomType = input[i];
            int calculatedPrice = priceCalculator.computePrice(roomType, checkInDate, checkOutDate);
            int expectedPrice = expected[i];
            assertEquals(expectedPrice, calculatedPrice);
        }
    }

    @Test
    public void when_book_a_single_room_with_full_stay_then_return_a_single_room_full_price() {
        int calculatedPrice = PriceCalculator.computePrice(RoomType.SINGLE, null, null);
        int singleRoomFullPrice = 610;
    }

    @Test
    public void when_book_double_room_with_full_stay_then_return_double_room_full_price() {
        int calculatedPrice = PriceCalculator.computePrice(RoomType.DOUBLE, null, null);
        int doubleRoomFullPrice = 510;
        assertEquals(doubleRoomFullPrice, calculatedPrice);
    }
}
