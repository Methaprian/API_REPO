package restAssured_API.serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoUtilityForAPI.POJO_Serialize;

public class DeserializationTest {
	
	@Test
	public void deserialize() throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper oMap=new ObjectMapper();
		POJO_Serialize desel = oMap.readValue(new File("./serial.json"), POJO_Serialize.class);
		System.out.println(desel.geteName());
		System.out.println(desel.getDesignation());
		System.out.println(desel.getpNo());
	}

}
