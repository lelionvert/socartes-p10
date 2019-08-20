package socrates;

import java.time.LocalDateTime;

public class ColdMeals {

    private final LocalDateTime coldMealsStartTime;

    public ColdMeals(LocalDateTime coldMealsStartTime) {
        this.coldMealsStartTime = coldMealsStartTime;
    }

    public int count(CheckIns checkingDates) {
        if(checkingDates == null)
            return 0;
        return checkingDates.count(coldMealsStartTime);
    }
}