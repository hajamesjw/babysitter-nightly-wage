package test;

import org.junit.jupiter.api.Test;

import main.Babysitter;

public class TestBabysitter {

	@Test
	public void testValidStartTimeIsAccepted() {
		new Babysitter(17);
	}	
}
