import java.time.LocalDate;
import java.util.Date;


public class ColdMeal {

    public static boolean isSameDates(LocalDate arrivalDate, LocalDate referenceDate){

        return arrivalDate.equals(referenceDate);
    }
}
