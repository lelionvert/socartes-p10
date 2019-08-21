public class PriceCalculator {

    private static final int SINGLE_ROOM_FULL_PRICE = 610;
    private static final int DOUBLE_ROOM_FULL_PRICE = 510;
    private static final int TRIPLE_ROOM_FULL_PRICE = 410;
    private static final int NO_ACCOMMODATION_FULL_PRICE = 240;

    public static int computePrice(RoomType roomType) {
        if(RoomType.DOUBLE.equals(roomType))
            return DOUBLE_ROOM_FULL_PRICE;
        if(RoomType.TRIPLE.equals(roomType))
            return TRIPLE_ROOM_FULL_PRICE;
        if(RoomType.NO_ACCOMMODATION.equals(roomType))
            return NO_ACCOMMODATION_FULL_PRICE;
        return SINGLE_ROOM_FULL_PRICE;
    }

}
