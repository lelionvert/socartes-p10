using System;
using System.Collections.Generic;
using System.Linq;

namespace ColdMeals
{
    public class ColdMeal
    {
        public int Compute(in IList<DateTime> checkins)
        {
            DateTime checkin = checkins.FirstOrDefault();
            if (checkin.Hour == 17)
                return 0;
            return checkins.Count;
        }
    }
}