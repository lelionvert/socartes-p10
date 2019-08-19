using System;
using ColdMeals;
using FluentAssertions;
using NUnit.Framework;

namespace Tests
{
    public class Tests
    {
        [Test]
        public void will_participant_eat_a_cold_meal()
        {
            DateTime participantArrivalTime = new DateTime(2019, 10, 17, 21, 30, 0);
            bool isAttending = Participant.WillEatAColdMeal(participantArrivalTime);
            isAttending.Should().BeTrue();
        }
    }
}