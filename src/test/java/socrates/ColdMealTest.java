package socrates;

import org.junit.Test;
import socrates.ColdMeals;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class ColdMealTest {

    private final ColdMeals coldMeals = new ColdMeals();

    @Test
    public void count_cold_meals_should_return_1_when_date_is_after_nine_and_before_midnight() {
        int expectedNumberOfColdMeals = 1;

        int result = coldMeals.countColdMeals(Collections.singletonList(aDate(17, 22, 0)));

        assertEquals(expectedNumberOfColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_0_when_date_is_before_nine() {
        int expectedNumberOfColdMeals = 0;

        int result = coldMeals.countColdMeals(Collections.singletonList(aDate(17, 20, 0)));

        assertEquals(expectedNumberOfColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_0_when_date_is_empty() {
        int expectedNumberOfColdMeals = 0;

        int result = coldMeals.countColdMeals(Collections.emptyList());

        assertEquals(expectedNumberOfColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_2_when_list_of_date_contains_2_date_between_nine_and_midnight() {
        int expectedNumberOfColdMeals = 2;

        int result = coldMeals.countColdMeals(Arrays.asList(aDate(17, 22, 0),
                aDate(17, 22, 30)));

        assertEquals(expectedNumberOfColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_0_when_only_limit_date() {
        int expectedNumberOfColdMeals = 0;

        int result = coldMeals.countColdMeals(Collections.singletonList(aDate(17, 21, 0)));

        assertEquals(expectedNumberOfColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_0_when_date_after_midnight() {
        int expectedNumberOfColdMeals = 0;

        int result = coldMeals.countColdMeals(Collections.singletonList(aDate(18, 0, 0)));

        assertEquals(expectedNumberOfColdMeals, result);
    }

    private static LocalDateTime aDate(int day, int hour, int minute) {
        return LocalDateTime.of(2019, 10, day, hour, minute);
    }
}
