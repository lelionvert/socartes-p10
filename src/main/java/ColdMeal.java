public class ColdMeal {

    private CheckinDates conferenceDate;

    public ColdMeal(CheckinDates conferenceDate) {
        this.conferenceDate = conferenceDate;
    }

    public boolean needOneColdMeal(CheckinDates arrivalDate){

        return (this.conferenceDate.isSameDate(arrivalDate.date) && this.conferenceDate.hour.isBefore(arrivalDate.hour));
    }


}
