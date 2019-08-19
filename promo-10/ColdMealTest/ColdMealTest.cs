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
        
        [Test]
        public void cold_meal_number_should_be_one_when_late_checkin()
        {
            DateTime conferenceDate = new DateTime();
            List<DateTime> checkIns = new List<DateTime>
            {
                new DateTime(2019,10,19,22,00,00)
            };
            int coldMealNumber = ColdMeal.Compute(conferenceDate, checkIns);
            coldMealNumber.Should().Be(1);
        }
    }
}