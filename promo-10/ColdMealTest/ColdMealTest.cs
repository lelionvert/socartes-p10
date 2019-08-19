using System;
using System.Collections.Generic;
using ColdMeals;
using FluentAssertions;
using NUnit.Framework;

namespace Tests
{
    public class Tests
    {
        [Test]
        public void cold_meal_number_should_be_zero_when_no_checkin()
        {
            DateTime conferenceDate = new DateTime(2019, 10, 19);
            List<DateTime> checkins = new List<DateTime>();
            int coldMealNumber = ColdMeal.Compute(conferenceDate, checkins);
            coldMealNumber.Should().Be(0);
        }
    }
}