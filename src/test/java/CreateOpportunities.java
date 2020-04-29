import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateOpportunities extends BrowserUtil{

	public static void run () throws Exception {

		//TCID :TC15

		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		clickOnOpportunities();
		driver.findElement(By.xpath("//select[@id='fcf']")).click();
		WebElement eopp = driver.findElement(By.xpath("//select[@id='fcf']"));
		Select allOpportunities = new Select(eopp) ;
		//List<WebElemet> oppItems = driver.findElements(By.xpath(""));
		List<WebElement> oppList = allOpportunities.getOptions();
		System.out.println("The options list : ");
		for (WebElement option : oppList) {
			System.out.println(option.getText());
		}

		BrowserUtil.browserClose();


		//TCID : TC16
		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		clickOnOpportunities();
		driver.findElement(By.xpath("//input[@name='new']")).click();
		WebElement eoppName = driver.findElement(By.xpath("//input[@id='opp3']"));
		eoppName.click();
		eoppName.clear();
		eoppName.sendKeys(prop.getProperty("oppName"));
		WebElement eoppCloseDate = driver.findElement(By.xpath("//input[@id='opp9']"));
		eoppCloseDate.click();
		driver.findElement(By.xpath("//a[contains(@class,'calToday')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Stage')]")).click();
		//Stage
		driver.findElement(By.xpath("//select[@id='opp11']")).click();
		WebElement estage = driver.findElement(By.xpath("//select[@id='opp11']"));
		Select stage = new Select(estage);
		stage.selectByIndex(1);
		BrowserUtil.browserClose();

		//handle popup window -Account Name
		//        driver.findElement(By.xpath("//img[contains(@title,'Account Name Lookup (New Window)')]")).click();
		//        Thread.sleep(5000);
		//        ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		// 		driver.switchTo().window(windows.get(0));
		// 		System.out.println("switched to search popup window");
		// 		//driver.findElement(By.xpath("//input[@id='opp4']")).click();
		//// 		WebElement accframe = driver.findElement(By.xpath("//input[@name='go']"));
		// 		driver.switchTo().frame(driver.findElement(By.xpath("//tr[@class='dataRow even first']//th")));
		// 		driver.findElement(By.xpath("//tr[contains(@class,'dataRow even first')]//a[contains(@class,'dataCell')][contains(text(),'AAA')]")).click();
		// 		//driver.findElement(By.xpath("//input[@name='go']")).click();;
		// 		
		// 		//BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//h1[contains(text(),'Lookup')]")));
		// 		
		// 		////tr[@class='dataRow even first']//a[contains(@class,'dataCell')][contains(text(),'AAA')]
		// 		//driver.findElement(By.xpath("//tr[contains(@class,'dataRow even first')]//a[contains(@class,'dataCell')][contains(text(),'AAA')]")).click();
		// 		//Thread.sleep(5000);
		// 		//driver.close();
		// 		windows = new ArrayList<String>(driver.getWindowHandles());
		// 		driver.switchTo().window(windows.get(0)); 
		// 		//Lead source
		// 		driver.findElement(By.xpath("//select[@id='opp6']")).click();
		// 		Select lsource = new Select (driver.findElement(By.xpath("//select[@id='opp6']")));
		// 		lsource.selectByIndex(0);

		//Primary CAmpaign

		// 		driver.findElement(By.xpath("//img[contains(@title,'Primary Campaign Source Lookup (New Window)')]")).click();
		// 		ArrayList<String> windows1= new ArrayList<String>(driver.getWindowHandles());
		// 		driver.switchTo().window(windows1.get(0));
		// 		driver.findElement(By.xpath("//a[contains(@class,'dataCell')]")).click();
		// 		windows1 = new ArrayList<String> (driver.getWindowHandles());
		// 		driver.switchTo().window(windows1.get(0));

		//driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//input[1]")).click();

		//TCID : TC17
		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		clickOnOpportunities();
		driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]")).click();
		WebElement eoppoPipeline = driver.findElement(By.xpath("//div[@id='status']"));
		String str = "Complete";
		if (str.equals(eoppoPipeline.getText())) {
			System.out.println("Test Case ID : TC17 : Passed");
		} else {
			System.out.println("Test Case ID : TC17 : Failed");
		}
		BrowserUtil.browserClose();


		//TCID : TC18
		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		clickOnOpportunities();
		driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]")).click();
		WebElement estuckOppor = driver.findElement(By.xpath("//div[@id='status']"));
		String str1 = "Complete";
		if (str1.equals(estuckOppor.getText())) {
			System.out.println("Test Case ID : TC18 : Passed");
		} else {
			System.out.println("Test Case ID : TC18 : Failed");
		}

		BrowserUtil.browserClose(); 

		//TCID : TC19
		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		clickOnOpportunities();
		driver.findElement(By.xpath("//a[contains(text(),'Opportunity Field History Report')]")).click();
		driver.findElement(By.xpath("//select[@id='colDt_q']")).click();
		WebElement etimeRange = driver.findElement(By.xpath("//select[@id='colDt_q']"));
		Select timeRange = new Select(etimeRange);
		timeRange.selectByVisibleText("Current FY");
		driver.findElement(By.xpath("//span[@id='runMuttonLabel']")).click();
		WebElement eoppofieldHistory = driver.findElement(By.xpath("//div[@id='status']"));
		String str3 = "The report returned no results.";
		if (str3.equals(eoppofieldHistory.getText())) {
			System.out.println("Test Case ID : TC19 : Passed");
		} else {
			System.out.println("Test Case ID : TC19 : Failed");
		}
		BrowserUtil.browserClose();






	}

	public static void clickOnOpportunities() {
		driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")).click();
		BrowserUtil.sfPopUpWindowClose();
	}

}
