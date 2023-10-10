package MySeleniumSessionsClasses.MySeleniumSessionsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo2Test {
	WebDriver driver;
  @BeforeTest
  public void SetUpTest() {
	driver=new ChromeDriver();
		
		driver.get("https://www.noon.com/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void test1Test() {
    //throw new RuntimeException("Test not implemented");
	  driver.findElement(By.id("dd_header_signInOrUp")).click();
		driver.findElement(By.id("emailInput")).sendKeys("akashashok78@gmail.com");
		driver.findElement(By.id("passwordInput")).sendKeys("Aakash#17");
		driver.findElement(By.xpath("//*[@id=\"login-submit\"]")).click();
		
		String name=driver.findElement(By.className("userName")).getText();
		if(name.contains("Aakash")) {
			System.out.print("name");
		}
  }

  @AfterTest
  public void tearDownTest() throws InterruptedException {
    Thread.sleep(1000);
  }

  
