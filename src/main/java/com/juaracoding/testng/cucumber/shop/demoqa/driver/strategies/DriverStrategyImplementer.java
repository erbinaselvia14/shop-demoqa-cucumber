package com.juaracoding.testng.cucumber.shop.demoqa.driver.strategies;

import com.juaracoding.testng.cucumber.shop.demoqa.utils.Constants;

public class DriverStrategyImplementer {

	public static DriverStrategy chooseStrategy(String strategy) {
		switch (strategy) {
		case Constants.CHROME:
			return new Chrome();
		
		case Constants.FIREFOX:
			return new Firefox();

		default:
			return null;
		}
	}
}
