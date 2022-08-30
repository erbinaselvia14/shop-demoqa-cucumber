package com.juaracoding.testng.cucumber.shop.demoqa.cucumber;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.juaracoding.testng.cucumber.shop.demoqa.driver.DriverSingleton;
import com.juaracoding.testng.cucumber.shop.demoqa.pages.LoginPage;
import com.juaracoding.testng.cucumber.shop.demoqa.utils.Constants;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestLogin {

	public static WebDriver driver;
	private LoginPage loginPage;
	
	@Before
	public void setUp() {
		DriverSingleton.getInstance(Constants.CHROME);
		loginPage = new LoginPage();
	}

	@Given("user go to login page")
	public void user_go_to_login_page() {
		driver=DriverSingleton.getDriver();
		driver.get(Constants.LOGINURL);
	}
	
	@When("user enter username and password")
	public void user_enter_username_and_password() {
		scroll(500);
		loginPage.login("selvia14", "Erbina@14");
	}
	
	@And("user click button login")
	public void user_click_button_login() {
		loginPage.clickLogin();
	}
	
	@Then("go to page valid login")
	public void go_to_page_valid_login() {
		scroll(400);
		System.out.println(loginPage.validasiLogin());
	}
	
	@After
	public void closeBrowser() {
		delay(1);
		DriverSingleton.closeObjectInstance();
	}
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static void scroll(int vertical) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+vertical+")");
	}
	
}
