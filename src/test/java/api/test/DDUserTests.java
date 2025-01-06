package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDUserTests {
//	Faker faker;
 User userPayload;

//@BeforeClass
//public void setupData() {
//	faker=new Faker();
//	userPayload=new User();
//	
//	userPayload.setId(faker.idNumber().hashCode());		
//	userPayload.setFirstName(faker.name().firstName());
//	userPayload.setLastName(faker.name().lastName());
//	userPayload.setEmail(faker.internet().emailAddress());
//	userPayload.setPassword(faker.internet().password());
//	userPayload.setPhone(faker.phoneNumber().cellPhone());					
//}

@Test(priority = 1, dataProvider = "getAllData", dataProviderClass = DataProviders.class)
public void testPostUser(String id, String username, String firstName, String lastName, String email, String password, String phone ) {
	
	userPayload=new User();
	
	userPayload.setId(Integer.parseInt(id));	
	userPayload.setFirstName(username);
	userPayload.setFirstName(firstName);
	userPayload.setLastName(lastName);
	userPayload.setEmail(email);
	userPayload.setPassword(password);
	userPayload.setPhone(phone);	
	
	
	System.out.println(userPayload.getId());
	System.out.println(userPayload.getUsername());
	System.out.println(userPayload.getFirstName());
	
	Response response=UserEndPoints.createUser(userPayload);
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(), 200);		
	}


@Test(priority = 2,dataProvider = "getUserNames", dataProviderClass = DataProviders.class)
public void testDeleteUserByName(String userName) {
	
	Response response=UserEndPoints.deleteUser(userName);
	Assert.assertEquals(response.getStatusCode(), 200);	
	
	}
}
