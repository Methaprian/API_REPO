package restAssured_API.differentWaysToPost;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostUsingJSONFileTest {
	
	@Test
	public void postUsingJSONFile() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		File file=new File("./src/test/resources/JSONFile.json");
		
		given().body(file).contentType(ContentType.JSON)
		
		.when().post("/addProject")
		
		.then().assertThat().statusCode(201).contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
		.log().all();
	}

}
