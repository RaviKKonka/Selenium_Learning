package com.solutions;

import static org.testng.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class seleniumSolutions {

	WebDriver driver;
	ChromeOptions options;

	@Test
	public void TestGoogle() throws Exception {
		options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
	}

	@Test
	public void popupHandle() throws Exception {
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		System.out.println(driver.getTitle());
		driver.quit();
	}

	@Test
	void assertType() {
		SoftAssert softass = new SoftAssert();
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();

		// Hard Assert - it will stop execution
		// Assert.assertTrue(driver.getTitle().equals("Ravi Konka"));

		// Soft Assert - it will continue the execution
		softass.assertTrue(driver.getTitle().equals("Ravi Konka"));

		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("ravikonka76@gmail.com");
		// driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("sairam123");
		WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));

		// use JavaScript to enter text in textbox
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='sairam123'", password);

		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Login']")));
		login.click();
		// driver.findElement(By.xpath("//input[@value='Login']")).click();

		// get window handles
		String window = driver.getWindowHandle();
		System.out.println(window);
		Set<String> windows = driver.getWindowHandles();
		for (String str : windows)
			System.out.println(str);
		// driver.navigate().to("");
		driver.quit();
	}

	@Test
	public void testAssertFunctions() {
		driver = new ChromeDriver();
		driver.navigate().to("https://www.browserstack.com/");
		String ActualTitle = driver.getTitle();
		String verifyAssertNull = null;
		String ExpectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
		Boolean verifyTitleIsPresent = driver.getTitle()
				.equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform | BrowserStack");
		Boolean verifyTitleIsChanged = driver.getTitle().equalsIgnoreCase("Testing Platform | BrowserStack");
		assertEquals(ExpectedTitle, ActualTitle);
		assertNotEquals(ExpectedTitle, "browserstack");
		assertTrue(verifyTitleIsPresent);
		assertFalse(verifyTitleIsChanged);
		assertNotNull(verifyTitleIsPresent);
		assertNull(verifyAssertNull);
	}

	@Test
	public void softAssert() {
		driver = new ChromeDriver();
		SoftAssert softAssert = new SoftAssert();
		driver.navigate().to("https://www.browserstack.com/");
		String getActualTitle = driver.getTitle();
		Boolean verifyTitle = driver.getTitle()
				.equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform | BrowserStack");
		softAssert.assertEquals(getActualTitle, "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
		softAssert.assertNotEquals(getActualTitle, "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
		softAssert.assertNull(verifyTitle);
		softAssert.assertNotNull(verifyTitle);
		softAssert.assertTrue("BrowserStack".equals("Browserstack"), "First soft assert failed");
		softAssert.assertFalse("BrowserStack".equals("BrowserStack"), "Second soft assert failed");
		softAssert.assertAll();
		driver.quit();
	}

	@Test
	void testBrokenLinks() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			URL urlObj = new URL(url);
			HttpURLConnection http = (HttpURLConnection) (urlObj.openConnection());
			http.connect();
			System.out.println(http.getResponseCode());
			System.out.println(http.getResponseMessage());
		}
	}

	@Test
	void isExist() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		List<WebElement> buttons = driver.findElements(By.xpath("//span[@id='cart-total']"));
		System.out.println(buttons.size());
		if (buttons.size() != 0)
			System.out.println("Button Exists"); // it will return 1, if button exists
		else
			System.out.println("Button Does not Exists"); // it will return 0, if buttn does not exists

		// resize window
		Dimension dm = new Dimension(700, 900);
		driver.manage().window().setSize(dm);
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	void connectToDB() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/salesforcedb", "root", "sairam123");
		System.out.println(conn.isClosed());
		Statement statem = conn.createStatement();
		ResultSet resultSet = statem.executeQuery("SELECT * FROM salesforcedb.contacts;");
		while (resultSet.next()) {
			System.out.println(resultSet.getString("Name"));
			System.out.println(resultSet.getString("Company"));
			System.out.println(resultSet.getString("Status"));
		}
	}

	@Test
	void javaScriptSamples() {

		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// get title from app and store in variable
		String title = (String) js.executeScript("return document.title");
		System.out.println(title);

		// scroll
		js.executeScript("window.scrollBy(0,300)");
		js.executeScript("window.scrollBy(0,-300)");

		// Highlight Elements
		WebElement button = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
		js.executeScript("arguments[0].setAttribute('style','background:red;');", button);
	}

	@Test
	void webdriverActions() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();

		// Right Click
		WebElement button = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		Actions actions = new Actions(driver);

		// actions.contextClick().build().perform(); //Performs a context-click at the
		// current mouse location.
		Thread.sleep(2000);
		actions.contextClick(button).perform(); // Performs a context-click at middle of the given element. First
												// performs a mouseMove to thelocation of the element.

		// to perform doubleclick
		actions.doubleClick(button).perform();

		// drag and drop - button below should bereplaced with two webelements
		actions.dragAndDrop(button, button).perform();

		// Move to Element - over links to show drop down links
		WebElement link = driver.findElement(By.xpath("//a[normalize-space()='Components']"));
		actions.moveToElement(link).perform();
		driver.findElement(By.xpath("//a[normalize-space()='Show AllComponents']")).click();
		
		// All Actions
//		actions.contextClick(button).perform(); // Right Click
//		actions.doubleClick(button).perform(); // to perform doubleclick
//		actions.dragAndDrop(button, button).perform(); // drag and drop
//		actions.dragAndDropBy(draggable, 400, 500).perform();// drag and drop at given x and y coordinates
//		actions.moveToElement(link).perform(); // Move to Element
		
	}

	@Test
	void allLocators() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		driver.manage().window().maximize();

		driver.findElement(By.id("input-email")).sendKeys("ravikonka76@gmail.com"); // ID Locator
		driver.findElement(By.name("password")).sendKeys("sairam123"); // Name Locator
		driver.findElement(By.cssSelector("input[value='Login']")).click(); // CSS Selector
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Reward Points']")).click(); // XPath
																													// Locator
		// driver.findElement(By.className("btn btn-primary")).click(); // Class Name Locator
		driver.findElement(By.partialLinkText("Book")).click(); // Partial Link Text Locator
		driver.findElement(By.linkText("Edit Account")).click(); // Link Text Locator
		// driver.findElement(By.tagName("input")).click(); // TagName Locator

		// New Locators
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.xpath("//input[@id='input-password']")))
				.sendKeys("ravikonka123@gmail.com"); // above Releative Locator

		driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.xpath("//input[@id='input-email']")))
				.sendKeys("sairam123"); // below Releative Locator

		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Register']")).click();
		Thread.sleep(3000);
		driver.findElement(RelativeLocator.with(By.name("firstname"))
				.toRightOf(By.xpath("//label[normalize-space()='First Name']"))).sendKeys("RAVI KONKA");
		driver.findElement(RelativeLocator.with(By.name("lastname"))
				.toLeftOf(By.xpath("//label[normalize-space()='Last Name']']"))).sendKeys("RAVI KONKA");
		driver.findElement(
				RelativeLocator.with(By.name("lastname")).near(By.xpath("//label[normalize-space()='Last Name']']")))
				.sendKeys("RAVI KONKA");

		driver.quit();
	}
	
	@Test
	void alertsPopups() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Ravi");
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept(); // close alert by clicking Ok button
		//driver.switchTo().alert().dismiss(); // close alert by clicking cancel button
		
		// basic oath 
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	}
	
	@Test
	void uploadFile() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.manage().window().maximize();
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\ravik\\OneDrive\\Documents\\Automation\\Pictures\\signature.png");
		Thread.sleep(3000);
		driver.findElement(By.id("file-submit")).click();
	}

	@Test
	void iframesTest() {
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width_css");
		driver.manage().window().maximize();
		
//		driver.switchTo().frame(0); // by index
//		driver.switchTo().frame("<name> or <Id>"); // by name or id
		
		driver.switchTo().frame("iframeResult"); // by Name
		String str = driver.findElement(By.xpath("//h2[normalize-space()='HTML Iframes']")).getText();
		System.out.println(str);
		
		driver.switchTo().defaultContent(); // moving back to default frame or content when page loads

//		driver.switchTo().frame(WebElement);
		
		WebElement outerFrame = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(outerFrame);
		
		WebElement innerFrame = driver.findElement(By.xpath("//iframe[@title='Iframe Example']"));
		driver.switchTo().frame(innerFrame);

		String str1 = driver.findElement(By.cssSelector("body h1")).getText();
		System.out.println(str1);
		driver.switchTo().parentFrame(); // moving to parent frame
		
		str1 = driver.findElement(By.cssSelector("body p")).getText();
		System.out.println(str1);
		
	}
	
	
	@Test
	void waitTypes() {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000)); // Implicit Wait
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("ravikonka76@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("sairam123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5000));
		WebElement myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='My Account']")));
		System.out.println(myAccount.getText().equals("My Account"));
		
		
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		
		Wait<WebDriver> waitNew = new FluentWait<>(driver)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);
		
//		WebElement foo=waitNew.until(new Function<WebDriver, WebElement>() {
//			public WebElement applyy(WebDriver driver) {
//			return driver.findElement(By.id("foo"));
//			}
//			});
		
		driver.quit();
		
	}
	
	@Test
	void takeScreenshot() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshots\\homePage.jpg");
		
		FileHandler.copy(src, trg);
		Thread.sleep(5000);
		File section = driver.findElement(By.cssSelector(".o3j99.LLD4me.yr19Zb.LS8OJ")).getScreenshotAs(OutputType.FILE);
		trg = new File(".\\screenshots\\section.jpg");
		FileHandler.copy(section, trg);
		Thread.sleep(5000);
		
		File element = driver.findElement(By.cssSelector("div[class='FPdoLc lJ9FBc'] input[name='btnK']")).getScreenshotAs(OutputType.FILE);
		trg = new File(".\\screenshots\\element.jpg");
		FileHandler.copy(element, trg);
		Thread.sleep(6000);		
		
		driver.close();
		
	}

}
