import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ColdMealTest {

    @Test
    public void when_arrival_date_is_same_as_conference_date_and_after_nine_PM_then_should_return_true() {
        ColdMeal coldMeal = getColdMeal();

        LocalDate arrivalDay = LocalDate.of(2019, 10, 17);
        LocalTime arrivalHour = LocalTime.of(22, 0);
        CheckinDate arrivalDate = new CheckinDate(arrivalDay, arrivalHour);

        assertTrue(coldMeal.needOneColdMeal(arrivalDate));

    }

    @Test
    public void when_arrival_date_and_hour_is_same_as_cold_meal_start_time_return_false() {
        ColdMeal coldMeal = getColdMeal();

        LocalDate arrivalDay = LocalDate.of(2019, 10, 17);
        LocalTime arrivalHour = LocalTime.of(21, 0);
        CheckinDate arrivalDate = new CheckinDate(arrivalDay, arrivalHour);
        assertFalse(coldMeal.needOneColdMeal(arrivalDate));
    }

    @Test
    public void when_arrival_date_and_hour_is_same_as_cold_meal_end_time_return_false() {
        ColdMeal coldMeal = getColdMeal();

        LocalDate arrivalDay = LocalDate.of(2019, 10, 18);
        LocalTime arrivalHour = LocalTime.of(0, 0);
        CheckinDate arrivalDate = new CheckinDate(arrivalDay, arrivalHour);

        assertFalse(coldMeal.needOneColdMeal(arrivalDate));
    }

    @Test
    public void when_no_checking_then_dont_count_any_cold_meal() {
        int expectedQuantityOfColdMeals = 0;

        ColdMeal coldMeal = getColdMeal();

        assertEquals(expectedQuantityOfColdMeals, coldMeal.count(null));
    }

    @Test
    public void when_one_checkin_in_cold_meal_range_then_count_one_cold_meal() {
        int expectedQuantityOfColdMeal = 1;

        ColdMeal coldMeal = getColdMeal();
        CheckinDate checkinDate = new CheckinDate(LocalDate.of(2019, 10, 17),LocalTime.of(22,0));

        assertEquals(expectedQuantityOfColdMeal, coldMeal.count(checkinDate));
    }

    private ColdMeal getColdMeal() {
        LocalTime beginHourForColdMeal = LocalTime.of(21, 0);
        LocalDate dayOfColdMeal = LocalDate.of(2019, 10, 17);
        CheckinDate timeLimitForColdMeal = new CheckinDate(dayOfColdMeal, beginHourForColdMeal);
        return new ColdMeal(timeLimitForColdMeal);
    }
}
