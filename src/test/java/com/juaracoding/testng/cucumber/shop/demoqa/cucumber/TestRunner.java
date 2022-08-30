package com.juaracoding.testng.cucumber.shop.demoqa.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
				features = {"src/test/resources/features/Login.feature",
						"src/test/resources/features/Checkout.feature"},
				glue = "",
				plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
