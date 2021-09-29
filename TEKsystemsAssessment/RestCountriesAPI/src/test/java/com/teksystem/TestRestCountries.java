package com.teksystem;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import Rest.Configuration;
import files.ReUsableMethods;

/**
 * This is basic RestAssured  based test client application to demonstrate rest implementation call. 
 * The same can be done using Spring or Apache HTTP Client module.
 * @author Priyanka gupta
 *
 */

public class TestRestCountries {

	
	@Test
	public void testCase_01() {
		
	
	RequestSpecification req = new RequestSpecBuilder()
			.setBaseUri(Configuration.getValue("baseURI"))
			.addQueryParam("access_key", Configuration.getValue("access_key"))
			.setContentType(ContentType.JSON)
			.build();
	
	
	RequestSpecification res = given()
									.spec(req);
			    
			     
	ResponseSpecification resSpec= new ResponseSpecBuilder()
										.expectStatusCode(200)
										.expectContentType(ContentType.JSON)
										.build();
	
	 
	
	Response responseKabul= res
			.when()
			.get("capital/Kabul")
			.then()
			.spec(resSpec)
			.extract().response();
	
	String responseStringKabul = responseKabul.asString();
	System.out.print(responseStringKabul);
	
	JsonPath js1= ReUsableMethods.rawToJson(responseStringKabul);
	
	
	/*  Validate that response has capital as Kabul */
	
	String actualCapital = js1.getString("capital");
	System.out.print(actualCapital);
	Assert.assertEquals(actualCapital, "[Kabul]");
	
	
	/*  Verify that name of country when capital is Kabul */ 
	
	String actualName = js1.getString("name");
	System.out.print(actualName);
	Assert.assertEquals(actualName, "[Afghanistan]");
	
	
}}
