import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BrowserUtil{

	public static void run() throws Exception {

		//Testcase :1
		BrowserUtil.browserLaunch();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//img[@id='logo']")));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@id='password']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//input[@id='Login']")));
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		WebElement epwd = driver.findElement(By.xpath("//div[@id='error']"));
		System.out.println(epwd.getText());
		String sLogin = "Please enter your password.";

		if (sLogin.equals(epwd.getText())) {
			System.out.println("Test Case ID : Login Error Message - 1 : Passed");

		}
		else {
			System.out.println("Test Case ID : Login Error Message - 1 : Failed");
		}

		BrowserUtil.browserClose(); 

		//Testcase :2 

		BrowserUtil.browserLaunch();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//img[@id='logo']")));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@id='password']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(prop.getProperty("password"));
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//input[@id='Login']")));
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("(//a[contains(text(),'Home')])[1]")));
		WebElement eHome = driver.findElement(By.xpath("(//a[contains(text(),'Home')])[1]"));
		String str2="Home";

		if (str2.equals(eHome.getText())) {
			System.out.println("Test Case ID : Login To SalesForce -2 : Passed");
		}else 
		{
			System.out.println("Test Case ID : Login To SalesForce -2 : Failed");
		}

		BrowserUtil.browserClose(); 

		//Testcase :3

		BrowserUtil.browserLaunch();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//img[@id='logo']")));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@id='password']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(prop.getProperty("password"));
		WebElement eremember = driver.findElement(By.xpath("//input[@id='rememberUn']")); 
		eremember.click();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//input[@id='Login']")));
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//span[@id='userNavLabel']")));
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//a[contains(text(),'Logout')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//img[@id='logo']")));
		WebElement eremember1 = driver.findElement(By.xpath("//input[@id='rememberUn']"));

		if ( eremember1.isSelected())   { ////isEnabled() //eusername.isSelected()
			System.out.println("Test Case ID : Check RemeberMe - 3 : Passed");
		}
		else {
			System.out.println("Test Case ID : Check RemeberMe - 3 : Failed");
		}

		BrowserUtil.browserClose(); 

		//TestCase : 4A
		BrowserUtil.browserLaunch();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//img[@id='logo']")));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//a[@id='forgot_password_link']")).click();
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//a[@class='primary button wide mb16']")).click();
		BrowserUtil.browserClose();

		//TestCase : 4B

		BrowserUtil.browserLaunch();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//img[@id='logo']")));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(prop.getProperty("wrongusername"));
		driver.findElement(By.xpath("//input[@id='password']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(prop.getProperty("wrongpassword"));
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//input[@id='Login']")));
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//div[@id='error']")));
		BrowserUtil.browserClose();
	}

}
