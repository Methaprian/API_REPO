package restAssured_API.endToEndScenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.API_IConstants;
import genericUtility.Java_Utility;

public class API_3Layer_EndToEnd_Test {

	@Test
	public void endToEnd_3Layer_Validation() {
		Java_Utility jLib = new Java_Utility();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("http://rmgtestingserver:8084");
		Assert.assertEquals(driver.getTitle(), "React App");
		
		driver.findElement(By.id("usernmae")).sendKeys(API_IConstants.appUserName);
		driver.findElement(By.id("inputPassword")).sendKeys(API_IConstants.appPassword);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys("MICROMAX__"+jLib.randomNumber());
		driver.findElement(By.name("createdBy")).sendKeys("SKM_1234");
		
		Select select = new Select(driver.findElement(By.name("status")));
		select.selectByVisibleText("Created");
		
		
		
		
		
	}
}
