using System;
using System.Collections.Generic;
using System.Linq;

namespace ColdMeals
{
    public class ColdMeal
    {
        private readonly DateTime conferenceStartDay = new DateTime(2019, 10, 19);
        private const int COLD_MEAL_START_TIME = 21;

        public int Count(in IList<DateTime> checkins)
        {
            return checkins.Count(currentCheckIn => IsColdMeal(currentCheckIn));
        }

        private bool IsColdMeal(DateTime checkin)
        {
            return checkin.Date == conferenceStartDay && checkin.Hour >= COLD_MEAL_START_TIME;
        }
    }
}