package com.bambooapi;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.*;

import java.io.File;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;



public class Bamboorestassured {

/**Non BDD style and Non Static Imports
	1. Request Specification obj
	2. Response obj
	3. ValidateableResponse obj - for then() function
	
	**/
//@Test
public void getBookDetails()
{
	RequestSpecification request = RestAssured.given();
	request.baseUri("https://restful-booker.herokuapp.com/booking");
	Response response = request.get();
	//System.out.println("Response is:"+response.asString());
	ValidatableResponse valResponse = response.then().statusCode(200).body("bookingid[0]", Matchers.equalTo(1437));
	
	System.out.println("Response is:"+valResponse.toString());
	
	QueryableRequestSpecification queryRequest = SpecificationQuerier.query(request);
	System.out.println("Base URI is : "+queryRequest.getBaseUri());

}

//@Test()
public void getBookDetailsBDD() throws JsonMappingException, JsonProcessingException
{
//	RestAssured.given()
//			.when()
//			.get("https://restful-booker.herokuapp.com/booking")
//			.then()
//			.statusCode(200)
//			.body("bookingid[0]", Matchers.equalTo(719))
//			;
	
	String res = RestAssured.given()
			.when()
			.get("https://restful-booker.herokuapp.com/booking")
			.asPrettyString()
			;
	JsonPath jsonRes = JsonPath.from(res);
	
//	System.out.println(jsonRes.getJsonObject("[0].bookingid").toString());
//	System.out.println(jsonRes.getString("bookingid"));
	
	ObjectMapper mapper = new ObjectMapper();
	JsonNode jsonTree = mapper.readTree(res);
	System.out.println(jsonTree.get(0).get("bookingid"));
	System.out.print(jsonTree.size());
}

//@Test()
public void postauth()
{
	String postPayload = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
	given()
	.baseUri("https://restful-booker.herokuapp.com/auth")
	.contentType(ContentType.JSON)
	.body(postPayload)
	.when()
	.post()
	.then()
	.assertThat()
	.statusCode(200)
	.log().all()
	;
}
//@Test()
public void pingCheck()
{
	String baseuri = "https://restful-booker.herokuapp.com/ping";
	
	Response res = given()
	.baseUri(baseuri)
	.when()
	.get()
	;
	long restime = res.getTime();
	ValidatableResponse valRes = res.then().time(Matchers.greaterThan(2000L));
	System.out.println(restime);
	System.out.println(valRes.toString());
	System.out.println(res.getBody().asString().equalsIgnoreCase("Created"));
	

//	.then()
//	.statusCode(201);
}

@Test()
public void postauthFromFile()
{
	File reqPayLoad = new File("src/test/resources/Payloads/AuthPayload.json");
	
	ResponseSpecification spec = RestAssured.expect();
	spec.statusCode(200);
	spec.contentType(ContentType.JSON);
	spec.time(Matchers.greaterThan(2000L));
	
	given()
	.baseUri("https://restful-booker.herokuapp.com/auth")
	.contentType(ContentType.JSON)
	.body(reqPayLoad)
	.when()
	.post()
	.then()
	.assertThat()
	.spec(spec)
	.body("token",Matchers.notNullValue())
	.body("token", Matchers.hasLength(15))
	.log().all()
	;
}
}
