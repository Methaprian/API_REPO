package genericUtility;

import io.restassured.response.Response;

public class RestAssuredLibrary {

	
	public String readJSONData(Response response, String path) {
		String data = response.jsonPath().get(path);
		return data;
	}
}
