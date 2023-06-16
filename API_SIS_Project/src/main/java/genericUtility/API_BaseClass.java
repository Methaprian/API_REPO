package genericUtility;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class API_BaseClass {
	
	public API_DataBase_Library dLib=new API_DataBase_Library();
	public Java_Utility jLib= new Java_Utility();
	public API_RestAssuredLibrary rLib=new API_RestAssuredLibrary();
	public RequestSpecification reqst;
	public ResponseSpecification resp;
	
	@BeforeSuite
	public void bsConfig() throws Throwable {
		
		dLib.connectToDB();
		
		reqst=new RequestSpecBuilder().setBaseUri("http://rmgtestingserver").setPort(8084)
		.setContentType(ContentType.JSON).build();
		
		resp=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	}
	
	@AfterSuite
	public void asConfig() throws SQLException {
		dLib.closeDB();
	}

}
