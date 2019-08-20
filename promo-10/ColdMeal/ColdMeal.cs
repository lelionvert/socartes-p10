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
            DateTime checkin = checkins.FirstOrDefault();
            if (IsColdMeal(checkin))
                return checkins.Count;
            return 0;
        }

        private bool IsColdMeal(DateTime checkin)
        {
            return checkin.Date == conferenceStartDay && checkin.Hour >= COLD_MEAL_START_TIME;
        }
    }
}