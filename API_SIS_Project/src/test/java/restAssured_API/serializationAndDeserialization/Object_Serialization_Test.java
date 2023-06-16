package restAssured_API.serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;


import pojoUtilityForAPI.Details_POJO;
import pojoUtilityForAPI.POJO_API_Object;

public class Object_Serialization_Test {
	
	@Test
	public void objectSerialize() throws JsonGenerationException, JsonMappingException, IOException {
	
		long[] pNo= {12345678l,98765432l};
		
		Details_POJO details = new Details_POJO("SE", pNo);
		
		POJO_API_Object pObj = new POJO_API_Object("Methaprian", details);
		
		ObjectMapper oMap=new ObjectMapper();
		oMap.writeValue(new File("./objectSerialize.json"), pObj);
	}
}