package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class TestExamples {

	String url = "https://reqres.in/api/users?page=2";
	@Test
	public void firstTest() {
		Response response = get(url);
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("content-type"));
		

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void secondTest() {
		// requres.in is a public API
		baseURI = "https://reqres.in/api";
		given().
		  get("/users?page=2").
		then().
			statusCode(200).
			body("data[1].id", equalTo(8));
	}
}