import java.time.LocalDate;
import java.time.LocalTime;

public class CheckinDates {
    public LocalDate date;
    public LocalTime hour;

    public CheckinDates(LocalDate date) {
        this.date = date;
    }

    public CheckinDates(LocalDate date, LocalTime hour) {
        this.date = date;
        this.hour = hour;
    }

    public boolean isSameDate(LocalDate otherDate){
        return this.date.equals(otherDate);
    }
}
