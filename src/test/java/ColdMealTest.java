import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ColdMealTest {

    @Test
    public void when_arrival_date_is_the_same_as_the_conference_date_then_should_return_true() {
        CheckinDate arrivalDate = new CheckinDate(LocalDate.of(2019, 10, 17));
        CheckinDate conferenceDate = new CheckinDate(LocalDate.of(2019, 10, 17));

        assertTrue(conferenceDate.isSameDate(arrivalDate));
    }

    @Test
    public void when_arrival_date_is_the_same_as_the_conference_date_then_should_return_true_triangulation() {
        CheckinDate arrivalDate = new CheckinDate(LocalDate.of(2019, 10, 19));
        CheckinDate conferenceDate = new CheckinDate(LocalDate.of(2019, 10, 17));

        assertFalse(conferenceDate.isSameDate(arrivalDate));
    }

    @Test
    public void when_arrival_date_is_same_as_conference_date_and_after_nine_PM_then_should_return_true() {
        LocalTime beginHourForColdMeal = LocalTime.of(21, 0);
        LocalDate dayOfColdMeal = LocalDate.of(2019, 10, 17);
        CheckinDate timeLimitForColdMeal = new CheckinDate(dayOfColdMeal, beginHourForColdMeal);
        ColdMeal coldMeal = new ColdMeal(timeLimitForColdMeal);

        LocalDate arrivalDay = LocalDate.of(2019, 10, 17);
        LocalTime arrivalHour = LocalTime.of(22, 0);
        CheckinDate arrivalDate = new CheckinDate(arrivalDay, arrivalHour);

        assertTrue(coldMeal.needOneColdMeal(arrivalDate));

    }
}
