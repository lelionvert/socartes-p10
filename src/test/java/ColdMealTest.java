import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDateTime;


import static org.junit.Assert.*;

public class ColdMealTest {

    @Test
    public void when_arrival_date_is_the_same_as_the_conference_date_then_should_return_true() throws ParseException {
        LocalDateTime arrivalDate = LocalDateTime.of(2019,10,17,0,0);
        LocalDateTime conferenceDate = LocalDateTime.of(2019,10,17,0,0);

        assertTrue(ColdMeal.isSameDates(arrivalDate, conferenceDate));
    }

    @Test
    public void when_arrival_date_is_the_same_as_the_conference_date_then_should_return_true_triangulation() throws ParseException {
        LocalDateTime arrivalDate = LocalDateTime.of(2019,10,19,0,0);
        LocalDateTime conferenceDate = LocalDateTime.of(2019,10,17,0,0);

        assertFalse(ColdMeal.isSameDates(arrivalDate, conferenceDate));
    }

}
