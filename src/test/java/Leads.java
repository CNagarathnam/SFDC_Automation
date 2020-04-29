import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Leads extends BrowserUtil{

	public static void run () throws Exception {

		//TCID : 20
		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		driver.findElement(By.xpath("//a[contains(@title,'Leads Tab')]")).click();
		BrowserUtil.sfPopUpWindowClose();
		WebElement eLeads = driver.findElement(By.xpath("//h1[contains(@class,'pageType')]"));
		String str= "Leads";
		if (str.equals(eLeads.getText())) {
			System.out.println("Test Case ID : TC20 : Passed");
		}else {
			System.out.println("Test Case ID : TC20 : Failed");
		}

		//TCID :21
		driver.findElement(By.xpath("//a[contains(@title,'Leads Tab')]")).click();
		//BrowserUtil.sfPopUpWindowClose();
		driver.findElement(By.xpath("//select[@id='fcf']")).click();
		WebElement eviewLeads = driver.findElement(By.xpath("//select[@id='fcf']"));
		Select allLeads = new Select(eviewLeads);
		List<WebElement> leads = allLeads.getOptions();
		System.out.println("The list of all Leads :");
		for (WebElement option : leads) {
			System.out.println(option.getText());
		}


		//TCID : 22
		driver.findElement(By.xpath("//a[contains(@title,'Leads Tab')]")).click();

		driver.findElement(By.xpath("//select[@id='fcf']")).click();
		WebElement eviewLead2 = driver.findElement(By.xpath("//select[@id='fcf']"));
		Select viewLead = new Select(eviewLead2);
		viewLead.selectByIndex(3);
		BrowserUtil.browserClose();
		BrowserUtil.browserLaunch();
		BrowserUtil.browserLogin();
		driver.findElement(By.xpath("//a[contains(@title,'Leads Tab')]")).click();
		BrowserUtil.sfPopUpWindowClose();
		driver.findElement(By.xpath("//span[contains(@class,'fBody')]//input[contains(@name,'go')]"));


		//TCID :TC23
		driver.findElement(By.xpath("//a[contains(@title,'Leads Tab')]")).click();
		driver.findElement(By.xpath("//select[@id='fcf']")).click();
		WebElement eviewLead3 = driver.findElement(By.xpath("//select[@id='fcf']"));
		Select viewLead1 = new Select(eviewLead3);
		viewLead1.selectByIndex(1);

		//TCID :TC24
		driver.findElement(By.xpath("//a[contains(@title,'Leads Tab')]")).click();
		driver.findElement(By.xpath("//input[contains(@name,'new')]")).click();
		//driver.findElement(By.xpath("//input[@id='name_lastlea2']")).click();
		driver.findElement(By.xpath("//input[@id='name_lastlea2']")).sendKeys(prop.getProperty("leadLastName"));
		driver.findElement(By.xpath("//input[@id='lea3']")).sendKeys(prop.getProperty("lcompanyName"));
		driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//input[1]")).click();
		Thread.sleep(4000);
		//driver.findElement(By.xpath("//th[contains(@class,'')]//a[contains(text(),'ABCD')]")).click();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//h2[@class='topName']")));
		String str8="ABCD";
		WebElement enewLead = driver.findElement(By.xpath("//h2[@class='topName']"));
		if (enewLead.getText().contains(str8)) {
			System.out.println("Test Case TCID :24 Passed");
		}else {

			System.out.println("Test Case TCID :24 Failed");
		}

		BrowserUtil.browserClose();
	}



}


