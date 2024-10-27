package Tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import capabilities.capables;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class allTESTSlevel extends capables {

	AndroidDriver<AndroidElement> driver;
	ExtentReports reports;
	ExtentTest test;
	String expNAME = "Hirak Goswami";
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		
		// Initializing all report's location and test's name
		
		reports = new ExtentReports("C:\\Users\\User\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\RentOK\\CWreport.html");
		test = reports.startTest("RentOkTests");
		
		// calling the capabilities from cap method from capabilities class
		
		driver = cap();
		
		// adding implicit wait
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void Login() {
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.Button\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_button\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(13)")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(3)")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(0)")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)")).click();
		String name = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Hirak Goswami\")")).getText();
		Assert.assertEquals(name, expNAME);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Logout\"))"));
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(34)")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(0)")).click();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}
	
}
