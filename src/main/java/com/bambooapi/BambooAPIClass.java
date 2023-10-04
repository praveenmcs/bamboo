package com.bambooapi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;

public class BambooAPIClass {

	Response APIresponse;
	public void sendGETRequest(String url)
	{
		
		APIresponse = given()
		.when()
		.get(url)
		.then()
		.extract().response()
		;
	}

}
