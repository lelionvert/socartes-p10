using System;

namespace Socrates
{
    public class Registration
    {
        private const int ROOM_PRICE_DOUBLE = 510;
        private const int ROOM_PRICE_SINGLE = 610;

        public int Price(RoomType roomType)
        {
            if (RoomType.Double == roomType)
            {
                return ROOM_PRICE_DOUBLE;
            }

            return ROOM_PRICE_SINGLE;
        }
    }
}