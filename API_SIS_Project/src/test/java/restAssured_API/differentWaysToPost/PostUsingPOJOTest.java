package restAssured_API.differentWaysToPost;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;
import pojoUtilityForAPI.POJOClass;

public class PostUsingPOJOTest {
	
	@Test
	public void postUsingPOJO() {
		
		Java_Utility jLib=new Java_Utility();
		
		baseURI="http://rmgtestingserver";
		port=8084;

		POJOClass pObj = new POJOClass("SKM_123", "MicroController_"+jLib.randomNumber(), "Created", 14);
		
		given().body(pObj).contentType(ContentType.JSON)
		
		.when().post("/addProject")
		
		.then().assertThat().statusCode(201).contentType(ContentType.JSON)
		.time(Matchers.lessThan(4500l),TimeUnit.MILLISECONDS)
		.log().all();
		
	}
	

}
