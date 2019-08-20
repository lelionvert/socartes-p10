package socrates;

import java.time.LocalDateTime;
import java.util.List;

class ColdMeals {

    int countColdMeals(List<LocalDateTime> checkingDates) {
        int countColdMeals = 0;
        for (LocalDateTime dateTime : checkingDates) {
            if (isColdMealTime(dateTime)) {
                countColdMeals++;
            }
        }
        return countColdMeals;
    }

    private boolean isColdMealTime(LocalDateTime dateTime) {
        LocalDateTime startTime = LocalDateTime.of(2019, 10, 17, 21, 0);
        return dateTime.isAfter(startTime) && dateTime.isBefore(startTime.plusHours(3));
    }
}