import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class ColdMealTest {

    @Test
    public void when_arrival_date_is_the_same_as_the_reference_date_then_should_return_one() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        Date arrivalDate = sdf.parse("17-10-2019");
        Date referenceDate = sdf.parse("17-10-2019");

        assertEquals(1, ColdMeal.compareDates(arrivalDate, referenceDate));
    }
}
