package restAssured_API.serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoUtilityForAPI.POJO_API_Array;

public class Array_Serialization_Test {
	
	@Test
	public void arraySerialize() throws JsonGenerationException, JsonMappingException, IOException {
		
		long[] pNo= {1234567890l,9876543210l};
		POJO_API_Array pObj=new POJO_API_Array("Methaprian S.K", "SDET", pNo);
		
		ObjectMapper oMap=new ObjectMapper();
		oMap.writeValue(new File("./array__serialize.json"), pObj);
		
	}

}
