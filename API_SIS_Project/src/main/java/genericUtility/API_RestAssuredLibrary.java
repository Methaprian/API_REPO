package genericUtility;

import io.restassured.response.Response;

public class API_RestAssuredLibrary {
	
	public String getJSONData(Response response,String path) {
		String jsonData = response.jsonPath().get(path);
		return jsonData;
	}
}