public class ColdMeal {

    private CheckinDate conferenceDate;

    public ColdMeal(CheckinDate conferenceDate) {
        this.conferenceDate = conferenceDate;
    }

    public boolean needOneColdMeal(CheckinDate arrivalDate){

        return arrivalDate.isInColdMealTime(conferenceDate);
    }


    public int count(CheckinDate checkinDate) {
        if(checkinDate != null){
            return 1;
        }
        return 0;
    }
}
