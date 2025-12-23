package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); // initialise instance variable!! and diff between local and instance variable
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browserName) {// creating another constructor to pass brosername

		logger.info("Launching browser for" + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {

			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName.equalsIgnoreCase("edge")) {
			// System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64
			// (2)\\msedgedriver.exe");
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {
			logger.error("Invalid browser name....Please select chrome or edge only");

			System.err.print("Please enter correct broswerName");
		}
	}

	public BrowserUtility(Browser browserName) {// creating another constructor to pass brosername
		logger.info("Launching browser for" + browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName == Browser.EDGE) {
			// System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64
			// (2)\\msedgedriver.exe");
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {// creating another constructor to pass brosername
		logger.info("Launching browser for" + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				// System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64
				// (2)\\msedgedriver.exe");
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				// System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64
				// (2)\\msedgedriver.exe");
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		}
	}

	public void quit() {
		if(driver.get()!=null) {
			driver.get().quit();
		}
	}

	public void goToWebsite(String url) {
		logger.info("visiting the website" + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser window");

		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding Element with the locator " + locator);

		//WebElement webElement = driver.get().findElement(locator);
		WebElement webElement= wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("element found now performing click");

		webElement.click();
	}
	
	public void clickOnCheckBox(By locator) {
		logger.info("Finding Element with the locator " + locator);

		//WebElement webElement = driver.get().findElement(locator);
		WebElement webElement= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("element found now performing click");

		webElement.click();
	}

	public void clickOn(WebElement element) {

		logger.info("element found now performing click");

		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element with the locator " + locator);
		//WebElement webElement = driver.get().findElement(locator);
		WebElement webElement= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element found now enter text " + textToEnter);
		webElement.sendKeys(textToEnter);
	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("Finding Element with the locator " + locator);
		//WebElement webElement = driver.get().findElement(locator);
		WebElement webElement= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found now enter special key " + keyToEnter);
		webElement.sendKeys(keyToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding Element with the locator " + locator);
		WebElement webElement = driver.get().findElement(locator);

		logger.info("Element found now returning a value " + webElement.getText());
		return webElement.getText();

	}

	public String getVisibleText(WebElement element) {
		logger.info("Returning tehe visible text " + element.getText());

		return element.getText();
	}

	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding Elements with the locator " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);

		logger.info("Elements found now printing the list of elements ");
		List<String> visibleTextList = new ArrayList<>();
		for (WebElement element : elementList) {
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;

	}

	public List<WebElement> getAllElements(By locator) {
		logger.info("Finding Elements with the locator " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);

		logger.info("Elements found now printing the list of elements ");

		return elementList;

	}

	public void clearText(By textBoxLocator) {
		logger.info("Finding Element with the locator " + textBoxLocator);
		//WebElement webElement = driver.get().findElement(textBoxLocator);
		WebElement webElement= wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));
		logger.info("Element found now clearing the text box field");
		webElement.clear();

	}

	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding Elements with the locator " + dropDownLocator);
		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		logger.info("Selecting the option " + optionToSelect);
		select.selectByVisibleText(optionToSelect);
	}

	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/" + name + "-" + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}
}
