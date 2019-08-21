using System;
using System.Collections.Generic;
using FluentAssertions;
using NUnit.Framework;
using Socrates;

namespace SocratesTest
{
    public class RegistrationTest
    {
        [TestCase( 610, RoomType.Single, 2019, 10, 19, 8, 2019, 10, 23, 15)]
        [TestCase(510, RoomType.Double, 2019, 10, 19, 8, 2019, 10, 23, 15)]
        [TestCase(410, RoomType.Triple, 2019, 10, 19, 8, 2019, 10, 23,15)]
        [TestCase(240, RoomType.NoAccommodation, 2019, 10, 19, 8, 2019, 10, 23, 15)]
        public void given_a_checkin_on_thursday_and_checkout_on_sunday_lunch_with_a_choice_the_price_should_be_complete_price(
                int completePrice, RoomType roomType,
                int checkInYear, int checkInMonth, int checkInDay, int checkInHour,
                int checkOutYear, int checkOutMonth, int checkOutDay, int checkOutHour)
        {
            CheckIn checkIn = new CheckIn(new DateTime(checkInYear, checkInMonth, checkInDay, checkInHour, 0, 0));
            CheckOut checkOut = new CheckOut(new DateTime(checkOutYear, checkOutMonth, checkOutDay, checkOutHour, 0 ,0));
            int mealPrice = 40;
            Dictionary<RoomType, int> roomTypesPrice = new Dictionary<RoomType, int>
            {
                { RoomType.Single, 610 },
                { RoomType.Double, 510 },
                { RoomType.Triple, 410 },
                { RoomType.NoAccommodation, 240 },
            };
            DateTime conferenceStart = new DateTime(2019,10,19);
            DateTime conferenceEnd = new DateTime(2019,10,23);
            int totalAmount = new Registration(mealPrice, roomTypesPrice, conferenceStart, conferenceEnd).Price(roomType, checkIn, checkOut);
            totalAmount.Should().Be(completePrice);
        }
    }
}