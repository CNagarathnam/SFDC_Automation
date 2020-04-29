import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Contacts extends BrowserUtil {

	public static void run() throws Exception {

		// TCID : 25

		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		clickOnContactsTab();
		driver.findElement(By.xpath("//input[@name='new']")).click();
		driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys(prop.getProperty("clastname"));
		driver.findElement(By.xpath("//input[@id='con4']")).sendKeys(prop.getProperty("caccountname"));
		driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//input[1]")).click();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//h2[contains(@class,'topName')]")));
		WebElement enewContact = driver.findElement(By.xpath("//h2[contains(@class,'topName')]"));
		String contact = "Krish";
		if (enewContact.getText().contains(contact)) {
			System.out.println("Test Case ID : TC25 : Passed");
		} else {
			System.out.println("Test Case ID : TC25 : Failed");
		}
		BrowserUtil.browserClose();

		// TCID : 26
		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		clickOnContactsTab();
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(prop.getProperty("createViewName"));
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys(prop.getProperty("viewUniqueName"));
		// Thread.sleep(4000);
		WebElement eViewUniqueName = driver.findElement(By.xpath("//img[@class='infoIcon']"));
		Actions viewUniqueName = new Actions(driver);
		viewUniqueName.moveToElement(eViewUniqueName).build().perform();
		driver.findElement(By.xpath("//div[@class='mouseOverInfo']")).getText();
		System.out.println(driver.findElement(By.xpath("//div[@class='mouseOverInfo']")).getText());
		// ****The below code is to move the mouse pointer which is blocking the
		// clicking of Save button******************
		WebElement emovemp = driver.findElement(By.xpath("//label[contains(text(),'Campaign Name:')]"));
		viewUniqueName.moveToElement(emovemp).build().perform();
		driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']")).click();

		// validation
		String str4 = "NewView_Auto";
		driver.findElement(By.xpath("//select[@class='title']")).click();
		List<WebElement> allViewList = driver.findElements(By.xpath("//select[@class='title']"));
		for (WebElement viewList : allViewList) {
			// System.out.println(viewList.getText());
			if (viewList.getText().contains(str4)) {
				System.out.println("Test Case ID : TC26 : Passed");
			} else {
				System.out.println("Test Case ID : TC26 : Failed");
			}
		}

		BrowserUtil.browserClose();

		// TCID : 27

		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		clickOnContactsTab();
		WebElement eRview = driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		eRview.click();
		Select Rview = new Select(eRview);
		Rview.selectByVisibleText("Recently Created"); //
		WebElement econtact = driver
				.findElement(By.xpath("//tr[contains(@class,'dataRow even first')]//a[contains(text(),'Krish')]"));
		econtact.click();
		String str8 = "Krish";
		WebElement eNcontact = driver.findElement(By.xpath("//h2[contains(@class,'topName')]"));
		if (str8.contains(eNcontact.getText())) {
			System.out.println("Test Case ID : TC27 : Passed");
		} else {
			System.out.println("Test Case ID : TC27 : Failed");
		}
		BrowserUtil.browserClose();

		// TCID : 28

		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		clickOnContactsTab();
		driver.findElement(By.xpath("//select[@id='fcf']")).click();
		Select myContact = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		myContact.selectByVisibleText("My Contacts");
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();

		// Validation.

		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//a[contains(text(),'Krish')]")));
		WebElement ects = driver.findElement(By.xpath("//a[contains(text(),'Krish')]"));
		ects.click();
		String str10 = "Krish";
		WebElement emycts = driver.findElement(By.xpath("//h2[contains(@class,'topName')]"));
		if (str10.contains(emycts.getText())) {
			System.out.println("Test Case ID : TC28 : Passed");
		} else {
			System.out.println("Test Case ID : TC28 : Failed");

		}
		BrowserUtil.browserClose();

		// TCID : 29

		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		clickOnContactsTab();
		driver.findElement(By.xpath("//select[@id='fcf']")).click();
		Select myContact2 = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		myContact2.selectByVisibleText("My Contacts");
		// Validation

		BrowserUtil.waitToFindElement(driver
				.findElement(By.xpath("//tr[contains(@class,'dataRow even first')]//a[contains(text(),'Krish')]")));
		WebElement ects2 = driver
				.findElement(By.xpath("//tr[contains(@class,'dataRow even first')]//a[contains(text(),'Krish')]"));
		ects2.click();
		String str11 = "Krish";
		WebElement emycts2 = driver.findElement(By.xpath("//h2[contains(@class,'topName')]"));
		if (str11.contains(emycts2.getText())) {
			System.out.println("Test Case ID : TC29 : Passed");
		} else {
			System.out.println("Test Case ID : TC29 : Failed");

		}

		BrowserUtil.browserClose();

		// TCID : 30
		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		clickOnContactsTab();
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys(prop.getProperty("viewUniqueName"));
		driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']")).click();
		String strError = "Error";
		WebElement egetError = driver.findElement(By.xpath("//div[contains(text(),'You must enter a value')]"));
		if (egetError.getText().contains(strError)) {
			System.out.println("Test Case ID : TC30 : Passed");
		} else {
			System.out.println("Test Case ID : TC30 : Failed");

		}

		BrowserUtil.browserClose();

		// TCID : 31
		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		clickOnContactsTab();
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(prop.getProperty("cancelviewname"));
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys(prop.getProperty("cancelUviewname"));
		driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='cancel']")).click();
		driver.findElement(By.xpath("//select[@id='fcf']")).click();
		WebElement eallviews = driver.findElement(By.xpath("//select[@id='fcf']"));

		List<WebElement> listallviews = driver.findElements(By.xpath("//select[@id='fcf']"));
		for (WebElement findview : listallviews) {
			if (findview.getText().equals(prop.getProperty("cancelviewname"))) {
				System.out.println(findview.getText());
				System.out.println("Test Case ID : TC31 : Failed");

			} else {
				System.out.println(findview.getText());
				System.out.println("Test Case ID : TC31 : Passed");
			}
		}
		BrowserUtil.browserClose();

		// TCID : 32

		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		// Executing below code first to create the account : Global Media
		BrowserUtil.waitToFindElement(
				driver.findElement(By.xpath("//li[@id='Account_Tab']//a[contains(text(),'Accounts')]")));
		driver.findElement(By.xpath("//li[@id='Account_Tab']//a[contains(text(),'Accounts')]")).click();
		BrowserUtil.sfPopUpWindowClose();
		driver.findElement(By.xpath("//input[@name='new']")).click();
		WebElement eaccountName = driver.findElement(By.xpath("//input[@id='acc2']"));
		eaccountName.click();
		eaccountName.sendKeys(prop.getProperty("cSaveaccname"));
		driver.findElement(By.xpath("//input[@title='Save']")).click();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		// try {
		// BrowserUtil.sfPopUpWindowClose();
		//
		// }catch (Exception e) {
		// System.out.println(e);
		// }
		driver.findElement(By.xpath("//input[@name='new']")).click();
		driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys(prop.getProperty("cSavelastname"));
		driver.findElement(By.xpath("//input[@id='con4']")).sendKeys(prop.getProperty("cSaveaccname"));
		driver.findElement(By.xpath("//td[@id='topButtonRow']//input[contains(@name,'save_new')]")).click();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//h2[contains(@class,'pageDescription')]")));
		String str15 = " New Contact";
		WebElement conaccname = driver.findElement(By.xpath("//h2[contains(@class,'pageDescription')]"));

		if (conaccname.getText().contains(str15)) {
			System.out.println("Test Case ID : TC31 : Passed");
		} else {
			System.out.println("Test Case ID : TC31 : Failed");
		}

		BrowserUtil.browserClose();

	}

	public static void clickOnContactsTab() {
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		BrowserUtil.sfPopUpWindowClose();
	}

}
