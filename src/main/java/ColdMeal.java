import java.util.List;

public class ColdMeal {

    private CheckinDate conferenceDate;

    public ColdMeal(CheckinDate conferenceDate) {
        this.conferenceDate = conferenceDate;
    }

    public boolean needOneColdMeal(CheckinDate arrivalDate) {

        return arrivalDate.isInColdMealTime(conferenceDate);
    }


    public int count(List<CheckinDate> checkinDates) {
        if (checkinDates != null) {
            int count = 0;
            for (CheckinDate checkinDate : checkinDates) {
                if(needOneColdMeal(checkinDate)){
                    count++;
                }
            }
            return count;
        }
        return 0;
    }
}
