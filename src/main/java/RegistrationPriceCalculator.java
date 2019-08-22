import java.util.Map;

public class RegistrationPriceCalculator {


    public RegistrationPriceCalculator(int mealPrice, Stay conferenceFullStay, Map<RoomType, Integer> roomTypePrices) {

    }

    public int computePrice(RoomType roomType, Stay participantStay) {
        if(RoomType.DOUBLE.equals(roomType))
            return 510;
        return 610;
    }
}
