package socrates;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceCalculatorTest {

    @Test
    void single_room_price_for_complete_conference() {
        LocalDateTime conferenceStart = of(2019, 10, 17, 0, 0);
        LocalDateTime conferenceEnd = of(2019, 10, 20, 15, 0);
        CheckIn checkIn = new CheckIn(of(2019, 10, 17, 0, 0));
        LocalDateTime checkOut = of(2019, 10, 20, 18, 0);
        RoomType roomType = new RoomType("SINGLE");
        RoomByType roomByType = new RoomByType();
        int mealPrice = 40;
        Registration registation = new Registration(conferenceStart, conferenceEnd, roomByType, mealPrice);

        int result = registation.calculatePrice(checkIn, checkOut, roomType);

        assertEquals(610, result);
    }

    @Test
    void double_room_price_for_complete_conference() {
        LocalDateTime conferenceStart = of(2019, 10, 17, 0, 0);
        LocalDateTime conferenceEnd = of(2019, 10, 20, 15, 0);
        CheckIn checkIn = new CheckIn(of(2019, 10, 17, 0, 0));
        LocalDateTime checkOut = of(2019, 10, 20, 18, 0);
        RoomType roomType = new RoomType("DOUBLE");
        RoomByType roomByType = new RoomByType();
        int mealPrice = 40;
        Registration registation = new Registration(conferenceStart, conferenceEnd, roomByType, mealPrice);

        int result = registation.calculatePrice(checkIn, checkOut, roomType);

        assertEquals(510, result);
    }

    @Test
    void triple_room_price_for_complete_conference() {
        LocalDateTime conferenceStart = of(2019, 10, 17, 0, 0);
        LocalDateTime conferenceEnd = of(2019, 10, 20, 15, 0);
        CheckIn checkIn = new CheckIn(of(2019, 10, 17, 0, 0));
        LocalDateTime checkOut = of(2019, 10, 20, 18, 0);
        RoomType roomType = new RoomType("TRIPLE");
        RoomByType roomByType = new RoomByType();
        int mealPrice = 40;
        Registration registation = new Registration(conferenceStart, conferenceEnd, roomByType, mealPrice);

        int result = registation.calculatePrice(checkIn, checkOut, roomType);

        assertEquals(410, result);
    }

    @Test
    void no_room_price_for_complete_conference() {
        LocalDateTime conferenceStart = of(2019, 10, 17, 0, 0);
        LocalDateTime conferenceEnd = of(2019, 10, 20, 15, 0);
        CheckIn checkIn = new CheckIn(of(2019, 10, 17, 0, 0));
        LocalDateTime checkOut = of(2019, 10, 20, 18, 0);
        RoomType roomType = new RoomType("NO ACCOMMODATION");
        RoomByType roomByType = new RoomByType();
        int mealPrice = 40;
        Registration registation = new Registration(conferenceStart, conferenceEnd, roomByType, mealPrice);

        int result = registation.calculatePrice(checkIn, checkOut, roomType);

        assertEquals(240, result);
    }

    @Test
    void single_room_price_for_late_check_in() {
        LocalDateTime conferenceStart = of(2019, 10, 17, 0, 0);
        LocalDateTime conferenceEnd = of(2019, 10, 20, 15, 0);
        CheckIn checkIn = new CheckIn(of(2019, 10, 18, 0, 0));
        LocalDateTime checkOut = of(2019, 10, 20, 18, 0);
        RoomType roomType = new RoomType("SINGLE");
        RoomByType roomByType = new RoomByType();
        int mealPrice = 40;
        Registration registation = new Registration(conferenceStart, conferenceEnd, roomByType, mealPrice);

        int result = registation.calculatePrice(checkIn, checkOut, roomType);

        assertEquals(610 - mealPrice, result);
    }

    @Test
    void single_room_price_for_early_checkout() {
        LocalDateTime conferenceStart = of(2019, 10, 17, 0, 0);
        LocalDateTime conferenceEnd = of(2019, 10, 20, 15, 0);
        CheckIn checkIn = new CheckIn(of(2019, 10, 17, 0, 0));
        LocalDateTime checkOut = of(2019, 10, 20, 13, 0);
        RoomType roomType = new RoomType("SINGLE");
        RoomByType roomByType = new RoomByType();
        int mealPrice = 40;
        Registration registation = new Registration(conferenceStart, conferenceEnd, roomByType, mealPrice);

        int result = registation.calculatePrice(checkIn, checkOut, roomType);

        assertEquals(610 - mealPrice, result);
    }


}
