package genericUtility;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecBuilderWithBaseClass extends BaseClass {

	public RequestSpecification requestSpec;
	public ResponseSpecification responseSpec;
	@BeforeSuite
	public void configBeforeSuite() {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri(IPathConstants.baseURI);
		builder.setPort(IPathConstants.port);
		builder.setContentType(ContentType.JSON);
		
		requestSpec = builder.build();
	}
	
	@AfterSuite
	public void configAfterSuite() {
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		builder.expectContentType(ContentType.JSON);
		builder.expectResponseTime(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS);
		responseSpec = builder.build();
	}
}
