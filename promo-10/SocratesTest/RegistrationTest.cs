using FluentAssertions;
using NUnit.Framework;
using Socrates;

namespace SocratesTest
{
    public class RegistrationTest
    {
        [Test]
        public void full_price_of_single_room_choice()
        {
            int completePrice = 610;
            int price = new Registration(0, null, default, default)
                .Price(RoomType.Single, default, default);
            price.Should().Be(completePrice);
        }

        [Test]
        public void full_price_of_double_room_choice()
        {
            int completePrice = 510;
            int price = new Registration(0, null, default, default)
                .Price(RoomType.Double, default,default);
            price.Should().Be(completePrice);
        }
    }
}