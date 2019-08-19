import org.junit.Assert;
import org.junit.Test;
import socrates.Participant.Participant;

import java.util.Date;

import static org.junit.Assert.*;

public class ParticipantTest {

    @Test
    public void participant_should_have_checkin_date() {
        assertNotNull(new Participant().getDate());
    }

    @Test
    public void check_participant_arrival_after_nine_should_return_true() {
        Participant participant = new Participant();
        participant.setDate(new Date(2019, 10, 10, 22, 00));
        assertTrue(participant.comeAfterNinePM());
    }
}
