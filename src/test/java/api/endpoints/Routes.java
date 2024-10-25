package api.endpoints;

public class Routes {

	/*
	 * https://petstore.swagger.io/
	 * 
	 * create user :- https://petstore.swagger.io/v2/user get user :-
	 * https://petstore.swagger.io/v2/user/{user} update user :-
	 * https://petstore.swagger.io/v2/user/{user} delete user :-
	 * https://petstore.swagger.io/v2/user/{user}
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public static String base_url = "https://petstore.swagger.io/v2";

	// user module

	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String update_url = base_url + "/user/{username}";
	public static String delete_url = base_url + "/user/{username}";

	
	
}
