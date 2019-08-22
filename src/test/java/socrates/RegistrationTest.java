package socrates;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class RegistrationTest {

    @Test
    void number_of_missing_meal_for_complete_stay_should_return_zero() {
        CheckIn checkin = new CheckIn(LocalDateTime.of(2019, 10, 17, 0, 0));
        LocalDateTime checkout = LocalDateTime.of(2019, 10, 20, 15, 00);

        Assertions.assertEquals(0, numberOfMissingMeal(checkin, checkout));
    }

    @Test
    void number_of_missing_meal_for_early_checkout_should_return_1() {
        CheckIn checkin = new CheckIn(LocalDateTime.of(2019, 10, 17, 0, 0));
        LocalDateTime checkout = LocalDateTime.of(2019, 10, 19, 18, 0);

        Assertions.assertEquals(1, numberOfMissingMeal(checkin, checkout));
    }

    private int numberOfMissingMeal(CheckIn checkin, LocalDateTime checkout) {
        if (checkout.isBefore(LocalDateTime.of(2019, 10, 20, 0, 0))) {
            return 1;
        }
        return 0;
    }
}
