package restAssured_API.dataProviders;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;
import pojoUtilityForAPI.POJOClass;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class DataProvidersTest {

	@Test(dataProvider = "testData")
	public void dataProvider(String createdBy, String projectName, String status, int teamSize) {

		Java_Utility jLib = new Java_Utility();

		baseURI = "http://rmgtestingserver";
		port = 8084;

		POJOClass pLib = new POJOClass(createdBy, projectName + jLib.randomNumber(), status, teamSize);

		given().body(pLib).contentType(ContentType.JSON)

				.when().post("/addProject")

				.then().assertThat().statusCode(201).contentType(ContentType.JSON)
				.time(Matchers.lessThan(4500l), TimeUnit.MILLISECONDS).log().all();
	}

	@DataProvider(name = "testData")
	public Object[][] testDataBlock() {

		Object[][] data = new Object[3][4];

		data[0][0] = "SKM_1";
		data[0][1] = "MICROMAX_";
		data[0][2] = "Created";
		data[0][3] = 18;

		data[1][0] = "SKM_2";
		data[1][1] = "MOTO_";
		data[1][2] = "OnGoing";
		data[1][3] = 9;

		data[2][0] = "SKM_3";
		data[2][1] = "ROYAL_ENFIELD_";
		data[2][2] = "Created";
		data[2][3] = 10;
		return data;
	}

}
