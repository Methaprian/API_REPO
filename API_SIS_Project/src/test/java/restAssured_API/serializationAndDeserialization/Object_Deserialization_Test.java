package restAssured_API.serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoUtilityForAPI.POJO_API_Object;

public class Object_Deserialization_Test {
	
	@Test
	public void objectDeserialize() throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper oMap=new ObjectMapper();
		
		POJO_API_Object data = oMap.readValue(new File("./objectSerialize.json"), POJO_API_Object.class);
		
		System.out.println(data.geteName());
		System.out.println(data.getDetail().getDesignation());
		System.out.println(data.getDetail().getpNo()[1]);
	}
}