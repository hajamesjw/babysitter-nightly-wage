package main;

import java.math.BigDecimal;

public class NightlyWageCalculator {

	public static BigDecimal calculateNightlyWage(Babysitter babysitter) {
		return totalStartTimeToBedtimeAmount(babysitter).add(totalBedtimeToMidnightAmount(babysitter).add(totalMidnightToEndTimeAmount(babysitter)));
	}

	private static BigDecimal totalStartTimeToBedtimeAmount(Babysitter babysitter) {
		return new BigDecimal(Babysitter.WAGE_START_TO_BEDTIME * (babysitter.getBedtime() - babysitter.getStartTime()));
	}
	
	private static BigDecimal totalBedtimeToMidnightAmount(Babysitter babysitter) {
		if(endTimeIsAfterMidnight(babysitter)) {
			return new BigDecimal(Babysitter.WAGE_BEDTIME_TO_MIDNIGHT * (24 - babysitter.getBedtime()));
		}
		return new BigDecimal(Babysitter.WAGE_BEDTIME_TO_MIDNIGHT * (babysitter.getEndTime() - babysitter.getBedtime()));
	}
	
	private static BigDecimal totalMidnightToEndTimeAmount(Babysitter babysitter) {
		if(endTimeIsAfterMidnight(babysitter)) {
			return new BigDecimal(Babysitter.WAGE_MIDNIGHT_TO_END * babysitter.getEndTime());
		}
		return BigDecimal.ZERO;
	}

	//The scope of this application is calculating wage for one night of babysitting.
	//If end time is less than the earliest start time, 
	//that time will be have to be in the next day after midnight.
	private static boolean endTimeIsAfterMidnight(Babysitter babysitter) {
		return babysitter.getEndTime() < Babysitter.START_TIME_EARLIEST;
	}
}
