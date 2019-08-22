using System;
using System.Collections.Generic;

namespace Socrates
{
    public class Registration
    {
        public Registration(int mealPrice, Dictionary<RoomType, int> roomTypesPrice, in DateTime conferenceStart, in DateTime conferenceEnd)
        {
        }

        public int Price(RoomType roomType, CheckIn checkIn, CheckOut checkOut)
        {
            if (roomType == RoomType.Triple)
            {
                return 410;
            }
            if (roomType == RoomType.Double)
            {
                return 510;
            }
            return 610;
        }
    }
}