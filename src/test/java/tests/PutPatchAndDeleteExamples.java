package tests;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;

public class PutPatchAndDeleteExamples {
	
	@Test
	public void testPut() {
	
		JSONObject request = new JSONObject();
		request.put("name", "Ahmed");
		request.put("job", "QA & Test Automation Engineer");
		
		System.out.println(request);
		
		baseURI = "https://reqres.in/api";
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).log().all();
	}
	
	@Test
	public void testPatch() {
	
		JSONObject request = new JSONObject();
		request.put("name", "Ahmed");
		request.put("job", "QA & Test Automation Engineer");
		
		System.out.println(request);
		
		baseURI = "https://reqres.in";
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).log().all();
	}
	
	@Test
	public void testDelete() {
	
		baseURI = "https://reqres.in";
		when().
			delete("/api/users/2").
		then().
			statusCode(204).log().all();
	}
}





























