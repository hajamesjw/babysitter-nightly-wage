package main;

public class Babysitter {

	public static final int EARLIEST_START_TIME = 17;
	public static final int LATEST_BEDTIME = 23;
	public static final int LATEST_END_TIME = 4;

	public Babysitter(int startTime, int bedtime, int endTime) {
		//One day consists of hours 0 through 23
		validateTimesAreNotNegative(startTime, bedtime, endTime);
		validateTimesAreNotOverTwentyThree(startTime, bedtime, endTime);
	}

	private void validateTimesAreNotOverTwentyThree(int startTime, int bedtime, int endTime) {
		if (startTime > 23 || bedtime > 23 || endTime > 23) {
			throw new IllegalArgumentException();
		}
	}

	private void validateTimesAreNotNegative(int startTime, int bedtime, int endTime) {
		if (startTime < 0 || bedtime < 0 || endTime < 0) {
			throw new IllegalArgumentException();
		}
	}
}
