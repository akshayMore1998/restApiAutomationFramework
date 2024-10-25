package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestsDDT {

	
	
	@Test(priority = 1,dataProvider = "Data",dataProviderClass = DataProviders.class)
	public void testCreateUser(String userId,String userName,String fName,String lName,String email,String pwd,String no) {
		
		
			User userPayeload=new User();
		userPayeload.setId(Integer.parseInt(userId));
		userPayeload.setUsername(userName);
		userPayeload.setFirstName(fName);
		userPayeload.setLastName(lName);
		userPayeload.setEmail(email);
		userPayeload.setPassword(pwd);
		userPayeload.setPhone(no);
		
		Response res=UserEndPoints.creatUser(userPayeload);
		
		System.out.println("inside create user ");
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	
	@Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username) {
		
		if(username==null) {
			
			System.out.println("can notpass null valuess**************");
		}else
		{
			Response res=UserEndPoints.deleteUser(username );
			res.then().log().all();
			Assert.assertEquals(res.getStatusCode(), 200);
		}
		
	}
}
