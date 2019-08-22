using System;
using System.Collections.Generic;
using FluentAssertions;
using NUnit.Framework;
using Socrates;

namespace SocratesTest
{
    public class RegistrationAcceptanceTest
    {
        [TestCase(610, RoomType.Single)]
        [TestCase(510, RoomType.Double)]
        [TestCase(410, RoomType.Triple)]
        [TestCase(240, RoomType.NoAccommodation)]
        public void
            given_a_checkin_on_thursday_and_checkout_on_sunday_lunch_with_a_choice_the_price_should_be_complete_price(
                int completePrice, RoomType roomType)
        {
            CheckIn checkIn = new CheckIn(new DateTime(2019, 10, 19, 8, 0, 0));
            CheckOut checkOut =
                new CheckOut(new DateTime(2019, 10, 23, 15, 0, 0));
            int mealPrice = 40;
            Dictionary<RoomType, int> roomTypesPrice = new Dictionary<RoomType, int>
            {
                {RoomType.Single, 610},
                {RoomType.Double, 510},
                {RoomType.Triple, 410},
                {RoomType.NoAccommodation, 240},
            };
            DateTime conferenceStart = new DateTime(2019, 10, 19);
            DateTime conferenceEnd = new DateTime(2019, 10, 22);

            int totalAmount =
                new Registration(mealPrice, roomTypesPrice, conferenceStart, conferenceEnd)
                    .Price(roomType, checkIn, checkOut);

            totalAmount.Should().Be(completePrice);
        }

        [Test]
        public void
            given_a_checkin_on_thursday_and_early_checkout_on_saturday_dinner_with_a_single_choice_then_the_price_should_be_610_minus_one_meal()
        {
            int mealPrice = 40;
            int singleRoomCompletePrice = 610;
            DateTime conferenceStart = new DateTime(2019,10,19);
            DateTime conferenceEnd = new DateTime(2019,10,22);
            DateTime saturdayDinerTime = new DateTime(2019, 10, 21, 18, 0, 0);
            
            CheckIn checkIn = new CheckIn(conferenceStart);
            CheckOut earlyCheckOut = new CheckOut(saturdayDinerTime.AddHours(1));
            Dictionary<RoomType, int> roomTypesPrice = new Dictionary<RoomType, int>
            {
                {RoomType.Single, 610},
                {RoomType.Double, 510},
                {RoomType.Triple, 410},
                {RoomType.NoAccommodation, 240},
            };
            
            int totalAmount = new Registration(mealPrice, roomTypesPrice, conferenceStart, conferenceEnd)
                .Price(RoomType.Single, checkIn, earlyCheckOut);
            
            totalAmount.Should().Be(singleRoomCompletePrice - mealPrice);
        }


        [Test]
        public void
            given_late_checkin_on_friday_and_checkout_on_sunday_with_a_single_choice_then_the_price_should_be_610_minus_one_meal()
        {
            int mealPrice = 40;
            int singleRoomCompletePrice = 610;
            DateTime conferenceStart = new DateTime(2019, 10, 19);
            DateTime conferenceEnd = new DateTime(2019, 10, 22);
            DateTime friday = conferenceStart.AddDays(1);
            
            CheckIn lateCheckIn = new CheckIn(friday);
            CheckOut checkOut = new CheckOut(conferenceEnd);
            Dictionary<RoomType, int> roomTypesPrice = new Dictionary<RoomType, int>
            {
                {RoomType.Single, 610},
                {RoomType.Double, 510},
                {RoomType.Triple, 410},
                {RoomType.NoAccommodation, 240},
            };
            
            int totalAmount = new Registration(mealPrice, roomTypesPrice, conferenceStart, conferenceEnd)
                .Price(RoomType.Single, lateCheckIn, checkOut);
            
            totalAmount.Should().Be(singleRoomCompletePrice - mealPrice);
        }

        [Test]
        public void
            given_late_checkin_on_friday_and_early_checkout_on_saturday_with_a_single_choice_then_the_price_should_be_610_minus_two_meal()
        {
            int mealPrice = 40;
            int singleRoomCompletePrice = 610;
            DateTime conferenceStart = new DateTime(2019, 10, 19);
            DateTime conferenceEnd = new DateTime(2019,10,22);

            CheckIn friday = new CheckIn(conferenceStart.AddDays(1));
            CheckOut saturday = new CheckOut(new DateTime(2019,10,21,18,0,0));
            Dictionary<RoomType, int> roomTypesPrice  = new Dictionary<RoomType, int>
            {
                {RoomType.Single, 610},
                {RoomType.Double, 510},
                {RoomType.Triple, 410},
                {RoomType.NoAccommodation, 240},
            };
            int totalAmount = new Registration(mealPrice, roomTypesPrice, conferenceStart, conferenceEnd)
                .Price(RoomType.Single, friday, saturday);
            totalAmount.Should().Be(singleRoomCompletePrice - (2 * mealPrice));
        }
    }
}