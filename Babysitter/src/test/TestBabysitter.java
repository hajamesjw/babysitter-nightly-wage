package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Babysitter;

public class TestBabysitter {

	@Test
	public void testValidStartTimeBedtimeAndEndTimeAreAccepted() {
		new Babysitter(Babysitter.EARLIEST_START_TIME, Babysitter.LATEST_BEDTIME, Babysitter.LATEST_END_TIME);
	}
	
	@Test
	public void testInvalidTimeThatIsLessThanZeroIsRejected() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Babysitter(-1, Babysitter.LATEST_BEDTIME, Babysitter.LATEST_END_TIME);
		});
	}
	
	@Test
	public void testInvalidTimeThatIsGreaterThanTwnetyThreeIsRejected() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Babysitter(Integer.MAX_VALUE, Babysitter.LATEST_BEDTIME, Babysitter.LATEST_END_TIME);
		});
	}
}
