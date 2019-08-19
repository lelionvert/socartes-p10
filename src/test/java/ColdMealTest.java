import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class ColdMealTest {

    @Test
    public void when_arrival_date_is_the_same_as_the_conference_date_then_should_return_true() throws ParseException {
        LocalDate arrivalDate = LocalDate.of(2019,10,17);
        LocalDate conferenceDate = LocalDate.of(2019,10,17);

        assertTrue(ColdMeal.isSameDates(arrivalDate, conferenceDate));
    }

    @Test
    public void when_arrival_date_is_the_same_as_the_conference_date_then_should_return_true_triangulation() throws ParseException {
        LocalDate arrivalDate = LocalDate.of(2019,10,19);
        LocalDate conferenceDate = LocalDate.of(2019,10,17);

        assertFalse(ColdMeal.isSameDates(arrivalDate, conferenceDate));
    }

}
