using System;
using System.Collections.Generic;
using System.Linq;

namespace Catering
{
    public class ColdMeal
    {
        private readonly DateTime conferenceStartDay;
        private readonly int coldMealStartTime;

        public ColdMeal(DateTime conferenceStartDay, int coldMealStartTime)
        {
            this.conferenceStartDay = conferenceStartDay;
            this.coldMealStartTime = coldMealStartTime;
        }

        public int Count(in IList<DateTime> checkIns)
        {
            return checkIns.Count(IsEligibleForColdMeal);
        }

        private bool IsEligibleForColdMeal(DateTime checkIn)
        {
            return checkIn.Date == conferenceStartDay
                   && checkIn.Hour > coldMealStartTime;
        }
    }
}