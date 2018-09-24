package main;

public class Babysitter {

	public static final int EARLIEST_START_TIME = 17;
	public static final int LATEST_BEDTIME = 23;
	public static final int LATEST_END_TIME = 4;
	
	public static final String INVALID_TIME_RANGES = "Valid time inputs must be from 1 to 24.";
	
	public Babysitter(int startTime, int bedtime, int endTime) {
		validateTimes(startTime, bedtime, endTime);
	}

	private void validateTimes(int startTime, int bedtime, int endTime) {
		validateTimesAreFromOneToTwentyFour(startTime, bedtime, endTime);
	}

	private void validateTimesAreFromOneToTwentyFour(int startTime, int bedtime, int endTime) {
		if (startTime < 1 || bedtime < 1 || endTime < 1 || startTime > 24 || bedtime > 24 || endTime > 24) {
			throw new IllegalArgumentException(INVALID_TIME_RANGES);
		}
	}
}
