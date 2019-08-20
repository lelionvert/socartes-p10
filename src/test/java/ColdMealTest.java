import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ColdMealTest {

    @Test
    public void when_arrival_date_is_same_as_conference_date_and_after_nine_PM_then_should_return_true() {
        ColdMeal coldMeal = setUpColdMeal();
        CheckinDate arrivalDate = setUpCheckin(2019,10,17, 22, 0);

        assertTrue(coldMeal.needOneColdMeal(arrivalDate));

    }

    @Test
    public void when_arrival_date_and_hour_is_same_as_cold_meal_start_time_return_false() {
        ColdMeal coldMeal = setUpColdMeal();
        CheckinDate arrivalDate = setUpCheckin(2019,10,17, 21, 0);

        assertFalse(coldMeal.needOneColdMeal(arrivalDate));
    }

    @Test
    public void when_arrival_date_and_hour_is_same_as_cold_meal_end_time_return_false() {
        ColdMeal coldMeal = setUpColdMeal();
        CheckinDate arrivalDate = setUpCheckin(2019,10,18, 0, 0);

        assertFalse(coldMeal.needOneColdMeal(arrivalDate));
    }

    @Test
    public void when_no_checking_then_dont_count_any_cold_meal() {
        int expectedQuantityOfColdMeals = 0;
        ColdMeal coldMeal = setUpColdMeal();

        assertEquals(expectedQuantityOfColdMeals, coldMeal.count(null));
    }

    @Test
    public void when_one_checkin_in_cold_meal_range_then_count_one_cold_meal() {
        int expectedQuantityOfColdMeal = 1;
        ColdMeal coldMeal = setUpColdMeal();
        CheckinDate checkinDate = new CheckinDate(LocalDate.of(2019, 10, 17),LocalTime.of(22,0));

        assertEquals(expectedQuantityOfColdMeal, coldMeal.count(Collections.singletonList(checkinDate)));
    }

    @Test
    public void when_two_checkin_in_cold_meal_range_then_count_two_cold_meals() {
        int expectedQuantityOfColdMeals = 2;
        ColdMeal coldMeal = setUpColdMeal();
        List<CheckinDate> checkinDates = new ArrayList<>();
        checkinDates.add(setUpCheckin(2019,10,17,22,0));
        checkinDates.add(setUpCheckin(2019,10,17,23,0));

        assertEquals(expectedQuantityOfColdMeals, coldMeal.count(checkinDates));
    }

    @Test
    public void when_one_checkin_in_range_and_another_one_out_of_range_the_count_one_cold_meal() {
        int expectedQuantityOfColdMeals = 1;
        ColdMeal coldMeal = setUpColdMeal();
        List<CheckinDate> checkinDates = new ArrayList<>();
        checkinDates.add(setUpCheckin(2019,10,17,20,0));
        checkinDates.add(setUpCheckin(2019, 10, 17, 22, 0));

        assertEquals(expectedQuantityOfColdMeals, coldMeal.count(checkinDates));
    }

    private ColdMeal setUpColdMeal() {
        LocalTime beginHourForColdMeal = LocalTime.of(21, 0);
        LocalDate dayOfColdMeal = LocalDate.of(2019, 10, 17);
        CheckinDate timeLimitForColdMeal = new CheckinDate(dayOfColdMeal, beginHourForColdMeal);
        return new ColdMeal(timeLimitForColdMeal);
    }

    private CheckinDate setUpCheckin(int year, int month, int day, int hour, int minute) {
        LocalDate arrivalDay = LocalDate.of(year, month, day);
        LocalTime arrivalHour = LocalTime.of(hour, minute);
        return new CheckinDate(arrivalDay, arrivalHour);
    }
}
