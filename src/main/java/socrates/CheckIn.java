package socrates;

import java.time.LocalDateTime;

public class CheckIn {

    private final LocalDateTime checkInDateTime;

    public CheckIn(LocalDateTime checkInDateTime) {
        this.checkInDateTime = checkInDateTime;
    }

    boolean isWithinColdMealTime(LocalDateTime startTime) {
        boolean isSameDay = checkInDateTime.getDayOfMonth() == startTime.getDayOfMonth();

        return isSameDay && checkInDateTime.isAfter(startTime);
    }
}