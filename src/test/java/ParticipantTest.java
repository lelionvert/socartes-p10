import org.junit.Assert;
import org.junit.Test;
import socrates.Participant.Participant;

import java.util.Date;

import static org.junit.Assert.*;

public class ParticipantTest {

    @Test
    public void check_participant_arrival_after_nine_should_return_true() {
        Participant participant = new Participant(new Date(2019, 10, 17, 22, 00));
        assertTrue(participant.comeAfterNinePM());
    }

    @Test
    public void check_participant_arrival_before_nine_should_return_false() {
        Participant participant = new Participant(new Date(2019, 10, 17, 20, 00));
        assertFalse(participant.comeAfterNinePM());
    }
}
