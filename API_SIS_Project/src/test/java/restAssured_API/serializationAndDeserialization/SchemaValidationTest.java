package restAssured_API.serializationAndDeserialization;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

import java.io.File; 


public class SchemaValidationTest {
	
	@Test
	public void schemaValid() {
		
		File file=new File("./schemaValid.json");
		when().get("https://reqres.in/api/users?page=2")
		.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));
//		.log().all();
	}
}