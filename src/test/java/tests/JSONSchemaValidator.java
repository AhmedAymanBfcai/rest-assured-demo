package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath; // If you did not use the static keyword, You have to use JsonSchemaValidator before matchesJSonFunc

import org.testng.annotations.Test;

public class JSONSchemaValidator {
	
	@Test
	public void testSchema() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
		    assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
			statusCode(200);
	}
}



























