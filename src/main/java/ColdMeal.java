public class ColdMeal {

    public static boolean isSameDates(CheckinDates arrivalDate, CheckinDates referenceDate){

        return arrivalDate.isSameDate(referenceDate.date);
    }
}
