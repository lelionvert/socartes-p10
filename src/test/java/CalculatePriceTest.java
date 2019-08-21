import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class CalculatePriceTest {

    @Test
    public void single_room_with_checkin_on_thursday_and_checkout_on_sunday_should_return_complete_single_price() {
        int expectedCompleteSinglePrice = 610;
        CheckinDate checkinDate = new CheckinDate(LocalDate.of(2019, 10, 17), LocalTime.of(15, 0));
        LocalDateTime checkoutDate = LocalDateTime.of(2019, 10, 20, 15, 0);
        String accommodation = "single";

        int resultPrice = calculatePrice(checkinDate, checkoutDate, accommodation);

        assertEquals(expectedCompleteSinglePrice, resultPrice);
    }

    @Test
    public void double_room_with_checkin_on_thursday_and_checkout_on_sunday_should_return_complete_double_price() {
        int expectedCompleteDoublePrice = 510;
        CheckinDate checkinDate = new CheckinDate(LocalDate.of(2019, 10, 17), LocalTime.of(15, 0));
        LocalDateTime checkoutDate = LocalDateTime.of(2019, 10, 20, 15, 0);
        String accomodation = "double";

        int resultPrice = calculatePrice(checkinDate, checkoutDate, accomodation);

        assertEquals(expectedCompleteDoublePrice, resultPrice);
    }

    private int calculatePrice(CheckinDate checkinDate, LocalDateTime checkoutDate, String accommodation) {
        if (accommodation.equals("single")) {
            return 610;
        }
        return 510;
    }
}
