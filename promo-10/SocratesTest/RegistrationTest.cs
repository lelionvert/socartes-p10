using System;
using FluentAssertions;
using NUnit.Framework;
using Socrates;

namespace SocratesTest
{
    public class RegistrationTest
    {
        [TestCase(610)]
        public void given_a_checkin_on_thursday_and_checkout_on_sunday_lunch_with_a_choice_the_price_should_be_complete_price(
                int completePrice)
        {
            int totalAmount = Registration.Price();
            totalAmount.Should().Be(completePrice);
        }
    }
}