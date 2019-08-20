using System;
using System.Collections.Generic;
using System.Linq;

namespace ColdMeals
{
    public class ColdMeal
    {
        private const int COLD_MEAL_START_TIME = 21;

        public int Count(in IList<DateTime> checkins)
        {
            DateTime checkin = checkins.FirstOrDefault();
            if (checkin.Hour < COLD_MEAL_START_TIME)
                return 0;
            return checkins.Count;
        }
    }
}