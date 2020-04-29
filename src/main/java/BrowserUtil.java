import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	public static WebDriver driver = null;
	static Properties prop = new Properties();
	static ExtentReports reports;
	static ExtentTest logger;

	public static void browserSetProperties() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void browserLaunch() throws IOException {
		BrowserUtil.browserSetProperties();
		readProperty();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public static void browserLogin() {
		// BrowserUtil.browserLaunch();
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//img[@id='logo']")));
		WebElement eLuserName = driver.findElement(By.xpath("//input[@id='username']"));
		eLuserName.click();
		eLuserName.clear();
		eLuserName.sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@id='password']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@id='Login']")).click();
	}

	public static void browserLogout() {

		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}

	public static void browserClose() {
		driver.close();
	}

	public static void sfPopUpWindowClose() {

		ArrayList<String> accountPopupWindowClose = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(accountPopupWindowClose.size());
		driver.switchTo().window(accountPopupWindowClose.get(0));
		BrowserUtil.waitToFindElement(driver.findElement(By.xpath("//*[@id='lexNoThanks']")));
		driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
		accountPopupWindowClose = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(accountPopupWindowClose.get(0));
	}

	public static void waitToFindElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void readProperty() throws IOException {

		FileInputStream ip = new FileInputStream("C:/Users/Rachel/eclipse-workspace/SFDC/config.properties");
		prop.load(ip);
	}

	public static void createtReport() {

		String sPath = System.getProperty("user.dir") + "/ExtentReports/SampleReport.html";
		reports = new ExtentReports(sPath);

	}

	public static void createTestcase(String sTestcaseName) {
		logger = reports.startTest(sTestcaseName);
	}

	public static void endTestcase() {
		reports.endTest(logger);

	}

	public static void endReport() {

		reports.flush();
	}

}
