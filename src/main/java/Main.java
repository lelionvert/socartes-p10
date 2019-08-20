import socrates.CheckIn;
import socrates.CheckIns;
import socrates.ColdMeals;

import static java.time.LocalDateTime.*;

public class Main {
    public static void main(String[] args) {
        ColdMeals coldMeals = new ColdMeals(of(2019, 10, 17, 21, 0));
        CheckIns checkins = new CheckIns();
        checkins.addCheckin(checkInOf(17, 20));
        checkins.addCheckin(checkInOf(17, 22));
        checkins.addCheckin(checkInOf(18, 0));
        checkins.addCheckin(checkInOf(17, 21));
        checkins.addCheckin(null);
        int resultColdMeals = coldMeals.count(checkins);

        System.out.println("Nombre de repas froid: " + resultColdMeals);
    }
    private static CheckIn checkInOf(int day, int hour) {
        return new CheckIn(of(2019, 10, day, hour, 0));
    }
}
