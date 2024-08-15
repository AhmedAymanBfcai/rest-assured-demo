package tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class GetAndPostExamples {

	@Test
	public void testGet() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("George", "Rachel"));
	}
	
	@Test
	public void testPost() {
		
		// We can also use map instead of request.put
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Ahmed");
//		map.put("job", "QA & Test Automation Engineer");
//		
		JSONObject request = new JSONObject();
		request.put("name","Ahmed");
		request.put("job", "QA & Test Automation Engineer");
		
		System.out.println(request);
		
		baseURI = "https://reqres.in/api";
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(request.toJSONString()). // Telling the server that I am accepting JSON Response
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
	}
}





























