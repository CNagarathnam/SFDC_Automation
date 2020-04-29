import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount extends BrowserUtil {

	public static void run() throws Exception {
		// TCID : TC10
		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		BrowserUtil.waitToFindElement(
				driver.findElement(By.xpath("//li[@id='Account_Tab']//a[contains(text(),'Accounts')]")));
		clickOnAccountsTab();
		driver.findElement(By.xpath("//input[@name='new']")).click();
		WebElement eaccountName = driver.findElement(By.xpath("//input[@id='acc2']"));
		eaccountName.click();
		eaccountName.sendKeys(prop.getProperty("accountName"));
		driver.findElement(By.xpath("//select[@name='acc6']")).click();
		Select accType = new Select(driver.findElement(By.xpath("//select[@name='acc6']")));
		accType.selectByVisibleText("Technology Partner");
		driver.findElement(By.xpath("//select[@id='00N5w00000HZVzQ']")).click();
		Select ecustomePriority = new Select(driver.findElement(By.xpath("//select[@id='00N5w00000HZVzQ']")));
		ecustomePriority.selectByIndex(0);
		driver.findElement(By.xpath("//input[@title='Save']")).click();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//a[@class='brandPrimaryFgr']")));
		BrowserUtil.browserClose();

		// TCID : TC11
		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		clickOnAccountsTab();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		WebElement eviewName = driver.findElement(By.xpath("//input[@id='fname']"));
		eviewName.click();
		eviewName.sendKeys(prop.getProperty("accviewname"));
		WebElement eUviewName = driver.findElement(By.xpath("//input[@id='devname']"));
		eUviewName.click();
		eUviewName.sendKeys(prop.getProperty("accUviewname"));
		driver.findElement(By.xpath("//input[@title='Save']")).click();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//a[@class='brandPrimaryFgr']")));
		BrowserUtil.browserClose();

		// TCID : TC12
		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		clickOnAccountsTab();
		WebElement eeditView = driver
				.findElement(By.xpath("//span[contains(@class,'fFooter')]//a[contains(text(),'Edit')]"));
		eeditView.click();
		WebElement eEviewName = driver.findElement(By.xpath("//input[@id='fname']"));
		eEviewName.click();
		eEviewName.clear();
		eEviewName.sendKeys(prop.getProperty("editaccviewname"));
		WebElement eEUviewName = driver.findElement(By.xpath("//input[@id='devname']"));
		eEUviewName.click();
		eEUviewName.clear();
		eEUviewName.sendKeys(prop.getProperty("editaccUviewname"));
		driver.findElement(By.xpath("//input[@title='Save']")).click();
		BrowserUtil.browserClose();

		// TCID : TC13
		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();

		clickOnAccountsTab();
		driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]")).click();
		WebElement eaccsearch = driver.findElement(By.xpath("//input[@id='srch']"));
		eaccsearch.click();
		eaccsearch.sendKeys(prop.getProperty("mergeaccname"));
		driver.findElement(By.xpath("//input[contains(@name,'srchbutton')]")).click();
		driver.findElement(By.xpath("//input[@id='cid0']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[contains(@name,'goNext')]"))
				.click();

		driver.findElement(By.xpath("//input[@title='Merge']")).click();
		Alert amergealert = driver.switchTo().alert();
		amergealert.accept();
		BrowserUtil.browserClose();

		// TCID : TC14
		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		driver.findElement(By.xpath("//li[@id='Account_Tab']//a[contains(text(),'Accounts')]")).click();
		Thread.sleep(2000);
		BrowserUtil.sfPopUpWindowClose();

		driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]")).click();
		driver.findElement(By.xpath("//img[@id='ext-gen152']")).click();
		driver.findElement(By.xpath("//button[contains (text(),'Today')]")).click();
		driver.findElement(By.xpath("//button[@id='ext-gen63']")).click();
		driver.findElement(By.xpath("//input[contains(@name,'memorizenew')]")).click();
		WebElement ereportName = driver.findElement(By.xpath("//input[@id='report_name']"));
		ereportName.click();
		ereportName.clear();
		ereportName.sendKeys(prop.getProperty("accReport"));
		WebElement eUreportName = driver.findElement(By.xpath("//input[@id='devName']"));
		eUreportName.click();
		eUreportName.clear();
		eUreportName.sendKeys(prop.getProperty("accUreport"));
		driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]")).click();

	}

	public static void clickOnAccountsTab() {
		driver.findElement(By.xpath("//li[@id='Account_Tab']//a[contains(text(),'Accounts')]")).click();
		BrowserUtil.sfPopUpWindowClose();
	}

}
