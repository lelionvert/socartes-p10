package socrates.Participant;

import java.time.LocalDate;
import java.util.Date;

public class Participant {
    private final Date dateArrival;

    public Participant(Date date) {
        dateArrival = date;
    }

    public boolean comeAfterNinePM() {
        return this.dateArrival.after(new Date(2019,10,17,21,00));
    }
}
