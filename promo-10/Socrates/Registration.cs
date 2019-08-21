using System;
using System.Collections.Generic;

namespace Socrates
{
    public class Registration
    {
        public Registration(int mealPrice, Dictionary<RoomType, int> roomTypesPrice, in DateTime conferenceStart, in DateTime conferenceEnd)
        {
        }

        private const int ROOM_PRICE_DOUBLE = 510;
        private const int ROOM_PRICE_SINGLE = 610;
        private const int ROOM_PRICE_TRIPLE = 410;

        public int Price(RoomType roomType, CheckIn checkIn, CheckOut checkOut)
        {
            if (RoomType.Double == roomType)
                return ROOM_PRICE_DOUBLE;

            if (RoomType.Triple == roomType)
                return ROOM_PRICE_TRIPLE;

            return ROOM_PRICE_SINGLE;
        }
    }
}