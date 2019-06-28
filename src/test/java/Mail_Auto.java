import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Mail_Auto {
	String username = "";
	String password = "";
	WebDriver driver;
	@Test
	public void a() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jagdishbhatt\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new RemoteWebDriver(DesiredCapabilities.chrome());
		driver.get("https://mail.google.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("jagdishbhatt");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(2000);
		Assert.assertEquals("jagdishbhatt", username, "Incorrect UserName");
		Assert.assertEquals(password, password, "InCorrect Password");
	}
	@Test
	public void b() throws Exception {
		driver.navigate().back();//driver.navigate().to("https://mail.google.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='identifierId']")).clear();
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(username);
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("Jagdish123");
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(2000);
		Assert.assertEquals(username, username, "Incorrect UserName");
		Assert.assertEquals("Jagdish123", password, "InCorrect Password");
	}
	@Test
	public void c() throws Exception {
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='identifierId']")).clear();
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(username);
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(2000);
		Assert.assertEquals(username, username, "incorrect UserName");
		Assert.assertEquals(password, password, "inCorrect Password");
	}
	@Test
	public void d() {
		List<WebElement> unreademail = driver.findElements(By.cssSelector("span[class=\"zF\"]"));
		System.out.println("Total No. of Unread Mails: " + (unreademail.size()/2));
		Assert.assertEquals((unreademail.size()/2), 3, "incorrect no. of unread mails");
	}
	@Test
	public void e() throws Exception {//*[@id=":38"]
		Thread.sleep(2000);
		Assert.assertEquals( driver.getTitle(), "Inbox (54) - bhattjagdish253@gmail.com - Gmail", "incorrect Title");
	}
	@Test
	public void f() {
		driver.findElement(By.id(":2y")).click();
		List<WebElement> unreademail = driver.findElements(By.className("g2"));
		System.out.println("Total No. of CC: " + (unreademail.size()-1));
		driver.close();
	}
	
}
