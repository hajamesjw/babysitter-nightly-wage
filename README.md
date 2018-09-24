# babysitter-nightly-wage
This application calculates total wage for a babysitter working and getting paid for one night.

**Initial requirements**:
* starts no earlier than 5:00PM
* leaves no later than 4:00AM
* gets paid $12/hour from start-time to bedtime
* gets paid $8/hour from bedtime to midnight
* gets paid $16/hour from midnight to end of job
* gets paid for full hours (no fractional hours)

**Further requirements provided by the product owner upon request**:
* bedtime no earlier than 5:00PM
* bedtime no later than 11:00PM
* starts no later than 11:00PM
* if bedtime is on start-time, bedtime rate is used over the start-time rate
* hour is the smallest unit of time tracked

**Running tests and building the project**:

This is a Maven project. To test and build the project, navigate to ~/babysitterWage/ in Terminal and run the following commands.

To run the tests: _mvn test_

To build the project: _mvn clean package_
