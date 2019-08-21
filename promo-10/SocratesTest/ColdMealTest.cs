using System;
using System.Collections.Generic;
using FluentAssertions;
using NUnit.Framework;
using Socrates;

namespace SocratesTest
{
    public class ColdMealTests
    {
        private const int COLD_MEAL_START_TIME = 21;
        private ColdMeal coldMeal;
        private static readonly DateTime ConferenceStartDay = new DateTime(2019, 10, 19);

        [SetUp]
        public void setup()
        {
            coldMeal = new ColdMeal(ConferenceStartDay, COLD_MEAL_START_TIME);
        }
        
        [Test]
        public void cold_meal_amount_should_be_zero_given_no_checkin()
        {
            List<DateTime> checkins = new List<DateTime>();
            int coldMealAmount = coldMeal.Count(checkins);
            coldMealAmount.Should().Be(0);
        }
        
        [Test]
        public void cold_meal_amount_should_be_one_given_a_late_checkin()
        {
            IList<DateTime> checkIns = new List<DateTime>
            {
                ConferenceStartDayCheckInOf(22)
            };
            int coldMealAmount = coldMeal.Count(checkIns);
            coldMealAmount.Should().Be(1);
        }

        [Test]
        public void cold_meal_amount_should_be_zero_given_an_early_check_in()
        {
            IList<DateTime> checkIns = new List<DateTime>
            {
                ConferenceStartDayCheckInOf(17)
            };
            int coldMealAmount = coldMeal.Count(checkIns);
            coldMealAmount.Should().Be(0);
        }

        [Test]
        public void cold_meal_amount_should_be_zero_given_an_early_check_in_triangulation()
        {
            IList<DateTime> checkins = new List<DateTime>
            {
                ConferenceStartDayCheckInOf(20)
            };
            int coldMealAmount = coldMeal.Count(checkins);
            coldMealAmount.Should().Be(0);
        }

        [Test]
        public void cold_meal_amount_should_be_zero_given_a_check_in_after_conference_start_day()
        {
            var dayFollowingConferenceStartingDay = ConferenceStartDayCheckInOf(1).AddDays(1);
            IList<DateTime> checkins = new List<DateTime>
            {
                dayFollowingConferenceStartingDay
            };
            int coldMealAmount = coldMeal.Count(checkins);
            coldMealAmount.Should().Be(0);
        }

        [Test]
        public void cold_meal_amount_should_be_two_given_one_eligible_check_in()
        {
            IList<DateTime> checkins = new List<DateTime>
            {
                ConferenceStartDayCheckInOf(19),
                ConferenceStartDayCheckInOf(23)
            };
            int coldMealAmount = coldMeal.Count(checkins);
            coldMealAmount.Should().Be(1);
        }

        [Test]
        public void cold_meal_amount_should_be_zero_given_one_check_in_at_exactly_cold_meal_start_time()
        {
            IList<DateTime> checkIns = new List<DateTime>()
            {
                ConferenceStartDayCheckInOf(COLD_MEAL_START_TIME)
            };
            int coldMealAmount = coldMeal.Count(checkIns);
            coldMealAmount.Should().Be(0);
        }

        private static DateTime ConferenceStartDayCheckInOf(int hour)
        {
            return ConferenceStartDay.AddHours(hour);
        }
    }
}