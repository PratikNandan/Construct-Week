package Construct_Week;

import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import io.restassured.RestAssured;

public class Task {
	String url = "https://dummy.restapiexample.com/public/api/v1";
	
	@Test
	public void get_all() {
		RestAssured.baseURI=url;
		given().get("/employees").then().assertThat().statusCode(either(is(200)).or(is(429))).log().all();
		
		
		//statusCode(200).log().all();
		
		
	}
	@Test
	public void get_one() {
		RestAssured.baseURI=url;
		given().get("/employee/1").then().assertThat().statusCode(either(is(200)).or(is(429))).log().all();
		
		
	}
	@Test
	public void create() {
		JSONObject json = new JSONObject();
		json.put("name","test");
		json.put("salary","123");
		json.put("age","23");
		RestAssured.baseURI=url;
		given()
		.header("Accept","application/json")
		.contentType(ContentType.JSON).body(json.toJSONString()).when().post("/create").then()
		.assertThat().statusCode(either(is(200)).or(is(429))).log().all();
		
		
	}
	
	
	@Test
	public void update() {
		JSONObject json = new JSONObject();
		json.put("name","test");
		json.put("salary","123");
		json.put("age","23");
		RestAssured.baseURI=url;
		given()
		.header("Accept","application/json")
		.contentType(ContentType.JSON).body(json.toJSONString()).when().put("/update/21").then()
		.assertThat().statusCode(either(is(200)).or(is(429))).log().all();
		
		
	}
	
	@Test
	public void delete() {
		RestAssured.baseURI=url;
		given().delete("/delete/2").then().assertThat().statusCode(either(is(200)).or(is(429))).log().all();
		
		
	}

	
	
	
	
	
	
	
	

	
//dnt
}
