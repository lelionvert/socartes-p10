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
        private static readonly DateTime CONFERENCE_START_DAY = new DateTime(2019, 10, 19);

        [SetUp]
        public void setup()
        {
            coldMeal = new ColdMeal();
        }
        
        [Test]
        public void cold_meal_amount_should_be_zero_given_no_checkin()
        {
            List<DateTime> checkins = new List<DateTime>();
            int coldMealNumber = coldMeal.Count(checkins);
            coldMealNumber.Should().Be(0);
        }
        
        [Test]
        public void cold_meal_amount_should_be_one_given_a_late_checkin()
        {
            IList<DateTime> checkIns = new List<DateTime>
            {
                ConferenceStartDayCheckInOf(22)
            };
            int coldMealNumber = coldMeal.Count(checkIns);
            coldMealNumber.Should().Be(1);
        }

        [Test]
        public void cold_meal_amount_should_be_zero_given_an_early_check_in()
        {
            IList<DateTime> checkIns = new List<DateTime>
            {
                ConferenceStartDayCheckInOf(17)
            };
            int coldMealNumber = coldMeal.Count(checkIns);
            coldMealNumber.Should().Be(0);
        }

        [Test]
        public void cold_meal_amount_should_be_zero_given_an_early_check_in_triangulation()
        {
            IList<DateTime> checkins = new List<DateTime>
            {
                ConferenceStartDayCheckInOf(20)
            };
            int coldMealNumber = coldMeal.Count(checkins);
            coldMealNumber.Should().Be(0);
        }

        [Test]
        public void cold_meal_amount_should_be_zero_given_a_check_in_after_conference_start_day()
        {
            var dayFollowingConferenceStartingDay = ConferenceStartDayCheckInOf(1).AddDays(1);
            IList<DateTime> checkins = new List<DateTime>
            {
                dayFollowingConferenceStartingDay
            };
            int coldMealNumber = coldMeal.Count(checkins);
            coldMealNumber.Should().Be(0);
        }

        [Test]
        public void cold_meal_amount_should_be_two_given_one_eligible_check_in()
        {
            IList<DateTime> checkins = new List<DateTime>
            {
                ConferenceStartDayCheckInOf(19),
                ConferenceStartDayCheckInOf(23)
            };
            int coldMealNumber = coldMeal.Count(checkins);
            coldMealNumber.Should().Be(1);
        }

        [Test]
        public void cold_meal_amout_should_be_zero_given_one_check_in_at_exactly_21()
        {
            IList<DateTime> checkins = new List<DateTime>()
            {
                ConferenceStartDayCheckInOf(21)
            };
            int coldMealNumber = coldMeal.Count(checkins);
            coldMealNumber.Should().Be(0);
        }

        private static DateTime ConferenceStartDayCheckInOf(int hour)
        {
            return CONFERENCE_START_DAY.AddHours(hour);
        }
    }
}