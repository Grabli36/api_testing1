package test1;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class MainTest1 {



//GET
    @Test
    public void GetTest() {
        Response response =given().when().get("https://petstore.swagger.io/v2/user/user1")
                .then().statusCode(200).extract().response();
        Long id = response.path("id");
        String username = response.path("username");
        int statusCode = response.statusCode();
        System.out.println(id);
        System.out.println(username);
    }

//GET
    @Test
    public  void GetTestError() {
        Response response =given().when().get("https://petstore.swagger.io/v2/user/user12")
                .then().statusCode(404).extract().response();
        Assertions.assertEquals("error",response.path("type"));



    }
    // POST
    @Test
    public  void PostTest() {
        String body = "{\n" +
                "\"id\": 0, \n" +
                "\"username\": \"string1\",\n"+
                "\"firstName\": \"string\",\n"+
                "\"lastName\": \"string\",\n"+
                "\"email\": \"string\",\n"+
                "\"password\": \"string\",\n"+
                "\"phone\": \"string\",\n"+
                "\"userStatus\": 0 \n"+
                "}";

        Response response = given()
                .header("Content-type", "application/json")
                .body(body)
                .when().post("https://petstore.swagger.io/v2/user")
                .then().statusCode(200).extract().response();
        Assertions.assertEquals("unknown", response.path("type"));
    }
    // DELETE
    @Test
    public void  DeleteTest(){
        Response response =given().when().delete("https://petstore.swagger.io/v2/user/user1")
                .then().statusCode(200).extract().response();
        Assertions.assertEquals("user1",response.path("message"));
    }
    // PUT
    @Test
    public  void PutTest() {
        String body = "{\n" +
                "\"id\": 0, \n" +
                "\"username\": \"stri\",\n" +
                "\"firstName\": \"strg\",\n" +
                "\"lastName\": \"stng\",\n" +
                "\"email\": \"strg\",\n" +
                "\"password\": \"sting\",\n" +
                "\"phone\": \"strg\",\n" +
                "\"userStatus\": 0 \n" +
                "}";

        Response response = given()
                .header("Content-type", "application/json")
                .body(body)
                .when().put("https://petstore.swagger.io/v2/user/user1")
                .then().statusCode(200).extract().response();
        Assertions.assertEquals("unknown", response.path("type"));
    }
}
