package api.testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserTests {

	Faker faker;
	User userPayeload;
	public Logger logger;
	
	@BeforeClass
	public void generateTestData() {
		
		faker=new Faker();
		userPayeload=new User();
		userPayeload.setId(faker.idNumber().hashCode());
		userPayeload.setUsername(faker.name().username());
		userPayeload.setFirstName(faker.name().firstName());
		userPayeload.setLastName(faker.name().lastName());
		userPayeload.setEmail(faker.internet().safeEmailAddress());
		userPayeload.setPassword(faker.internet().password(5,10));
		userPayeload.setPhone(faker.phoneNumber().cellPhone());
		
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority = 1)
	public void testCreateUser() {
		
		logger.info("****************inside testCreateUser ******************");
		
		Response res=UserEndPoints.creatUser(userPayeload);
		
		System.out.println("inside create user ");
		System.out.println();
		System.out.println(res);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("****************user created  ******************");
	}
	
	@Test(priority = 2)
	public void testGetUser() {
		
		logger.info("****************inside testGetUser  ******************");
		System.out.println("inside get User ");
		System.out.println();
		Response res=UserEndPoints.getUser(this.userPayeload.getUsername() );
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("****************user get successfully  ******************");
	}
	

	@Test(priority = 3)
	public void testUpdateUser() {
		logger.info("****************inside testUpdateUser ******************");
		userPayeload.setFirstName(faker.name().firstName());
		Response res=UserEndPoints.updateUser(this.userPayeload.getUsername(),userPayeload );
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.info("****************user updated successfully  testUpdateUser ******************");
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		logger.info("****************inside testDeleteUser() ******************");
		
		Response res=UserEndPoints.deleteUser(this.userPayeload.getUsername() );
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.info("****************user deleted  successfully() ******************");
	}
	
}
