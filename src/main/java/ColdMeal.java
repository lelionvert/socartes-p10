public class ColdMeal {

    private CheckinDates conferenceDate;

    public ColdMeal(CheckinDates conferenceDate) {
        this.conferenceDate = conferenceDate;
    }

    public boolean needOneColdMeal(CheckinDates arrivalDate){

        return arrivalDate.isSameDate(this.conferenceDate.date);
    }


}
