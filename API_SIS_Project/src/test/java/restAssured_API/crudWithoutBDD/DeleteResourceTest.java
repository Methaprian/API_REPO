package restAssured_API.crudWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteResourceTest {

	@Test
	public void deleteResource() {
		
		Response resp = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_7360");
		
		System.out.println(resp.getStatusCode());
	}
}
