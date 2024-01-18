package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Resumeclass {
	public static WebDriver driver;
	 
	@BeforeTest
	public void setUp()
	{
	driver=new ChromeDriver();
	driver.get("https://www.kickresume.com/en/ai-resume-rewrite/");
	driver.manage().window().maximize();
	 
  }

}
