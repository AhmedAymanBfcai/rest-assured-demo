package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;


public class SoapXMLRequest {
	
	@Test
	public void validateSoapXML() throws IOException {
		baseURI = "http://www.dneonline.com";
		File file = new File("F:\\Development\\java-playground\\RestAssuredDemo\\SoapRequest\\soapBody.xml");
		
		if (file.exists()) System.out.println(" >> File Exists..");

		FileInputStream myFile = new FileInputStream(file);
		String requestBody = IOUtils.toString(myFile, "UTF-8");
		
		given().
			contentType("text/xml"). 
			accept(ContentType.XML). 
			body(requestBody). 
		when().	
			post("/calculator.asmx").
		then().
			statusCode(200).
		and(). 
			body("//*:AddResult.text()", equalTo("5"));
	}
}

