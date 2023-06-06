package restAssured_API.crudWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class FetchSingleResourceTest {
	
	@Test
	public void fetchSingleResource() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when().get("/projects/TY_PROJ_7371")
		
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.time(Matchers.lessThan(4000l),TimeUnit.MILLISECONDS)
		.log().all();
		
	}

}
