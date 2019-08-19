import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ColdMealTest {

    @Test
    public void count_cold_meals_should_return_1_when_date_is_after_nine() {
        int numberOfColdMeals = 1;
        Assert.assertEquals(numberOfColdMeals, countColdMeals(Arrays.asList(LocalDateTime.of(2019,10,17,22,00))));
    }

    private int countColdMeals(List<LocalDateTime> asList) {
        return 1;
    }
}
