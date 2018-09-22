package test;

import org.junit.jupiter.api.Test;

import main.Babysitter;

public class TestBabysitter {

	@Test
	public void testValidStartTimeBedtimeAndEndTimeAreAccepted() {
		new Babysitter(Babysitter.EARLIEST_START_TIME, Babysitter.LATEST_BEDTIME, Babysitter.LATEST_END_TIME);
	}
}
