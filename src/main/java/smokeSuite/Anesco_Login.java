package smokeSuite;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Anesco_Login {

			
			public static void main(String[] args) throws InterruptedException {
				// WebDriver property
				System.setProperty("webdriver.chrome.driver", "C:\\Automation_Framework\\Drivers\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				//Get application URL
				driver.get("https://ecoappdev.anesco.co.uk/ ");
				driver.manage().window().maximize();
				System.out.println("The Website title is  " + driver.getTitle());
				WebElement a=driver.findElement(By.xpath("//h4[contains(text(), 'Welcome to ECO Control App')]"));
				System.out.println("The header text"+a.getText());
				Point b=driver.findElement(By.xpath("//*[name()='svg' and @id='Layer_1']")).getLocation();
				System.out.println("The location of the Log is " +b);
				String c=driver.findElement(By.xpath("//*[text()[contains(., 'Version')]]")).getText();
				System.out.println("The version of the currently deployed software is" +c);
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
				WebElement o=driver.findElement(By.xpath("//input[@type='submit']"));
				o.click();
				Thread.sleep(2000);
				WebElement p = driver.findElement(By.xpath("//input[@type='password']"));
				p.sendKeys("Serengeti238!");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				System.out.println("The title of the current Page is" + driver.getTitle());
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				System.out.println("user logged in successfuly" +driver.getTitle());
				Thread.sleep(5000);
				//WebElement q=driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-w5qhhs' and @type='button'] "));
				//q.click();
				//driver.findElement(By.xpath("//div[@class='MuiBox-root css-vxcmzt']/button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-w5qhhs']")).click();
				//Thread.sleep(2000);
				//driver.findElement(By.xpath("//li[@id='Logout']")).click();
				//driver.switchTo().window(ParentWindowID);
				//driver.findElement(By.xpath("//div/small")).click();
				//Thread.sleep(2000);
				//System.out.println("Parent Window Title is"+driver.getTitle());
				driver.close();
				driver.quit();
				
				

			}

		


	}


