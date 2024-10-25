package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {

	public static Response creatUser(User payload) {

		Response res = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.body(payload)
							.when()
							.post(Routes.post_url);

		return res;

	}

	public static Response getUser(String username) {

		Response res = given()
							.accept(ContentType.JSON)
							.pathParam("username",username)
						.when()
							.get(Routes.get_url);

		return res;

	}

	public static Response updateUser(String username,User payload) {
		Response res = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.pathParam("username",username)
							.body(payload)
						.when()
							.get(Routes.update_url);
		return res;

	}


	public static Response deleteUser(String username) {
		Response res = given()
							.accept(ContentType.JSON)
							.pathParam("username",username)
						.when()
							.delete(Routes.delete_url);
		return res;

	}
}
