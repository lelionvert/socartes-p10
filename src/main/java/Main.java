import socrates.ColdMeals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ColdMeals coldMeals = new ColdMeals();
        List<LocalDateTime> checkins = new ArrayList<>();
        checkins.add(LocalDateTime.of(2019, 10, 17, 20, 0));
        checkins.add(LocalDateTime.of(2019, 10, 17 , 22, 0));
        checkins.add(LocalDateTime.of(2019, 10, 18, 0, 0));
        checkins.add(LocalDateTime.of(2019, 10, 17, 21, 0));

        int resultColdMeals = coldMeals.countColdMeals(checkins);

        System.out.println("Nombre de repas froid: " + resultColdMeals);
    }
}
