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
		checkErrorMessagesGivenInvalidTimes(-1, Babysitter.LATEST_BEDTIME, Babysitter.LATEST_END_TIME, Babysitter.HOURS_MUST_BE_NON_NEGATIVE);
	}
	
	@Test
	public void testInvalidTimeThatIsGreaterThanTwnetyThreeIsRejected() {
		checkErrorMessagesGivenInvalidTimes(Integer.MAX_VALUE, Babysitter.LATEST_BEDTIME, Babysitter.LATEST_END_TIME, Babysitter.HOURS_MUST_BE_LESS_THAN_TWENTY_FOUR);
	}
	
	private void checkErrorMessagesGivenInvalidTimes(int startTime, int bedtime, int endTime, String expectedExceptionMessage) {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Babysitter(startTime, bedtime, endTime);
		});
		
		assertEquals(expectedExceptionMessage, exception.getMessage());
	}
}
