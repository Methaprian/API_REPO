package restAssured_API.crudWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class FetchAllResourcesTest {
	
	@Test
	public void fetchAllResources() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when().get("/projects")
		
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
		.log().all();
		
	}

}
