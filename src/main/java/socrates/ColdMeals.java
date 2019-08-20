package socrates;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.*;

public class ColdMeals {

    private final LocalDateTime coldMealsStartTime;

    public ColdMeals() {
        coldMealsStartTime = of(2019, 10, 17, 21, 0);
    }

    public int countColdMeals(List<CheckIn> checkingDates) {
        int countColdMeals = 0;
        for (CheckIn dateTime : checkingDates) {
            if (dateTime.isBetween(coldMealsStartTime)) {
                countColdMeals++;
            }
        }
        return countColdMeals;
    }

}