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
        public void full_price_of_single_room_choice(int completePrice, RoomType roomType)
        {
            int price = new Registration(0, null, default, default)
                .Price(roomType, default, default);
            price.Should().Be(completePrice);
        }
    }
}