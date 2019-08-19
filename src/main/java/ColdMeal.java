import java.time.LocalDateTime;


public class ColdMeal {

    public static boolean isSameDates(LocalDateTime arrivalDate, LocalDateTime referenceDate){

        return arrivalDate.equals(referenceDate);
    }
}
