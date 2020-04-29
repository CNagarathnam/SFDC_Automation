import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class RandomScenario extends BrowserUtil {

	public static void run() throws IOException, Exception {

		BrowserUtil.createtReport();
		BrowserUtil.createTestcase("TCID:35");
		// TCID : 35
		BrowserUtil.browserLaunch();
		BrowserUtil.logger.log(LogStatus.INFO, "Browser launched sucessfully");
		BrowserUtil.browserLogin();
		BrowserUtil.logger.log(LogStatus.INFO, "Login is Sucess");
		driver.findElement(By.xpath("//img[contains(@class,'allTabsArrow')]")).click();
		driver.findElement(By.xpath("//input[@name='customize']")).click();
		WebElement tab1 = driver.findElement(By.xpath("//select[@id='duel_select_1']"));
		Select stabitem = new Select(tab1);
		stabitem.selectByVisibleText("Subscriptions");
		driver.findElement(By.xpath("//img[contains(@class,'leftArrowIcon')]")).click();
		driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[contains(@name,'save')]")).click();
		BrowserUtil.browserLogout();
		BrowserUtil.browserLogin();

		try {
			WebElement eSub = driver.findElement(By.xpath("//a[contains(text(),'Subscriptions')]"));
			if (eSub.isDisplayed()) {
				// System.out.println("Test Case ID : 35 : Failed");
				BrowserUtil.logger.log(LogStatus.FAIL, "Test Case ID : 35 : Failed");
			}
		} catch (Exception e) {
			System.out.println(e);
			// System.out.println("Test Case ID : 35 : Passed");
			BrowserUtil.logger.log(LogStatus.PASS, "Test Case ID : 35 : Passed");
		}
		BrowserUtil.endTestcase();
		BrowserUtil.browserClose();

		// TCID : 36

		BrowserUtil.createTestcase("TCID:36");
		BrowserUtil.browserLaunch();
		BrowserUtil.logger.log(LogStatus.INFO, "Browser launched sucessfully");
		BrowserUtil.browserLogin();
		BrowserUtil.logger.log(LogStatus.INFO, "Login is Sucess");
		driver.findElement(By.xpath("//li[@id='home_Tab']//a[contains(text(),'Home')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'2020')]")).click();
		WebElement calScrollDown = driver.findElement(By.xpath("//a[contains(text(),'8:00 PM')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", calScrollDown);
		BrowserUtil.logger.log(LogStatus.INFO, "Sucessfully scrolled");
		driver.findElement(By.xpath("//a[contains(text(),'8:00 PM')]")).click();
		driver.findElement(By.xpath("//img[contains(@class,'comboboxIcon')]")).click();
		BrowserUtil.logger.log(LogStatus.INFO, "Sucessfully Clicked Combo Box");

		// BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//h1[@class='pageDescription']")));
		ArrayList<String> windows1 = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(windows1.size());
		driver.switchTo().window(windows1.get(1));
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//h1[@class='pageDescription']")));
		driver.findElement(By.xpath("//a[contains(text(),'Other')]")).click();

		// driver.findElement(By.xpath("//input[@id='evt5']")).click().
		windows1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows1.get(0));
		WebElement eEnddate = driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
		eEnddate.click();
		eEnddate.clear();
		eEnddate.sendKeys("9:00 PM");
		driver.findElement(By.xpath("//div[@id='ep']//div[contains(@class,'pbHeader')]//input[1]")).click();
		WebElement calanme = driver.findElement(By.xpath("//h1[contains(@class,'pageType')]"));
		String sCalname = "Calendar for Nagarathnam Chandramohan - Day View";
		if (calanme.getText().contains(sCalname)) {
			//// h1[contains(@class,'pageType')]
			BrowserUtil.logger.log(LogStatus.PASS, "Test Case ID : 36 : Passed");

		} else {
			BrowserUtil.logger.log(LogStatus.FAIL, "Test Case ID : 36 : Failed");
		}

		BrowserUtil.endTestcase();
		BrowserUtil.endReport();
	}
}
