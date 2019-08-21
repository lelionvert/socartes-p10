using System;
using FluentAssertions;
using NUnit.Framework;
using Socrates;

namespace SocratesTest
{
    public class RegistrationTest
    {
        [TestCase(610, RoomType.Single)]
        [TestCase(510, RoomType.Double)]
        [TestCase(410, RoomType.Triple)]
        [TestCase(240, RoomType.NoAccommodation)]
        public void given_a_checkin_on_thursday_and_checkout_on_sunday_lunch_with_a_choice_the_price_should_be_complete_price(
                int completePrice, RoomType roomType)
        {
            int totalAmount = new Registration().Price(roomType);
            totalAmount.Should().Be(completePrice);
        }
    }
}