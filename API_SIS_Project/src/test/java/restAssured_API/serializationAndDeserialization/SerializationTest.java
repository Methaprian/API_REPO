package restAssured_API.serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoUtilityForAPI.POJO_Serialize;

public class SerializationTest {

	@Test
	public void serialization() throws JsonGenerationException, JsonMappingException, IOException {
		
		POJO_Serialize pObj = new POJO_Serialize("Methaprian S.K", "SDET", 1234567890l);
		
		ObjectMapper oMap=new ObjectMapper();
		oMap.writeValue(new File("./serial.json"), pObj);
	}
}
