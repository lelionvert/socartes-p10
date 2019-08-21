public class PriceCalculator {

    public static int compute(String roomType) {
        if("double".equals(roomType))
            return 510;
        return 610;
    }
}
