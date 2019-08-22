import org.junit.Test;

import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RegistrationPriceCalculatorTest {


    public static final int MEAL_PRICE = 40;

    @Test
    public void acceptance_test_single_room_with_full_stay() {

        Map<RoomType, Integer> roomTypePrices = initializeRoomTypePrice();

        LocalDateTime conferenceStart = LocalDateTime.of(2019, 10, 17, 0, 0);
        LocalDateTime conferenceEnd = LocalDateTime.of(2019, 10, 20, 14, 0);
        Stay conferenceFullStay = new Stay(conferenceStart, conferenceEnd);

        RegistrationPriceCalculator registrationPriceCalculator = new RegistrationPriceCalculator(
                MEAL_PRICE, conferenceFullStay, roomTypePrices);

        LocalDateTime participantArrival = LocalDateTime.of(2019, 10, 17, 18, 0);
        LocalDateTime participantDeparture = LocalDateTime.of(2019, 10, 20, 16, 0);
        Stay participantStay = new Stay(participantArrival, participantDeparture);


        int expectedPrice = 610;

        int calculatedPrice = registrationPriceCalculator.computePrice(RoomType.SINGLE, participantStay);

        assertEquals(expectedPrice, calculatedPrice);
    }

    @Test
    public void acceptance_test_double_room_late_checkin() {

        Map<RoomType, Integer> roomTypePrices = initializeRoomTypePrice();

        LocalDateTime conferenceStart = LocalDateTime.of(2019, 10, 17, 0, 0);
        LocalDateTime conferenceEnd = LocalDateTime.of(2019, 10, 20, 14, 0);
        Stay conferenceFullStay = new Stay(conferenceStart, conferenceEnd);

        RegistrationPriceCalculator registrationPriceCalculator = new RegistrationPriceCalculator(
                MEAL_PRICE, conferenceFullStay, roomTypePrices);

        LocalDateTime participantArrival = LocalDateTime.of(2019, 10, 18, 11, 0);
        LocalDateTime participantDeparture = LocalDateTime.of(2019, 10, 20, 16, 0);
        Stay participantStay = new Stay(participantArrival, participantDeparture);


        int expectedPrice = 510 - MEAL_PRICE;

        int calculatedPrice = registrationPriceCalculator.computePrice(RoomType.DOUBLE, participantStay);

        assertEquals(expectedPrice, calculatedPrice);
    }

    @Test
    public void acceptance_test_triple_room_early_checkout() {

        Map<RoomType, Integer> roomTypePrices = initializeRoomTypePrice();

        LocalDateTime conferenceStart = LocalDateTime.of(2019, 10, 17, 0, 0);
        LocalDateTime conferenceEnd = LocalDateTime.of(2019, 10, 20, 14, 0);
        Stay conferenceFullStay = new Stay(conferenceStart, conferenceEnd);

        RegistrationPriceCalculator registrationPriceCalculator = new RegistrationPriceCalculator(
                MEAL_PRICE, conferenceFullStay, roomTypePrices);

        LocalDateTime participantArrival = LocalDateTime.of(2019, 10, 17, 19, 0);
        LocalDateTime participantDeparture = LocalDateTime.of(2019, 10, 20, 11, 0);
        Stay participantStay = new Stay(participantArrival, participantDeparture);

        int expectedPrice = 410 - MEAL_PRICE;

        int calculatedPrice = registrationPriceCalculator.computePrice(RoomType.TRIPLE, participantStay);

        assertEquals(expectedPrice, calculatedPrice);
    }
    @Test
    public void acceptance_test_no_accommodation_with_short_stay() {

        Map<RoomType, Integer> roomTypePrices = initializeRoomTypePrice();

        LocalDateTime conferenceStart = LocalDateTime.of(2019, 10, 17, 0, 0);
        LocalDateTime conferenceEnd = LocalDateTime.of(2019, 10, 20, 14, 0);
        Stay conferenceFullStay = new Stay(conferenceStart, conferenceEnd);

        RegistrationPriceCalculator registrationPriceCalculator = new RegistrationPriceCalculator(
                MEAL_PRICE, conferenceFullStay, roomTypePrices);

        LocalDateTime participantArrival = LocalDateTime.of(2019, 10, 18, 10, 0);
        LocalDateTime participantDeparture = LocalDateTime.of(2019, 10, 19, 22, 0);
        Stay participantStay = new Stay(participantArrival, participantDeparture);

        int expectedPrice = 240 - MEAL_PRICE * 2;

        int calculatedPrice = registrationPriceCalculator.computePrice(RoomType.NO_ACCOMMODATION, participantStay);

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
