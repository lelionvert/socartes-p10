using System;
using System.Collections.Generic;

namespace ColdMeals
{
    public class ColdMeal
    {
        public int Compute(in List<DateTime> checkins)
        {
            return checkins.Count;
        }
    }
}