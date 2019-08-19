using System;
using System.Collections.Generic;
using ColdMeals;
using FluentAssertions;
using NUnit.Framework;

namespace Tests
{
    public class Tests
    {
        private ColdMeal coldMeal;

        [SetUp]
        public void setup()
        {
            coldMeal = new ColdMeal();
        }
        
        [Test]
        public void cold_meal_number_should_be_zero_given_no_checkin()
        {
            List<DateTime> checkins = new List<DateTime>();
            int coldMealNumber = coldMeal.Compute(checkins);
            coldMealNumber.Should().Be(0);
        }
        
        [Test]
        public void cold_meal_number_should_be_one_given_a_late_checkin()
        {
            List<DateTime> checkIns = new List<DateTime>
            {
                new DateTime(2019,10,19,22,00,00)
            };
            int coldMealNumber = coldMeal.Compute(checkIns);
            coldMealNumber.Should().Be(1);
        }
    }
}