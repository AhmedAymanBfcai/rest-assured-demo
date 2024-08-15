package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class TestExamples {

	String url = "https://reqres.in/api/users?page=2";
	@Test
	public void getTest() {
		Response response = get(url);
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("content-type"));
		

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
}