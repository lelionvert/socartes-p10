import java.util.Map;

public class RegistrationPriceCalculator {


    private Map<RoomType, Integer> roomTypePrices;

    public RegistrationPriceCalculator(int mealPrice, Stay conferenceFullStay, Map<RoomType, Integer> roomTypePrices) {
        this.roomTypePrices = roomTypePrices;
    }

    public int computePrice(RoomType roomType, Stay participantStay) {
        return roomTypePrices.get(roomType);
    }
}
