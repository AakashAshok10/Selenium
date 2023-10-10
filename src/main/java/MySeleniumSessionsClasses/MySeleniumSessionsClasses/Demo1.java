package MySeleniumSessionsClasses.MySeleniumSessionsClasses;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class Demo1 {
	SoftAssert sA=new SoftAssert();
	
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver drv = new ChromeDriver();
		drv.manage().window().maximize();
		drv.get("https://www.hyrtutorials.com");
		drv.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println(drv.getTitle());
		
		drv.findElement(By.linkText("Selenium Practice")).click();
		Thread.sleep(5000);
		drv.findElement(By.linkText("Alerts")).click();
		String cururl= drv.getCurrentUrl();
		System.out.println(cururl);
		drv.switchTo().frame(drv.findElement(By.id("google_esf")));

		drv.switchTo().frame(drv.findElement(By.id("aswift_5")));
		drv.findElement(By.xpath("//*[@id=\"dismiss-button\"]")).click();

		/*if(cururl.equals("https://www.hyrtutorials.com/#google_vignette")) {
			drv.navigate().to("https://www.hyrtutorials.com/#google_vignette");
			drv.findElement(By.xpath("//*[@id=\"dismiss-button\"]")).click();
		}*/
		
		drv.switchTo().defaultContent();
		drv.findElement(By.linkText("Alerts")).click();

		//
		//drv.navigate().to(cururl);
		/*drv.findElement(By.id("alertbox"));
		
		Alert al=drv.switchTo().alert();
		al.accept();
		*/
		
	}

}
