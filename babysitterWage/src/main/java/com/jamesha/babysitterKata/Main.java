package com.jamesha.babysitterKata;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Total pay: " + NightlyWageCalculator.calculateNightlyWage(new Babysitter(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]))));
	}
}
