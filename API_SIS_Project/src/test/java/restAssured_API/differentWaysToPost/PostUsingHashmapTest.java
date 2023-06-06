package restAssured_API.differentWaysToPost;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;

public class PostUsingHashmapTest {
	
	@Test
	public void postUsingHashmap() {
		
		Java_Utility jLib=new Java_Utility();
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		HashMap hm= new HashMap();
		hm.put("createdBy","SKM_101");
		hm.put("projectName","MicroController_"+jLib.randomNumber());
		hm.put("status","Created");
		hm.put("teamSize",20);
		
		given().body(hm).contentType(ContentType.JSON)
		
		.when().post("/addProject")
		
		.then().assertThat().statusCode(201).contentType(ContentType.JSON)
		.time(Matchers.lessThan(2500l),TimeUnit.MILLISECONDS)
		.log().all();
		
	}

}
