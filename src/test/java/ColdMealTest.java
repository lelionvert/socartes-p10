import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;


import static org.junit.Assert.*;

public class ColdMealTest {

    @Test
    public void when_arrival_date_is_the_same_as_the_conference_date_then_should_return_true() throws ParseException {
        CheckinDates arrivalDate = new CheckinDates(LocalDate.of(2019,10,17));
        CheckinDates conferenceDate = new CheckinDates(LocalDate.of(2019,10,17));

        assertTrue(conferenceDate.isSameDate(arrivalDate.date));
    }

    @Test
    public void when_arrival_date_is_the_same_as_the_conference_date_then_should_return_true_triangulation() throws ParseException {
        CheckinDates arrivalDate = new CheckinDates(LocalDate.of(2019,10,19));
        CheckinDates conferenceDate = new CheckinDates(LocalDate.of(2019,10,17));

        assertFalse(conferenceDate.isSameDate(arrivalDate.date));
    }

    @Test
    public void when_arrival_date_is_same_as_conference_date_and_after_nine_PM_then_should_return_true() {
        ColdMeal coldMeal = new ColdMeal(new CheckinDates(LocalDate.of(2019,10,17)));
        CheckinDates arrivalDate = new CheckinDates (LocalDate.of(2019, 10, 17));

        assertTrue(coldMeal.needOneColdMeal(arrivalDate));

    }
}
