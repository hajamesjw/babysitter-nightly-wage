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
	public void testInvalidTimeLessThanOneIsRejected() {
		checkErrorMessagesGivenInvalidTimes(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Babysitter.INVALID_TIME_RANGES);
	}
	
	@Test
	public void testInvalidTimeGreaterThanTwnetyFourIsRejected() {
		checkErrorMessagesGivenInvalidTimes(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Babysitter.INVALID_TIME_RANGES);
	}
	
	private void checkErrorMessagesGivenInvalidTimes(int startTime, int bedtime, int endTime, String expectedExceptionMessage) {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Babysitter(startTime, bedtime, endTime);
		});
		
		assertEquals(expectedExceptionMessage, exception.getMessage());
	}
}
