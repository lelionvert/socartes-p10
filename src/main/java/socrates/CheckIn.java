package socrates;

import java.time.LocalDateTime;

public class CheckIn {

    private final LocalDateTime checkInDateTime;

    public CheckIn(LocalDateTime checkInDateTime) {
        this.checkInDateTime = checkInDateTime;
    }

    boolean isBetween(LocalDateTime coldMealsStartTime) {
        boolean isSameDay = checkInDateTime.getDayOfMonth() == coldMealsStartTime.getDayOfMonth();

        return checkInDateTime.isAfter(coldMealsStartTime) &&
                isSameDay;
    }
}