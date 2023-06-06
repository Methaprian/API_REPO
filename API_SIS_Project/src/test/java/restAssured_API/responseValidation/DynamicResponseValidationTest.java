package restAssured_API.responseValidation;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicResponseValidationTest {

	@Test
	public void dynamicResponseValidation() {

		String expData = "TY_PROJ_7211";

		baseURI = "http://rmgtestingserver";
		port = 8084;

		boolean flag = false;

		Response resp = when().get("/projects");

		List<String> resp1 = resp.jsonPath().get("projectId");

		for (String string : resp1) {
			if (string.equalsIgnoreCase(expData)) {
				flag = true;
				break;
			}
		}

		Assert.assertTrue(flag);

		System.out.println(" <--------------- Data Verified --------------->");
		resp.then().assertThat().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(4500l),
				TimeUnit.MILLISECONDS);

	}

}
