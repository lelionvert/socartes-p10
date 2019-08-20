using System;
using System.Collections.Generic;
using System.Collections.Specialized;
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
            IList<DateTime> checkIns = new List<DateTime>
            {
                new DateTime(2019,10,19,22,00,00)
            };
            int coldMealNumber = coldMeal.Compute(checkIns);
            coldMealNumber.Should().Be(1);
        }

        [Test]
        public void cold_meal_number_should_be_zero_given_an_early_check_in()
        {
            IList<DateTime> checkIns = new List<DateTime>
            {
                new DateTime(2019, 10, 19, 17,0, 0)
            };
            int coldMealNumber = coldMeal.Compute(checkIns);
            coldMealNumber.Should().Be(0);
        }
    }
}