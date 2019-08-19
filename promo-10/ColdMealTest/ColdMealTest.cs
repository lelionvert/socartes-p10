using System;
using System.Collections.Generic;
using ColdMeal;
using FluentAssertions;
using NUnit.Framework;

namespace Tests
{
    public class Tests
    {
        [Test]
        public void number_of_cold_meals_given_no_participant()
        {
            int noColdMeal = 0;

            DateTime conferenceDate = new DateTime(2019, 10, 19);
            List<DateTime> checkins = new List<DateTime>();
            noColdMeal.Should().Be(Class1.Compute(conferenceDate, checkins));
        }
    }
}