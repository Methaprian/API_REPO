package restAssured_API.crudWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchSingleResource {
	
	@Test
	public void fetchSingleResource() {
		
		Response resp = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_7360");
		
		System.out.println(resp.prettyPeek());
		
	}

}
