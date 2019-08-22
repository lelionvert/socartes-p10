package socrates;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static java.time.LocalDateTime.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColdMealTest {


    private static final LocalDateTime COLD_MEALS_START_TIME = of(2019, 10, 17, 21, 0);
    private final ColdMeals coldMeals = new ColdMeals(COLD_MEALS_START_TIME);

    @Test
    public void count_cold_meals_should_return_1_when_participant_arrived_after_nine_and_before_midnight() {
        int expectedNumberOfColdMeals = 1;

        CheckIn checkIn = aCheckInDate(17, 22, 0);
        int result = coldMeals.count(getCheckIns(checkIn));

        assertEquals(expectedNumberOfColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_0_when_participant_arrived_before_nine() {
        int expectedNumberOfColdMeals = 0;

        CheckIn checkIn = aCheckInDate(17, 20, 0);
        int result = coldMeals.count(getCheckIns(checkIn));

        assertEquals(expectedNumberOfColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_0_when_there_is_no_participant() {
        int expectedNumberOfColdMeals = 0;

        int result = coldMeals.count(null);

        assertEquals(expectedNumberOfColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_2_when_2_participants_arrived_between_nine_and_midnight() {
        int expectedNumberOfColdMeals = 2;

        CheckIn checkIn = aCheckInDate(17, 22, 0);
        CheckIn checkIn1 = aCheckInDate(17, 22, 30);
        int result = coldMeals.count(getCheckIns(checkIn, checkIn1));

        assertEquals(expectedNumberOfColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_0_when_participant_arrive_at_nine() {
        int expectedNumberOfColdMeals = 0;

        CheckIn checkIn = aCheckInDate(17, 21, 0);
        int result = coldMeals.count(getCheckIns(checkIn));

        assertEquals(expectedNumberOfColdMeals, result);
    }


    @Test
    public void count_cold_meals_should_return_0_when_participant_arrived_after_midnight() {
        int expectedNumberOfColdMeals = 0;

        CheckIn checkIn = aCheckInDate(18, 0, 0);
        int result = coldMeals.count(getCheckIns(checkIn));

        assertEquals(expectedNumberOfColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_1_when_1_participant_arrived_at_3_pm_and_the_second_1_arrived_at_10_pm_and_the_third_1_arrived_the_day_after() {
        int expectedNumberOfColdMeals = 1;
        CheckIn dayAfterOfConferenceStart = aCheckInDate(18, 0, 0);
        CheckIn tenPM = aCheckInDate(17, 22, 0);
        CheckIn threePM = aCheckInDate(17, 15, 0);

        int result = coldMeals.count(getCheckIns(dayAfterOfConferenceStart, tenPM, threePM));

        assertEquals(expectedNumberOfColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_1_when_1_participant_arrived_at_10_pm_and_the_second_participant_have_no_checking() {
        int expectedNumberColdMeal = 1;
        CheckIn tenPM = aCheckInDate(17, 22, 0);

        int result = coldMeals.count(getCheckIns(tenPM, null));

        assertEquals(expectedNumberColdMeal, result);
    }

    private static CheckIn aCheckInDate(int day, int hour, int minute) {
        return new CheckIn(of(2019, 10, day, hour, minute));
    }

    private CheckIns getCheckIns(CheckIn... checkIn) {
        CheckIns checkIns = new CheckIns();
        Arrays.stream(checkIn).forEach(checkIns::addCheckin);

        return checkIns;
    }
}
