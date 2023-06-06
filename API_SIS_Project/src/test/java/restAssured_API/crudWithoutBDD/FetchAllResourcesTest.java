package restAssured_API.crudWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchAllResourcesTest {
	@Test
	public void fetchAllResources() {
		
		Response resp = RestAssured.get("http://rmgtestingserver:8084/projects");
		
		System.out.println(resp.prettyPeek());
	}

}
