import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ColdMealTest {

    public static final LocalDateTime COLD_MEALS_START_TIME = aDate(17, 21, 00);
    public static final LocalDateTime COLD_MEAL_END_TIME = aDate(18, 00, 00);

    @Test
    public void count_cold_meals_should_return_1_when_date_is_after_nine() {
        int numberOfColdMeals = 1;

        int result = countColdMeals(Arrays.asList(aDate(17, 22, 00)));

        assertEquals(numberOfColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_0_when_date_is_before_nine() {
        int numberOfColdMeals = 0;

        int result = countColdMeals(Arrays.asList(aDate(17, 20, 00)));

        assertEquals(numberOfColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_0_when_date_is_empty() {
        int numberColdMeals = 0;

        int result = countColdMeals(Arrays.asList());

        assertEquals(numberColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_2_when_list_of_date() {
        int numberOfColdMeals = 2;

        int result = countColdMeals(Arrays.asList(aDate(17, 22, 00),
                aDate(17, 22, 30)));

        assertEquals(numberOfColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_0_when_list_of_date() {
        int numberOfColdMeals = 0;

        int result = countColdMeals(Arrays.asList(aDate(17, 21, 00)));

        assertEquals(numberOfColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_0_when_date_after_midnight() {
        int numberOfColdMeals = 0;

        int result = countColdMeals(Arrays.asList(aDate(18, 00, 00)));

        assertEquals(numberOfColdMeals, result);
    }

    private static LocalDateTime aDate(int day, int hour, int minute) {
        return LocalDateTime.of(2019, 10, day, hour, minute);
    }

    private int countColdMeals(List<LocalDateTime> checkingDates) {
        int countColdMeals = 0;
        for (LocalDateTime dateTime : checkingDates) {
            if (dateTime.isAfter(COLD_MEALS_START_TIME) && dateTime.isBefore(COLD_MEAL_END_TIME))
                countColdMeals++;
        }
        return countColdMeals;
    }
}
