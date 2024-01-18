package pagepkg;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import basepkg.Resumeclass;
public class Resumepage extends Resumeclass {

By cookies=By.xpath("//*[@id=\"accept_all_btn\"]");
By resumebuilder=By.xpath("//*[@id=\"navbarCollapse\"]/ul[1]/li[2]/div/div/div[1]/a[1]/div[2]/div[1]");
By airesumewriter=By.xpath("//*[@id=\"navbarCollapse\"]/ul[1]/li[2]/div/div/div[1]/a[2]/div[2]/div[1]");
By resumechecker=By.xpath("//*[@id=\"navbarCollapse\"]/ul[1]/li[2]/div/div/div[1]/a[3]/div[2]/div[1]");
By resumetemplate=By.xpath("//*[@id=\"navbarCollapse\"]/ul[1]/li[2]/div/div/div[1]/a[4]/div[2]/div[1]");
By logo=By.xpath("/html/body/nav/div/a/img");
By login=By.xpath("//*[@id=\"navbarCollapse\"]/ul[2]/li[1]/a");
By email=By.xpath("//*[@id=\"email\"]");
By pswd=By.xpath("//*[@id=\"password\"]");
By resumelog=By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[2]/div/div/form/button");
By createnew=By.xpath("//*[@id=\"paginator-scroll-element-id\"]/div[1]/div[2]/button");
By resume=By.xpath("//*[@id=\"paginator-scroll-element-id\"]/div[1]/div[2]/div/a[1]");
By selecttemp=By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/div[2]/div/div/div[14]/div/div/div[1]/button");
By logout=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/button[2]");

public  Resumepage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
}
 public void cookies() {
	WebElement l=driver.findElement(cookies);
	boolean b=l.isDisplayed();
	if(b)
	{
		System.out.println("cookies is Displayed");
	}
	else
	{
		System.out.println("cookies is not Displayed");
	}
	driver.findElement(cookies).click();
	}	 
 public void titleverification()
 {
 	String title=driver.getTitle();
 	String a="Kickresume | Best Online Resume & Cover Letter Builder";
 	if(title.equals(a)) {
 System.out.println("pass titleverification");
 }
 else {
 	System.out.println("fail titleverification");
     }
 }
 public void logodisplay() {
	 WebElement lg=driver.findElement(logo);
	 Boolean b=lg.isDisplayed();
	 if(b) {
	 System.out.println("logo displays");
 }
 else {
 	System.out.println("logo not displays");
     }
 }
	 
  public void login()throws Exception {
		driver.findElement(login).click();
		  
		 	 File f=new File("C:\\Users\\anjana\\Desktop\\demo resume.xlsx");
	    	 FileInputStream fi=new FileInputStream(f);
	    	 XSSFWorkbook wb=new  XSSFWorkbook(fi);
	    	 XSSFSheet sh=wb.getSheet("Sheet1");
	    	 System.out.println(sh.getLastRowNum());
	    	 
	    	 for(int i=1;i<=sh.getLastRowNum();i++)
	    	 {
	    		 String username =sh.getRow(i).getCell(0).getStringCellValue();
	 			System.out.println("Email="+username);
	 		String pswd=sh.getRow(i).getCell(1).getStringCellValue();
	 		System.out.println("pswd="+pswd);
	
	 	driver.findElement(By.id("email")).clear();
	 	driver.findElement(By.id("email")).sendKeys(username);
	 	driver.findElement(By.id("password")).clear();
	 	driver.findElement(By.id("password")).sendKeys(pswd);
	 	driver.findElement(resumelog).click();
	 	driver.findElement(createnew).click();
	 	driver.findElement(resume).click();
	 	}
	}
	public void mousehover(){
		WebElement a=driver.findElement(resume);
		Actions act=new Actions(driver);
		act.moveToElement(a).perform();
		driver.findElement(resumebuilder).click();
		driver.findElement(airesumewriter).click();
		driver.findElement(resumechecker).click();
		driver.findElement(resumetemplate).click();
		
	}
	 
public void windowhandler()
{
	driver.get("https://www.kickresume.com/dashboard/resumes/");
	String parentwindow=driver.getWindowHandle();
	System.out.println("parent window title"+driver.getTitle());
	driver.findElement(selecttemp).click();
	
	String allWindowHandle=driver.getWindowHandle();
	
	Set<String> allWindow = driver.getWindowHandles();
	
	for(String handle : allWindow)
	{
	if(!handle.equalsIgnoreCase(parentwindow))	{
		driver.switchTo().window(handle);
		driver.close();
		
	}
		driver.switchTo().window(parentwindow);
	}
}
public void scrolldown(){
	 
	 JavascriptExecutor js = (JavascriptExecutor) driver;        		
       js.executeScript("window.scrollBy(0,1000)", "");	
}

	public void screenshot() throws Exception{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File("./Screenshot/resume.png"));
		}
	
	public void account() {
		driver.findElement(logout).click();
	
	}
	public void fileupload() throws Exception {
		    driver.findElement(By.xpath("/html/body/main/div[1]/div/div/div[1]/div/button")).click(); 
			fileUpload("C:\\Users\\anjana\\Downloads\\resume.docx");
		}
	 

		public void fileUpload(String p) throws Exception {
			StringSelection strSelection=new StringSelection(p);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection,null);
			
			Robot robot=new Robot();
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
	}
		 
	

}




