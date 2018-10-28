package com.jamesha.babysitterKata;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BabysitterTest {

	@Test
	public void testValidStartTimeBedtimeAndEndTimeAreAccepted() {
		new Babysitter(Babysitter.START_TIME_EARLIEST, Babysitter.BEDTIME_LATEST, Babysitter.END_TIME_LATEST);
	}
	
	@Test
	public void testInvalidTimeLessThanOneIsRejected() {
		verifyExceptionMessageGivenIllegalArguments(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Babysitter.INVALID_TIME_RANGES_MESSAGE);
	}
	
	@Test
	public void testInvalidTimeGreaterThanTwnetyFourIsRejected() {
		verifyExceptionMessageGivenIllegalArguments(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Babysitter.INVALID_TIME_RANGES_MESSAGE);
	}
	
	@Test
	public void testInvalidStartTimeBeforeEarliestStartTimeIsRejected() {
		verifyExceptionMessageGivenIllegalArguments(oneHourBefore(Babysitter.START_TIME_EARLIEST), Babysitter.BEDTIME_LATEST, Babysitter.END_TIME_LATEST, Babysitter.INVALID_EARLY_START_TIME_MESSAGE);
	}
	
	@Test
	public void testInvalidStartTimeAfterLatestStartTimeIsRejected() {
		verifyExceptionMessageGivenIllegalArguments(oneHourAfter(Babysitter.START_TIME_LATEST), Babysitter.BEDTIME_LATEST, Babysitter.END_TIME_LATEST, Babysitter.INVALID_LATE_START_TIME_MESSAGE);
	}
	
	@Test
	public void testInvalidBedtimeBeforeEarliestBedtimeIsRejected() {
		verifyExceptionMessageGivenIllegalArguments(Babysitter.START_TIME_EARLIEST, oneHourBefore(Babysitter.BEDTIME_EARLIEST), Babysitter.END_TIME_LATEST, Babysitter.INVALID_EARLY_BEDTIME_MESSAGE);
	}
	
	@Test
	public void testInvalidBedtimeAfterLatestBedtimeIsRejected() {
		verifyExceptionMessageGivenIllegalArguments(Babysitter.START_TIME_EARLIEST, oneHourAfter(Babysitter.BEDTIME_LATEST), Babysitter.END_TIME_LATEST, Babysitter.INVALID_LATE_BEDTIME_MESSAGE);
	}
	
	@Test
	public void testInvalidEndTimeBeforeEarliestEndTimeIsRejected() {
		verifyExceptionMessageGivenIllegalArguments(Babysitter.START_TIME_EARLIEST, Babysitter.BEDTIME_LATEST, oneHourBefore(Babysitter.END_TIME_EARLIEST), Babysitter.INVALID_END_TIME_MESSAGE);
	}
	
	@Test
	public void testInvalidEndTimeAfterLatestEndTimeIsRejected() {
		verifyExceptionMessageGivenIllegalArguments(Babysitter.START_TIME_EARLIEST, Babysitter.BEDTIME_LATEST, oneHourAfter(Babysitter.END_TIME_LATEST), Babysitter.INVALID_END_TIME_MESSAGE);
	}
	
	@Test
	public void testInvalidBedimeBeforeStartTimeIsRejected() {
		verifyExceptionMessageGivenIllegalArguments(18, 17, Babysitter.END_TIME_LATEST, Babysitter.INVALID_BEDTIME_BEFORE_START_TIME_MESSAGE);
	}
	
	@Test
	public void testInvalidEndTimeBeforeStartTimeIsRejected() {
		verifyExceptionMessageGivenIllegalArguments(18, Babysitter.BEDTIME_LATEST, 17, Babysitter.INVALID_END_TIME_BEFORE_START_TIME_MESSAGE);
	}
	
	@Test
	public void testInvalidBedtimeAfterEndTimeIsRejected() {
		verifyExceptionMessageGivenIllegalArguments(Babysitter.START_TIME_EARLIEST, oneHourAfter(Babysitter.END_TIME_EARLIEST), Babysitter.END_TIME_EARLIEST, Babysitter.INVALID_BEDTIME_AFTER_END_TIME_MESSAGE);
	}
	
	private void verifyExceptionMessageGivenIllegalArguments(int startTime, int bedtime, int endTime, String expectedExceptionMessage) {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Babysitter(startTime, bedtime, endTime);
		});
		
		assertEquals(expectedExceptionMessage, exception.getMessage());
	}
	
	private int oneHourBefore(int time) {
		if (time == 1) { 
			return 24;
		}
		return time - 1;
	}
	
	private int oneHourAfter(int time) {
		if (time == 24) {
			return 1;
		}
		return time + 1;
	}
}
