package socrates;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CheckIns {
    private final List<CheckIn> checkingDates = new ArrayList<>();

    public void addCheckin(CheckIn checkIn) {
        if (checkIn != null) {
            checkingDates.add(checkIn);
        }
    }

    int isSameDayAndAfter(LocalDateTime startTime) {
        return (int) checkingDates.stream()
                .filter(checkIn -> checkIn.isSameDayAndAfter(startTime))
                .count();
    }
}