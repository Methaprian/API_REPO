package restAssured_API.serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoUtilityForAPI.POJO_API_Array;

public class Array_Deserialization_Test {

	@Test
	public void arrayDeserialize() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper oMap=new ObjectMapper();
		POJO_API_Array data = oMap.readValue(new File("./array__serialize.json"), POJO_API_Array.class);
		System.out.println(data.geteName());
		System.out.println(data.getDesignation());
		System.out.println(data.getpNo()[0]);
		System.out.println(data.getpNo()[1]);
		
	}
}
