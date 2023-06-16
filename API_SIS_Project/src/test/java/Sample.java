import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class Sample {

	@Test
	public void postScenarioTest() {
		
		Response response = given().baseUri(baseURI).contentType(" ")
		
							.when().get("/endpoint");
		
		JsonPath jsonResp = response.jsonPath().get("name");
		
		String expResp = "Joe";
		
//		ObjectMapper oMap=new ObjectMapper();
//		pojoClass resp = oMap.readValue(new File("./mapperSample.json"), pojoClass.class);
		
//		System.out.println(resp.get("name"));
		
		
		
//		.then().assertThat().statusCode(201).log().all();
		
//		{“name”:”Joe”,”Lname”:”smith”,”empcode”:200012}
	}
	
	@Test
	public void validateDynamicTable() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("URL");
		Assert.assertEquals("ActTitle", "ExpTitle");
		
		String expDataToSearch = "<ExpData>";
		
		List<WebElement> webTableList = driver.findElements(By.xpath("Dynamic XPath"));
		for (WebElement webTableEle : webTableList) {
			//Assertion
			Assert.assertEquals(webTableEle.getText(), expDataToSearch);
			System.out.println("Element to be searched Asserted");
		}
		driver.quit();
	}
	
	@Test
	public void flipkartValidate() {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.name("q")).sendKeys("iphone");
		
		String eleToClick = "iphone 14";
		
		List<WebElement> autoList = driver.findElements(By.xpath("//ul[contains(@class,'col-12-12')]"));
		
		for (WebElement listEle : autoList) {
			String listContent = listEle.getText();
			if (eleToClick.equals(listContent)) {
				listEle.click();
			}
		}
	}
}
