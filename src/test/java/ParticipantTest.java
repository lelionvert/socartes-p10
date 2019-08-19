import org.junit.Test;
import socrates.Participant.Participant;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ParticipantTest {

    private LocalDateTime aDate(int hour) {
        return LocalDateTime.of(2019, 10, 17, hour, 00);
    }

    @Test
    public void check_participant_arrival_after_nine_should_return_true() {
        Participant participant = new Participant(aDate(22));
        assertTrue(participant.comeAfterNinePM());
    }

    @Test
    public void check_participant_arrival_before_nine_should_return_false() {
        Participant participant = new Participant(aDate(20));
        assertFalse(participant.comeAfterNinePM());
    }

    @Test
    public void check_participant_arrival_after_midnight_should_return_false() {
        LocalDateTime midnight = LocalDateTime.of(2019, 10, 18, 00, 00);
        Participant participant = new Participant(midnight);
        assertFalse(participant.comeAfterNinePM());
    }
}
