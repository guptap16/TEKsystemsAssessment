package com.teksystem;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Rest.Configuration;

import static io.restassured.RestAssured.*;



/**
 * This is basic RestAssured  based test client application to demonstrate rest implementation call. 
 * Below test case validates the status code.
 * @author Priyanka gupta
 *
 */
public class validateStatusCode {

	String uri=Configuration.getValue("baseURI") + Configuration.getValue("method") + Configuration.getValue("access_key");
	@Test
	public void responseCode() { 
			given()
			.when()
			.get(uri)
			.then()
			.assertThat()
			.statusCode(200)
			.log().all();
	
}}
