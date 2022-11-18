package smokeSuite;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Anesco_LoginTest {
	
	WebDriver driver;
	
	@BeforeMethod
  	public void setUp() throws Exception{
		WebDriverManager.chromedriver().browserVersion("107.0.5304.107").setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://ecoappdev.anesco.co.uk/ ");
	    driver.manage().window().maximize();
		Reporter.log("The application launched");
		
	}

  @Test(priority=0)
  public void HomepageTitle()  throws Exception {	      
     System.out.println("The title verification for home page started"); 
      String testTitle = "Login | ECO";
      String originalTitle = driver.getTitle();
      Assert.assertEquals(originalTitle, testTitle);
      String expectedHeading="Welcome to ECO Control App";
    //Storing the text of the heading in a string
      String heading=driver.findElement(By.xpath("//h4[contains(text(), 'Welcome to ECO Control App')]")).getText();
      if(expectedHeading.equalsIgnoreCase(heading))
        	Reporter.log("The Assert verification Pass for Title");
  	else
        	Reporter.log("The Assert verification failed");
	  
  }
  
  @Test(priority=1)
  public void verifyLogo()
  {
  WebElement Logo = driver.findElement(By.xpath("//*[name()='svg' and @id='Layer_1']"));
  Assert.assertEquals(true, Logo.isDisplayed());
  Reporter.log("logo is displayed – Assert passed");
  } 
@Test(priority=2)
public void VerifyVersion()
{
	
    WebElement App_Version=driver.findElement(By.xpath("//*[text()[contains(., 'Version')]]"));
    Assert.assertNotNull(App_Version);
    String Actual_Ver=App_Version.getText();
    Reporter.log("The current deployed build version is " +Actual_Ver);
        
}
@Test(priority=3)
public void Login() throws InterruptedException
{
	Reporter.log("Clicking on Sign in with Azure to login");
	WebElement m= driver.findElement(By.xpath("//button[contains(text(),'Sign in with Azure')]"));
	m.click();
	//Switch to Child window using get window handlers
	Thread.sleep(2000);
	Set<String> handler = driver.getWindowHandles();
	Iterator<String> It = handler.iterator();
	String ParentWindowID = It.next();
	System.out.println("Parent window Id IS" + ParentWindowID);
	String ChildwindowID = It.next();
	Thread.sleep(2000);
	System.out.println("Child window Id IS" + ChildwindowID);
	driver.switchTo().window(ChildwindowID);
	//Enter User name and Password to login
	WebElement n = driver.findElement(By.xpath("//input[@name='loginfmt']"));
	n.sendKeys("meshnet.azuredev@anesco.com");
	Reporter.log("User Enters the Username");
	Thread.sleep(2000);
	WebElement o=driver.findElement(By.xpath("//input[@type='submit']"));
	Thread.sleep(2000);
	o.click();
	System.out.println("User clicks on button to proceed with Password");
		Thread.sleep(2000);	
	WebElement p = driver.findElement(By.xpath("//input[@type='password']"));
	p.sendKeys("Serengeti238!");
	Reporter.log("User Enters the Password");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Reporter.log("The title of the current Page is" + driver.getTitle());
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Reporter.log("user logged in successfuly" +driver.getTitle());
}

@AfterMethod
public void ExistBrowser()
{
	driver.close();
	driver.quit();
	Reporter.log("The Driver session is Closed completely");
}

  
}
