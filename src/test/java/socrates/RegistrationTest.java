package socrates;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.of;

public class RegistrationTest {

    @Test
    void price_for_single_room_with_complete_stay_should_be_full_price() {
        LocalDateTime conferenceStart = of(2019, 10, 17, 0, 0);
        LocalDateTime conferenceEnd = of(2019, 10, 20, 15, 0);
        CheckIn checkin = new CheckIn(of(2019, 10, 17, 0, 0));
        LocalDateTime checkout = of(2019, 10, 20, 18, 0);
        RoomType roomType = new RoomType("SINGLE");
        RoomByType roomByType = new RoomByType();
        int mealPrice = 40;
        Registration registration = new Registration(conferenceStart, conferenceEnd, roomByType, mealPrice);

        Assertions.assertEquals(610, registration.calculatePrice(checkin, checkout, roomType));
    }


    //    @Test
//    void number_of_missing_meal_for_complete_stay_should_return_zero() {
//        LocalDateTime checkout = checkout(20, 15);
//
//        Assertions.assertEquals(0, numberOfMissingMeal(checkin(), checkout));
//    }
//
//    private LocalDateTime checkout(int day, int hour) {
//        return LocalDateTime.of(2019, 10, day, hour, 00);
//    }
//
//    @Test
//    void number_of_missing_meal_for_early_checkout_should_return_1() {
//        LocalDateTime checkout = checkout(19, 18);
//
//        Assertions.assertEquals(1, numberOfMissingMeal(checkin(), checkout));
//    }
//
//    private CheckIn checkin() {
//        return new CheckIn(checkout(17, 0));
//    }
//
//    private int numberOfMissingMeal(CheckIn checkin, LocalDateTime checkout) {
//        if (checkout.isBefore(checkout(20, 0))) {
//            return 1;
//        }
//        return 0;
//    }
}
