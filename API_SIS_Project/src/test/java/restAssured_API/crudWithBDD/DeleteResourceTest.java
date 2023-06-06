package restAssured_API.crudWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class DeleteResourceTest {
	
	@Test
	public void deleteResource() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when().delete("/projects/TY_PROJ_7372")
		
		.then().assertThat().statusCode(204).contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
		.log().all();
		
	}

}
