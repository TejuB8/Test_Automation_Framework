package com.ui.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;

public class LoginTest2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver","C:\\Drivers\\edgedriver_win64 (2)\\msedgedriver.exe");
		WebDriver wd= new EdgeDriver();
		HomePage homePage=new HomePage(wd);
		homePage.maximizeWindow();
		LoginPage loginPage=homePage.goToLoginPage();
		loginPage.doLoginWith("fajaw53481@kwifa.com", "password");
		
		
		}

}
