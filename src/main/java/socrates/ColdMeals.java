package socrates;

import java.time.LocalDateTime;
import java.util.List;

public class ColdMeals {

    private final LocalDateTime coldMealsStartTime;

    public ColdMeals() {
        coldMealsStartTime = LocalDateTime.of(2019, 10, 17, 21, 0);
    }

    public int countColdMeals(List<LocalDateTime> checkingDates) {
        int countColdMeals = 0;
        for (LocalDateTime dateTime : checkingDates) {
            if (isColdMealTime(dateTime)) {
                countColdMeals++;
            }
        }
        return countColdMeals;
    }

    private boolean isColdMealTime(LocalDateTime dateTime) {
        return dateTime.isAfter(coldMealsStartTime) && dateTime.isBefore(coldMealsStartTime.plusHours(3));
    }
}