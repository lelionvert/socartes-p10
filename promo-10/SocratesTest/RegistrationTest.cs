using System;
using FluentAssertions;
using NUnit.Framework;
using Socrates;

namespace SocratesTest
{
    public class RegistrationTest
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void given_a_checkin_on_thursday_and_checkout_on_saturday_dinner_with_single_choice_the_price_should_be_610()
        {
            int totalAmount = Registration.Price();
            totalAmount.Should().Be(610);
        }
    }
}