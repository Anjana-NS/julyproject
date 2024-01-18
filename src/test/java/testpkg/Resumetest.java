package testpkg;
import java.time.Duration;

import org.testng.annotations.Test;

import basepkg.Resumeclass;
import pagepkg.Resumepage;
public class Resumetest extends Resumeclass {

	@Test
	
	public void test()  throws Exception
	{
		Resumepage ob=new Resumepage(driver);
		driver.manage().window().maximize();
		ob.titleverification();
		ob.cookies();
		ob.logodisplay();
		ob.login();
		ob.account();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ob.mousehover();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ob.scrolldown();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ob.windowhandler();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ob.screenshot();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ob.fileupload();
	
	}
}