import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ColdMealTest {

    @Test
    public void count_cold_meals_should_return_1_when_date_is_after_nine() {
        int numberOfColdMeals = 1;
        assertEquals(numberOfColdMeals, countColdMeals(Arrays.asList(LocalDateTime.of(2019,10,17,22,00))));
    }

    @Test
    public void count_cold_meals_should_return_0_when_date_is_before_nine() {
        int numberOfColdMeals = 0;
        assertEquals(numberOfColdMeals, countColdMeals(Arrays.asList(LocalDateTime.of(2019, 10, 17, 20, 00))));
    }

    private int countColdMeals(List<LocalDateTime> asList) {
        if(((LocalDateTime)asList.get(0)).isAfter(LocalDateTime.of(2019,10,17,21,00)))
            return 1;
        return 0;
    }
}
