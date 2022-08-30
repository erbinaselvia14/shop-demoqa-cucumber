package com.juaracoding.testng.cucumber.shop.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.testng.cucumber.shop.demoqa.driver.DriverSingleton;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage() {
		this.driver=DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement txtUsername;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement txtPassword;
	
	@FindBy(xpath="//button[@name='login']")
	private WebElement btnLogin;
	
	@FindBy(xpath="//*[@id=\"post-8\"]/div/div/div/p[1]")
	private WebElement berhasilLogin;
	
	public void login(String txtUsername, String txtPassword) {
		this.txtUsername.sendKeys(txtUsername);
		this.txtPassword.sendKeys(txtPassword);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public String validasiLogin() {
		return berhasilLogin.getText();
	}
}
