package Assignment_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class IndiaTimes {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.firefox.marionette","C:\\Users\\rajni.nepali\\Downloads\\geckodriver-v0.20\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			 driver.get("https://www.indiatimes.com/");
			 WebElement signUp = driver.findElement(By.className("dummy"));
			 signUp.click();
			 String winHandleBefore = driver.getWindowHandle();
			 for(String winHandle : driver.getWindowHandles()){
				 System.out.println("rajni   ");
				 driver.switchTo().window(winHandle);  
				}
			 WebElement username = driver.findElement(By.id("emailId"));
				username.sendKeys("rajninepali0694@gmail.com");
				Thread.sleep(5000);
			WebElement SiginBtn = driver.findElement(By.className("btn"));
				SiginBtn.click();
				Thread.sleep(5000);
			WebElement password = driver.findElement(By.id("password"));
				password.sendKeys("ratsrajni0694");
				Thread.sleep(5000);
				SiginBtn.click();
		 driver.close();
		 driver.switchTo().window(winHandleBefore);
		 driver.close();
	}

}
