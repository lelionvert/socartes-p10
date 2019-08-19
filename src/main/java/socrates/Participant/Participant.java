package socrates.Participant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Participant {
    public static final LocalDateTime LIMIT_ARRIVAL_HOUR = LocalDateTime.of(2019, 10, 17, 21, 00);
    private final LocalDateTime dateArrival;

    public Participant(LocalDateTime date) {
        dateArrival = date;
    }

    public boolean comeAfterNinePM() {
        return this.dateArrival.isAfter(LIMIT_ARRIVAL_HOUR);
    }


}
