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
	
	@Test
	public void testBedtimeAndEndTimeOneHourAfterStartTimeBeforeMidnight() {
		assertEquals(new BigDecimal(Babysitter.WAGE_START_TO_BEDTIME), NightlyWageCalculator.calculateNightlyWage(new Babysitter(17, 18, 18)));
	}
	
	@Test
	public void testBedtimeOneHourAfterStartTimeAndEndTimeOneHourAfterBedtimeBeforeMidnight() {
		assertEquals(new BigDecimal(Babysitter.WAGE_START_TO_BEDTIME + Babysitter.WAGE_BEDTIME_TO_MIDNIGHT), NightlyWageCalculator.calculateNightlyWage(new Babysitter(17, 18, 19)));
	}
	
	@Test
	public void testEndTimeAfterMidnight() {
		assertEquals(new BigDecimal(Babysitter.WAGE_START_TO_BEDTIME + Babysitter.WAGE_BEDTIME_TO_MIDNIGHT + 2 * Babysitter.WAGE_MIDNIGHT_TO_END), NightlyWageCalculator.calculateNightlyWage(new Babysitter(22, 23, 2)));
	}
}
