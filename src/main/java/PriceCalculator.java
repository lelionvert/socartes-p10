public class PriceCalculator {

    private static final int SINGLE_ROOM_FULL_PRICE = 610;
    private static final int DOUBLE_ROOM_FULL_PRICE = 510;

    public static int compute(String roomType) {
        if("double".equals(roomType))
            return DOUBLE_ROOM_FULL_PRICE;
        if("triple".equals(roomType))
            return 410;
        if("no accommodation".equals(roomType))
            return 240;
        return SINGLE_ROOM_FULL_PRICE;
    }
}
