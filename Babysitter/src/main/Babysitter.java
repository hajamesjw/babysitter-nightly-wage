package main;

public class Babysitter {

	public static final int START_TIME_EARLIEST = 17;
	public static final int START_TIME_LATEST = 23;
	public static final int BEDTIME_EARLIEST = 17;
	public static final int BEDTIME_LATEST = 23;
	public static final int END_TIME_EARLIEST = START_TIME_EARLIEST;
	public static final int END_TIME_LATEST = 4;
	
	public static final String INVALID_TIME_RANGES_MESSAGE = "Valid time inputs must be from 1 to 24.";
	public static final String INVALID_EARLY_START_TIME_MESSAGE = "Start time cannot be before " + START_TIME_EARLIEST + ".";
	public static final String INVALID_LATE_START_TIME_MESSAGE = "Start time cannot be after " + START_TIME_LATEST + ".";
	public static final String INVALID_EARLY_BEDTIME_MESSAGE = "Bedtime cannot be before " + BEDTIME_EARLIEST + ".";
	public static final String INVALID_LATE_BEDTIME_MESSAGE = "Bedtime cannot be after " + BEDTIME_LATEST + ".";
	public static final String INVALID_END_TIME_MESSAGE = "End time must be between " + END_TIME_EARLIEST + " and " + END_TIME_LATEST + ".";
	
	public Babysitter(int startTime, int bedtime, int endTime) {
		validateTimes(startTime, bedtime, endTime);
	}
	
	private void validateTimes(int startTime, int bedtime, int endTime) {
		validateTimesAreFromOneToTwentyFour(startTime, bedtime, endTime);
		validateTimesAgainstEarliestAndLatestAllowedTimes(startTime, bedtime, endTime);
	}

	private void validateTimesAreFromOneToTwentyFour(int startTime, int bedtime, int endTime) {
		if (startTime < 1 || bedtime < 1 || endTime < 1 || startTime > 24 || bedtime > 24 || endTime > 24) {
			throw new IllegalArgumentException(INVALID_TIME_RANGES_MESSAGE);
		}
	}
	
	private void validateTimesAgainstEarliestAndLatestAllowedTimes(int startTime, int bedtime, int endTime) {
		if (startTime < START_TIME_EARLIEST) {
			throw new IllegalArgumentException(INVALID_EARLY_START_TIME_MESSAGE);
		} 
		if (startTime > START_TIME_LATEST) {
			throw new IllegalArgumentException(INVALID_LATE_START_TIME_MESSAGE);
		}
		if (bedtime < BEDTIME_EARLIEST) {
			throw new IllegalArgumentException(INVALID_EARLY_BEDTIME_MESSAGE);
		}
		if (bedtime > BEDTIME_LATEST) {
			throw new IllegalArgumentException(INVALID_LATE_BEDTIME_MESSAGE);
		}
		if (endTime < END_TIME_EARLIEST && endTime > END_TIME_LATEST) {
			throw new IllegalArgumentException(INVALID_END_TIME_MESSAGE);
		}
	}
}
