import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ColdMealTest {

    public static final LocalDateTime COLD_MEALS_START_TIME = LocalDateTime.of(2019, 10, 17, 21, 00);

    @Test
    public void count_cold_meals_should_return_1_when_date_is_after_nine() {
        int numberOfColdMeals = 1;

        int result = countColdMeals(Arrays.asList(LocalDateTime.of(2019, 10, 17, 22, 00)));
        
        assertEquals(numberOfColdMeals, result);
    }

    @Test
    public void count_cold_meals_should_return_0_when_date_is_before_nine() {
        int numberOfColdMeals = 0;
        
        int result = countColdMeals(Arrays.asList(LocalDateTime.of(2019, 10, 17, 20, 00)));
        
        assertEquals(numberOfColdMeals, result);
    }

    private int countColdMeals(List<LocalDateTime> asList) {
        if(((LocalDateTime)asList.get(0)).isAfter(COLD_MEALS_START_TIME))
            return 1;
        return 0;
    }
}
