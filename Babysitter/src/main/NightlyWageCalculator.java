package main;

import java.math.BigDecimal;

public class NightlyWageCalculator {

	public static BigDecimal calculateNightlyWage(Babysitter babysitter) {
		return new BigDecimal(12).multiply(new BigDecimal(babysitter.getEndTime() - babysitter.getStartTime()));
	}
}
