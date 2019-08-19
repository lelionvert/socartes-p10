import java.time.LocalDateTime;
import java.util.List;

public class ColdMeals {
    private static final LocalDateTime COLD_MEALS_START_TIME = LocalDateTime.of(2019,10,17,21,0);
    private static final LocalDateTime COLD_MEAL_END_TIME = LocalDateTime.of(2019,10,18,0,0);

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
        return dateTime.isAfter(COLD_MEALS_START_TIME) && dateTime.isBefore(COLD_MEAL_END_TIME);
    }
}