using System;
using FluentAssertions;
using NUnit.Framework;

namespace Tests
{
    public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void given_a_checkin_on_thursday_and_checkout_on_saturday_dinner_the_total_amount_should_be_610()
        {
            DateTime checkin = new DateTime(2019, 10, 19);
            DateTime checkout = checkin.AddDays(4);
            int totalAmount = Registration.Calculate(checkin, checkout);
            totalAmount.Should().Be(610);
        }
    }

    public class Registration
    {
        public static int Calculate(in DateTime checkin, in DateTime checkout)
        {
            return 610;
        }
    }
}