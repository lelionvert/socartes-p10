import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class CheckinDate {

    private LocalDate date;
    private LocalTime hour;

    public CheckinDate(LocalDate date) {
        this.date = date;
    }

    public CheckinDate(LocalDate date, LocalTime hour) {
        this.date = date;
        this.hour = hour;
    }

    public boolean isSameDate(CheckinDate otherDate){
        return this.equals(otherDate);
    }

    public boolean isInColdMealTime(CheckinDate otherDate){
        return isSameDate(otherDate) && this.hour.isBefore(otherDate.hour);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckinDate that = (CheckinDate) o;
        return Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}
