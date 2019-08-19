import org.junit.Assert;
import org.junit.Test;
import socrates.Participant.Participant;

import static org.junit.Assert.*;

public class ParticipantTest {

    @Test
    public void participant_should_have_checkin_date() {
        assertNotNull(new Participant().getDate());
    }
}
