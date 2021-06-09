package DevOps.DevOpsMavenBalaji;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
/**
 * Hello world!
 *
 */
public class App 
{
	public static WebDriver driver;
    public static void main( String[] args )
    {
	 	System.out.println("Started");
    	System.setProperty("webdriver.chrome.driver","/home/edureka/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
       options.addArguments("-headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8000/");
        driver.findElement(By.id("About Us")).click();
        String validateName = driver.findElements(By.id("PID-ab2-pg")).get(0).findElement(By.tagName("b")).getText();
        if (validateName.equals("about")) {
        	System.out.println("Validated the about us page.Found the 'about' text.");
        }
        else {
        	System.out.println("Text failed");
        }
       // driver.close();
        try {
        driver.quit();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
   
}
