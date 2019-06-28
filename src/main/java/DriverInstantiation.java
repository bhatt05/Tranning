import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class DriverInstantiation {
	String username = "bhattjagdish253";
	String password = "12345";
	static WebDriver driver;
	@Test
	public void a() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jagdishbhatt\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.google.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(username);
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(2000);
		List<WebElement> unreademail = driver.findElements(By.cssSelector("span[class=\"zF\"]"));
		System.out.println("Total No. of Unread Mails: " + (unreademail.size()/2));
		driver.close();
	}

}
