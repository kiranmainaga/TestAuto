package smokeSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetup {
	
	public void setUp(){
		WebDriver driver = null;
		WebDriverManager.chromedriver().browserVersion("107.0.5304.107").setup();
		ChromeOptions options = new ChromeOptions();
		 driver = new ChromeDriver();
		options.addArguments("start-maximized"); 
		options.addArguments("enable-automation"); 
		options.addArguments("--no-sandbox"); 
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation"); 
		options.addArguments("--disable-gpu"); 
		System.out.println("Opening URL"); 
	    driver.get("https://ecoappdev.anesco.co.uk/ ");
	    driver.manage().window().maximize();
		
	}

}
