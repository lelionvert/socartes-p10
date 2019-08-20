public class ColdMeal {

    private CheckinDate conferenceDate;

    public ColdMeal(CheckinDate conferenceDate) {
        this.conferenceDate = conferenceDate;
    }

    public boolean needOneColdMeal(CheckinDate arrivalDate){

        return arrivalDate.isInColdMealTime(conferenceDate);
    }


}
