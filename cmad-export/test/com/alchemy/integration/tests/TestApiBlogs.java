package com.alchemy.integration.tests;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.junit.Test;

public class TestApiBlogs {

	@Test
	public void guestUserCanViewBlogs() {
		given()
			.when()
		.get("http://localhost:8080/cmad-00/api/v1/blog").then().assertThat().statusCode(200);
	}
	
	@Test
	public void loggedInUserCanAddBlog() {
		String js = new JSONObject().
					put("title", "RestAssured").
					put("contents", "Testing and validation of REST services in Java is harder than in dynamic languages such as Ruby and Groovy. REST Assured brings the simplicity of using these languages into the Java domain.").
					put("author", new JSONObject()
                                     .put("email", "rest.assured@gmail.com")
                                     .put("name", "Resting Authors")
                        ).toString();
		given().
		    contentType("application/json").
			body(js).
		when().
			post("http://localhost:8080/cmad-00/api/v1/blog").
		then().
			assertThat().statusCode(201);
	}
}
