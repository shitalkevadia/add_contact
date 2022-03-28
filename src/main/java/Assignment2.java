import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() throws InterruptedException {
		// Storing WebElement using WebElement Class
		// type Name = Value
		WebElement userNameElement = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement passWordElement = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement signinbuttonElement = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		// WebElement dashboardHeaderElement =
		// driver.findElement(By.xpath("//h2[contains(), 'Dashboard' ]"));
		
		// Strong WebElement using By Class
		By userNameLocator = By.xpath("//input[@id='username']");
		By passWordLocator = By.xpath("//input[@id='password']");
		By signinbuttonLocator = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By dashboardHeaderLocator = By.xpath("//h2[contains(text(), 'Dashboard')]");

		userNameElement.clear();
		userNameElement.sendKeys("demo@techfios.com");
		// passWordElement.clear();
		passWordElement.sendKeys("abc123");
		//signinbuttonElement.click();
		driver.findElement(signinbuttonLocator).click();
		Thread.sleep(3000);
		boolean pageTitleDisplayStatus ;
		try {
			WebElement dashboardHeaderElement = driver.findElement(By.xpath("//h2[contains(text(), 'Dashboard')]"));
			WebDriverWait wait = new WebDriverWait(driver, 15);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeaderLocator));
			pageTitleDisplayStatus = true;
			Assert.assertTrue("Dashboard page found", pageTitleDisplayStatus );
			System.out.println("dashboard");
		}catch(Exception e) {
			pageTitleDisplayStatus = false;
			e.printStackTrace();
		}
		
		// driver.findElement(userNameLocator).sendKeys("abc123");
		// driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		// driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		
		//WebDriverWait wait = new WebDriverWait(driver, 15);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeaderLocator));
//        Assert.assertTrue("Dashboard page found", pageTitleDisplayStatus );
        
		
	    //WebElement dashboardHeaderElement = driver.findElement(By.xpath("//h2[contains(text(), 'Dashboard')]"));
		//Assert.assertTrue("Dashboard page not found", dashboardHeaderElement.isDisplayed());

	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
