package socrates;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CheckIns {
    private List<CheckIn> checkingDates = new ArrayList<>();

    public void addCheckin(CheckIn checkIn){
        if(checkIn != null ){
            checkingDates.add(checkIn);
        }
    }

    public int count(LocalDateTime coldMealsStartTime) {
        return (int) checkingDates.stream()
                .filter(Objects::nonNull)
                .filter(checkIn -> checkIn.isWithinColdMealTime(coldMealsStartTime))
                .count();
    }
}