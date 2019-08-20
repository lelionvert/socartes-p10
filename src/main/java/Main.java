import socrates.CheckIn;
import socrates.ColdMeals;

import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.*;

public class Main {
    public static void main(String[] args) {
        ColdMeals coldMeals = new ColdMeals();
        List<CheckIn> checkins = new ArrayList<>();
        checkins.add(checkInOf(17, 20));
        checkins.add(checkInOf(17, 22));
        checkins.add(checkInOf(18, 0));
        checkins.add(checkInOf(17, 21));
        int resultColdMeals = coldMeals.countColdMeals(checkins);

        System.out.println("Nombre de repas froid: " + resultColdMeals);
    }
    private static CheckIn checkInOf(int day, int hour) {
        return new CheckIn(of(2019, 10, day, hour, 0));
    }
}
