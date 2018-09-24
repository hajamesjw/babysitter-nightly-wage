package test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import main.Babysitter;
import main.NightlyWageCalculator;

public class TestNightlyWageCalculator {
	
	@Test
	public void testSameStartTimeAndEndTimeCalculatesZeroWage() {
		assertEquals(BigDecimal.ZERO, NightlyWageCalculator.calculateNightlyWage(new Babysitter(Babysitter.START_TIME_EARLIEST, Babysitter.START_TIME_EARLIEST, Babysitter.START_TIME_EARLIEST)));
	}
}
