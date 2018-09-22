package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import main.Babysitter;

public class TestBabysitter {

	@Test
	public void testValidStartTimeBedtimeAndEndTimeAreAccepted() {
		new Babysitter(Babysitter.EARLIEST_START_TIME, Babysitter.LATEST_BEDTIME, Babysitter.LATEST_END_TIME);
	}
	
	@Test
	public void testInvalidTimeThatIsLessThanZeroIsRejected() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Babysitter(-1, Babysitter.LATEST_BEDTIME, Babysitter.LATEST_END_TIME);
		});
		
		assertEquals("Hours must be non-negative.", exception.getMessage());
	}
	
	@Test
	public void testInvalidTimeThatIsGreaterThanTwnetyThreeIsRejected() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Babysitter(Integer.MAX_VALUE, Babysitter.LATEST_BEDTIME, Babysitter.LATEST_END_TIME);
		});
		
		assertEquals("Hours must be less than 24.", exception.getMessage());
	}
}
