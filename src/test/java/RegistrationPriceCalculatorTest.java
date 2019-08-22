import org.junit.Test;

import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RegistrationPriceCalculatorTest {

    @Test
    public void acceptance_test_complete_price_scenario() {
        int mealPrice = 40;

        Map<RoomType, Integer> roomTypePrices = initializeRoomTypePrice();

        LocalDateTime conferenceStart = LocalDateTime.of(2019, 10, 17, 0, 0);
        LocalDateTime conferenceEnd = LocalDateTime.of(2019, 10, 20, 14, 0);
        Stay conferenceFullStay = new Stay(conferenceStart, conferenceEnd);

        RegistrationPriceCalculator registrationPriceCalculator = new RegistrationPriceCalculator(
                mealPrice, conferenceFullStay, roomTypePrices);

        LocalDateTime participantArrival = LocalDateTime.of(2019, 10, 17, 18, 0);
        LocalDateTime participantDeparture = LocalDateTime.of(2019, 10, 20, 16, 0);
        Stay participantStay = new Stay(participantArrival, participantDeparture);


        int expectedPrice = 610;

        int calculatedPrice = registrationPriceCalculator.computePrice(RoomType.SINGLE, participantStay);

        assertEquals(expectedPrice, calculatedPrice);
    }

    private EnumMap<RoomType, Integer> initializeRoomTypePrice() {
        EnumMap<RoomType, Integer> roomTypePrices = new EnumMap(RoomType.class);
        roomTypePrices.put(RoomType.SINGLE, 610);
        roomTypePrices.put(RoomType.DOUBLE, 510);
        roomTypePrices.put(RoomType.TRIPLE, 410);
        roomTypePrices.put(RoomType.NO_ACCOMMODATION, 240);

        return roomTypePrices;
    }
}
