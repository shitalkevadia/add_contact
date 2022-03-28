import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homework {
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
		By userNameLocator = By.xpath("//input[@id='username']");
		By passWordLocator = By.xpath("//input[@id='password']");
		By signinbuttonLocator = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By dashboardHeaderLocator = By.xpath("//h2[contains(text(), 'Dashboard')]");
		By customermenuLocator = By.xpath("//span[contains(text(),'Customers')]");
		By addcustomermenuLocator = By.xpath("//a[contains(text(),'Add Customer')]");
		By fullnameLocater = By.xpath("//input[@name = 'account']");
		By companyDropdownLocator = By.xpath("//select[@id=\"cid\"]");
		By emailinputLocator = By.xpath("//input[@id = 'email' and @name = 'email']");
		By phonenumberLocator = By.xpath("//input[@name = 'phone']");
		By addressinputLocator = By.xpath("//input[@name = 'address']");
		By cityinputLocator = By.xpath("//input[@name = 'city']");
		By stateinputLocatore = By.xpath("//input[@name = 'state']");
		By zipinputLocator = By.xpath("//input[@name = 'zip']");
		By countrynameDropdownLocator = By.xpath("//select[@name = 'country']");
		By savebuttonLocatore = By.xpath("//button[@id= 'submit']");
		By listcustomerLocator = By.xpath("//a[contains(text(),'List Customers')]");
		By searchboxinputLocator = By.xpath("//input[@id='foo_filter']");
		By searchbuttonLocator = By.xpath("//div[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/div/div/div/div");
		By newlistednameLocator = By.xpath("//a[contains(text(),'shital kevadia')]");
		
		driver.findElement(userNameLocator).sendKeys("demo@techfios.com");
		driver.findElement(passWordLocator).sendKeys("abc123");
		driver.findElement(signinbuttonLocator).click();

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeaderLocator));
		Assert.assertTrue("Dashboard page not found!!", driver.findElement(dashboardHeaderLocator).isDisplayed());
		String Dashboardheader = driver.findElement(dashboardHeaderLocator).getText();
		System.out.println(Dashboardheader);
		// Assert.assertEquals("Dashboard page not found!!", "Dashboard",
		// Dashboardheader);
		Assert.assertEquals("not found", "Dashboard", Dashboardheader);
		driver.findElement(customermenuLocator).click();

		driver.findElement(addcustomermenuLocator).click();
		Random rnd = new Random();
		int generatedNo = rnd.nextInt(999);
		driver.findElement(fullnameLocater).sendKeys("shital kevadia" +generatedNo );
		Thread.sleep(1000);
		
		Select sel = new Select(driver.findElement(By.xpath("//select[@id=\"cid\"]")));
		sel.selectByVisibleText("Techfios");
		Thread.sleep(1000);
		
      
		// Thread.sleep(2000);
		driver.findElement(emailinputLocator).sendKeys("shital@gmail.com" +generatedNo);
		driver.findElement(phonenumberLocator).sendKeys("5667895432" +generatedNo);
		driver.findElement(addressinputLocator).sendKeys("1128 ala napunani," +generatedNo);
		driver.findElement(cityinputLocator).sendKeys("honolulu" +generatedNo);
		driver.findElement(stateinputLocatore).sendKeys("HI");
		driver.findElement(zipinputLocator).sendKeys("65399");

		Select sel1 = new Select(driver.findElement(countrynameDropdownLocator));
		sel1.selectByVisibleText("United States");
		// sel1.getOptions();

		driver.findElement(savebuttonLocatore).click();
		Thread.sleep(2000);
		driver.findElement(listcustomerLocator).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 15);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(listcustomerLocator));
	
		driver.findElement(searchboxinputLocator).sendKeys("shital kevadia");
		//Assert.assertEquals("not found", "shital kevadia", newlistednameLocator);

		Thread.sleep(10000);
        driver.findElement(searchbuttonLocator).click();
        Thread.sleep(10000);
        //driver.findElement(newlistednameLocator).click();
        
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
