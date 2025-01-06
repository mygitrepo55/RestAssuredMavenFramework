package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPoints {
	
	private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("routes");	 

	
	public static Response createUser(User payload) {
		
		String post_url=resourceBundle.getString("post_url");
		
		//String post_url="https://petstore.swagger.io/v2/user";
		//System.out.println("=======>"+post_url);
		
		Response response=given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
				.when()
					.post(post_url);	
		
		return response;				
	}
	
	public static Response deleteUser(String userName) {
		
		String delete_url=resourceBundle.getString("delete_url");
	
		Response response= given()
					.pathParam("username", userName)
				.when()
				   .delete(delete_url);
				
		return response;		
	}
	

}
