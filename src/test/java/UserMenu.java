import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UserMenu extends BrowserUtil {

	public static void run() throws Exception {

		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();

		// TCID :TC05

		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//span[@id='userNavLabel']")));
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();

		driver.findElements(By.xpath("//div[@id='userNav-menuItems']"));
		List<WebElement> userMenuItems = driver.findElements(By.xpath("//div[@id='userNav-menuItems']"));
		List<String> mitems = new ArrayList<String>();
		for (int count = 0; count < userMenuItems.size(); count++) {
			System.out.println(userMenuItems.get(count).getText());
			mitems.add(userMenuItems.get(count).getText());
		}
		String comboTxt = userMenuItems.get(0).getText();
		String[] comboArr = comboTxt.split("\n");
		// validation
		String[] expectedMenuItems = new String[5];
		expectedMenuItems[0] = "My Profile";
		expectedMenuItems[1] = "My Settings";
		expectedMenuItems[2] = "Developer Console";
		expectedMenuItems[3] = "Switch to Lightning Experience";
		expectedMenuItems[4] = "Logout";

		if (Arrays.equals(comboArr, expectedMenuItems)) {
			System.out.println("Test Case ID : TC05 : Passed");
		} else {
			System.out.println("Test Case ID : TC05 : Failed");
		}

		// TCID : TC06
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")));
		WebElement emyprofile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		emyprofile.click();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']")));
		driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img")).click();
		Thread.sleep(2000);
		String currentWindowHandle = driver.getWindowHandle();
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		for (String window : windowHandles) {

			// if it contains the current window we want to eliminate that from switchTo();
			if (window != currentWindowHandle) {
				// Now switchTo new Tab.
				driver.switchTo().window(window);
				// Do whatever you want to do here.
				System.out.println("Switched to About Windows **************");
				BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//h2[@id='contactInfoTitle']")));
				//// iframe[@id='contactInfoContentId']
				driver.switchTo().frame("contactInfoContentId");
				driver.findElement(By.xpath("//li[@id='aboutTab']//a[contains(text(),'About')]")).click();
				// driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
				// driver.findElement(By.xpath("//li[@id='aboutTab']")).click();
				// driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
				BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//label[contains(text(),'Last Name')]")));
				driver.findElement(By.xpath("//input[@id='lastName']")).click();
				driver.findElement(By.xpath("//input[@id='lastName']")).clear();
				driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(prop.getProperty("uLastName"));

				// WebElement eSaveAll = driver.findElement(By.xpath("//input[@class='zen-btn
				// zen-primaryBtn zen-pas']"));
				// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(",
				// eSaveAll);
				driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']")).click();
				// Thread.sleep(5000);
				// Close the newly opened tab
				// driver.close();
			}
		}

		// Post
		BrowserUtil.waitToFindElement(driver
				.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]")));
		WebElement epost = driver
				.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]"));
		epost.click();
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]")));
		System.out.println("Switched to iframe of Post ********************");
		BrowserUtil.waitToFindElement(
				driver.findElement(By.xpath("//body[contains(text(),'Share an update, @mention someone...')]")));
		WebElement ePosttext = driver
				.findElement(By.xpath("//body[contains(text(),'Share an update, @mention someone...')]"));
		ePosttext.click();
		ePosttext.sendKeys(prop.getProperty("post"));
		driver.switchTo().defaultContent();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//input[@id='publishersharebutton']")));
		driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();

		// File
		BrowserUtil.waitToFindElement(driver
				.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]")));
		WebElement eFile = driver
				.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]"));
		eFile.click();
		Thread.sleep(5000);
		System.out.println("clicked the File link ****************");
		// BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']")));
		WebElement eFile1 = driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
		eFile1.click();
		// Thread.sleep(2000);
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//input[@id='chatterFile']")));
		WebElement eFile3 = driver.findElement(By.xpath("//input[@id='chatterFile']"));
		eFile3.sendKeys("C:\\TekArch_Assignments/cat1.jpg");
		String str = "MyFile_Upload";

		BrowserUtil.waitToFindElement(
				driver.findElement(By.xpath("//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]")));
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]")));
		System.out.println("switched to file upload *************");
		WebElement eFile4 = driver.findElement(By.xpath("//body[contains(text(),'Say something about this file...')]"));
		eFile4.click();
		eFile4.sendKeys(prop.getProperty("myFileupload"));
		driver.switchTo().defaultContent();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//input[@id='publishersharebutton']")));
		WebElement eFile5 = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		eFile5.click();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//p[contains(text(),'MyFile_Upload')]")));
		WebElement uploadFilename = driver.findElement(By.xpath("//p[contains(text(),'MyFile_Upload')]"));
		if (str.equals(uploadFilename)) {
			System.out.println("Test Case ID : TC06 :FileUpload Passed");
		} else {
			System.out.println("Test Case ID : TC06 :FileUpload Failed");
		}

		// ADD Photo

		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//span[@id='displayBadge']")));
		Actions moToAddphoto = new Actions(driver);
		WebElement moPhoto = driver.findElement(By.xpath("//span[@id='displayBadge']"));
		moToAddphoto.moveToElement(moPhoto).build().perform();
		// driver.findElement(By.xpath("//div[@id='photoSection']")).click();
		driver.findElement(By.xpath("//*[@id='uploadLink']")).click();

		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//h2[@id='uploadPhotoTitle']")));
		driver.switchTo().frame("uploadPhotoContentId");
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//input[@class='fileInput']")));
		driver.findElement(By.xpath("//input[@class='fileInput']")).sendKeys(prop.getProperty("addphoto"));
		driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadBtn']")).click();
		// driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@class='btn saveButton']")).click();

		// TC07

		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//a[contains(text(),'My Settings')]")));
		WebElement emySettings = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		emySettings.click();
		// String currentWindowHandle1 = driver.getWindowHandle();
		// ArrayList<String> mySettingwindowHandles = new
		// ArrayList<String>(driver.getWindowHandles());
		// for (String window:mySettingwindowHandles){
		//
		// //if it contains the current window we want to eliminate that from
		// switchTo();
		// if (window != currentWindowHandle1){
		// //Now switchTo new Tab.
		// driver.switchTo().window(window);
		//
		// //Do whatever you want to do here.
		// driver.findElement(By.xpath("//a[@id='cruc_notifyX']"));
		// }

		driver.findElement(By.xpath("//span[@id='PersonalInfo_font']")).click();
		driver.findElement(By.xpath("//span[@id='LoginHistory_font']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"))
				.click();
		driver.findElement(By.xpath("//span[@id='PersonalInfo_font']")).click();
		// Display&Layout
		driver.findElement(By.xpath("//span[@id='DisplayAndLayout_font']")).click();
		driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']")).click();
		Select custApp = new Select(driver.findElement(By.xpath("//select[@id='p4']")));
		// driver.findElement(By.xpath("//select[@id='p4']")).click();
		custApp.selectByVisibleText("Salesforce Chatter");

		WebElement sfavailTab = driver.findElement(By.xpath("//select[@id='duel_select_0']"));
		List<WebElement> sfavailItems = sfavailTab.findElements(By.xpath("//option[contains(text(),'Reports')]"));// findElements(By.tagName("li"));
		for (int i = 0; i < sfavailItems.size(); i++) {
			if (sfavailItems.get(i).getText().equalsIgnoreCase("Reports")) {
				sfavailItems.get(i).click();
				break;
			} else {
				System.out.println("Item not fount in the list");
			}
		}
		// Click on Arrow Icon outside the List box to move the Item
		driver.findElement(By.xpath("//img[contains(@class,'rightArrowIcon')]")).click();

		// Email
		driver.findElement(By.xpath("//div[@id='EmailSetup']//a[@class='header setupFolder']")).click();
		driver.findElement(By.xpath("//span[@id='EmailSettings_font']")).click();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']")));
		WebElement esenderName = driver.findElement(By.xpath("//input[@id='sender_name']"));
		esenderName.click();
		esenderName.clear();
		esenderName.sendKeys(prop.getProperty("sendername"));
		WebElement esenderMail = driver.findElement(By.xpath("//input[@id='sender_email']"));
		esenderMail.click();
		esenderMail.clear();
		esenderMail.sendKeys(prop.getProperty("senderemail"));
		driver.findElement(By.xpath("//label[contains(text(),'No')]")).click();
		driver.findElement(By.xpath("//input[@name='save']")).click();
		Alert emailAlert = driver.switchTo().alert();
		emailAlert.accept();
		// Calendar & Reminders

		driver.findElement(By.xpath("//span[@id='CalendarAndReminders_font']")).click();
		driver.findElement(By.xpath("//span[@id='Reminders_font']")).click();
		driver.findElement(By.xpath("//input[@id='testbtn']")).click();
		// Test Reminder PopUP

		//// String currentWindowHandle3 = driver.getWindowHandle();
		//// ArrayList<String> windowHandles3 = new
		//// ArrayList<String>(driver.getWindowHandles());
		//// for (String window:windowHandles3){
		////
		//// //if it contains the current window we want to eliminate that from
		//// switchTo();
		//// if (window != currentWindowHandle3){
		//// //Now switchTo new Tab.
		//// driver.switchTo().window(window);
		//// //Do whatever you want to do here.
		//// System.out.println("Switched to Test Reminder POP UP Windows
		//// **************");
		//// BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//div[contains(text(),'Sample
		//// Event.')]")));
		//// WebElement edismissall =
		//// driver.findElement(By.xpath("//input[@id='dismiss_all']"));
		//// edismissall.click();
		//
		// }
		//
		// }
		// TC08
		//
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		driver.findElement(By.xpath("//a[contains(@class,'debugLogLink menuButtonMenuLink')]")).click();
		String currentWindowHandle4 = driver.getWindowHandle();
		ArrayList<String> windowHandles4 = new ArrayList<String>(driver.getWindowHandles());
		for (String window : windowHandles4) {

			// if it contains the current window we want to eliminate that from switchTo();
			if (window != currentWindowHandle4) {
				// Now switchTo new Tab.
				driver.switchTo().window(window);
				// Do whatever you want to do here.
				System.out.println("Switched to Debug POP UP Windows **************");
				driver.close();
			}

		}
		// TC09
		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}

}
