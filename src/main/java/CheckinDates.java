import java.time.LocalDate;

public class CheckinDates {
    public LocalDate date;

    public CheckinDates(LocalDate date) {
        this.date = date;
    }

    public boolean isSameDate(LocalDate otherDate){
        return this.date.equals(otherDate);
    }
}
