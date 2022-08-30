package com.juaracoding.testng.cucumber.shop.demoqa.cucumber;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.juaracoding.testng.cucumber.shop.demoqa.driver.DriverSingleton;
import com.juaracoding.testng.cucumber.shop.demoqa.pages.LoginPage;
import com.juaracoding.testng.cucumber.shop.demoqa.pages.PlaceOrderPage;
import com.juaracoding.testng.cucumber.shop.demoqa.pages.SearchPage;
import com.juaracoding.testng.cucumber.shop.demoqa.utils.Constants;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestCheckout {

	public static WebDriver driver;
	private LoginPage loginPage;
	private SearchPage searchPage;
	private PlaceOrderPage placeOrderPage;
	
	@Before
	public void setUp() {
		DriverSingleton.getInstance(Constants.CHROME);
		loginPage = new LoginPage();
		searchPage = new SearchPage();
		placeOrderPage = new PlaceOrderPage();
	}
	
	@Given("user go to login page web")
	public void user_go_to_login_page_web() {
		driver=DriverSingleton.getDriver();
		driver.get(Constants.LOGINURL);
	}
	
	@When("search dress item")
	public void search_dress_item() {
		scroll(500);
		loginPage.login("selvia14", "Erbina@14");
		loginPage.clickLogin();
		scroll(400);
		System.out.println(loginPage.validasiLogin());
		searchPage.btnDashboard();
		searchPage.btnSearch();
		System.out.println(searchPage.getTittleSearch());
		searchPage.searchItemSatu("dress");
		scroll(400);
		System.out.println(searchPage.getTxtResult());
	}
	
	@And("add dress item")
	public void add_dress_item() {
		placeOrderPage.clickBtnImg();
		scroll(800);
		placeOrderPage.pilihColor("White");
		placeOrderPage.pilihSize("Medium");
		placeOrderPage.clickBtnAddToCart();
	}
	
	@When("search shirt item")
	public void search_shirt_item() {
		searchPage.btnSearch();
		System.out.println(searchPage.getTittleSearch());
		searchPage.searchItemSatu("shirt");
		scroll(400);
		System.out.println(searchPage.getTxtResult());
	}
	
	@And("add shirt item")
	public void add_shirt_item() {
		placeOrderPage.clickBtnImgDua();
		scroll(800);
		placeOrderPage.pilihColor("Pink");
		placeOrderPage.pilihSize("36");
		placeOrderPage.clickBtnAddToCart();
	}
	
	@When("user filling billing")
	public void user_filling_billing() {
		placeOrderPage.clickBtnCart();
		scroll(900);
		placeOrderPage.clickBtnCheckout();
		scroll(400);
		placeOrderPage.formOrder();
		placeOrderPage.clickTerm();
	}
	
	@And("user place order")
	public void user_place_order() {
		placeOrderPage.placeOrder();
	}
	
	@Then("validate valid scenario")
	public void validate_valid_scenario() {
		placeOrderPage.getTxtSuksesOrder();
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
