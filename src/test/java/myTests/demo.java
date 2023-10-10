package myTests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@Test
public class demo {
	
	WebDriver driver ;
	//WebDriverWait wait;
	
	
	@BeforeTest
	public  void setUp() {

			
			driver = new ChromeDriver();
			driver.get("https://www.headphonezone.in");
			driver.manage().window().maximize();	
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			
	
	}
	@Test
	public void test1() {
		
		System.out.println("Actual Title : "+driver.getTitle());
		String expTitle="Headphone Zone: Rediscover Music at India's #1 Audiophile Store";
		Assert.assertEquals(driver.getTitle(), expTitle);
		
		//driver.findElement(By.name("customer[email]")).sendKeys("akashashok78@gmail.com");
		//driver.findElement(By.name("customer[password]")).sendKeys("Aakash#10");
		//driver.findElement(By.xpath("//*[@id=\"customer_login\"]/button")).click();
		/* driver.findElement(By.className("recaptcha-checkbox-border")).click();
		driver.findElement(By.xpath("//input[contains(@class,'shopify')]")).click();
		*/
		//driver.findElement(By.xpath("//*[@id=\"lion-loyalty-panel-custom-css\"]/div[5]/div/a")).click();
		
		
	}
	@Test
	public void test2() throws InterruptedException {
		//driver.findElement(By.xpath("//summary[contains(text(),'On Sale']")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'nav-font') and contains(., 'Categories')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navigation-drawer-2\"]/div/div[1]/div/div[1]/ul/li[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"navigation-drawer-2\"]/div/div[2]/div[1]/ul/li[4]/a")).click();
		//driver.findElement(By.xpath("//span[text()='Studio & Professional']")).click();
		//wait1 = new WebDriverWait(driver,10);
		try{
			Alert ale=driver.switchTo().alert();
			System.out.println(ale.getText());
			ale.dismiss(); //block notifications
		}
		catch( NoAlertPresentException e) {
			
		}
		WebElement wb=driver.findElement(By.xpath("//span[@id='Filter_Brand']"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", wb);
		driver.findElement(By.xpath("//span[@id='Filter_Brand']")).click();
		//driver.findElement(By.xpath("//*[@id=\"shopify-section-template--16093134487740__main\"]/div/div/div[1]/div/form/div[2]/button[1]")).click();
		
		//driver.findElement(By.xpath("//input[contains(@id, 'checkbox-template--') and contains(@id, '__main-filter.p.vendor-2')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(@for, 'checkbox-template--') and contains(@for, '__main-filter.p.vendor-2')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(), 'Audio-Technica - ATH-M50x')]")).click();
		
		driver.findElement(By.id("pincodeInput")).sendKeys("671542");
		driver.findElement(By.id("pinSubmit")).click();
		
		driver.findElement(By.xpath("//button[contains(., 'Add to cart')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(), 'View cart')]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"input-template--16093134422204__main--note\"]")).sendKeys("Buy Later");
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Your Shopping Cart");
		//wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.alertIsPresent()).dismiss();
		//button[contains(@class, 'nav-font') and contains(., 'Categories')]
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
