package ABCDRestAssured.Day1;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/*

  given() -> Content Type, set cookies, add Auth, set header info etc.,

  when() -> Post, Get, Put, Delete

  then() -> validate status code, Extract Response, Extract header cookies & Response body etc.,

 */
public class HTTPRequests {
     @Test(priority = 0)
     void getUsers()
     {
         given()

         .when()
                 .get("https://reqres.in/api/users?page=2")

         .then()
                 .statusCode(200)
                 .body("page",equalTo(2))
                 .log().all();

     }

     int id;

     @Test(priority = 1)
     void createUser()
     {
         HashMap data = new HashMap();
         data.put("name","John");
         data.put("job","Engineer");

         id = given()
                 .contentType("application/json")
                 .body(data)

         .when()
                 .post("https://reqres.in/api/users")
                 .jsonPath().getInt("id");

//          .then()
//                 .statusCode(201)
//                 .body("name",equalTo("John"))
//                 .body("job",equalTo("Engineer"))
//                 .log().all();
         System.out.println("ID : "+id);
     }

     @Test(priority = 2)
    void updateUser()
     {
         HashMap data = new HashMap();
         data.put("name","John Cena");
         data.put("job","Wrestler");

         given()
                 .contentType("application/json")
                 .body(data)

         .when()
                 .put("https://reqres.in/api/users/"+id)


         .then()
                 .statusCode(200)
                 .body("name",equalTo("John Cena"))
                 .body("job",equalTo("Wrestler"))
                 .log().all();
     }

     @Test(priority = 3)
     void deleteUser()
     {
         given()

         .when()
                 .delete("https://reqres.in/api/users/"+id)

         .then()
                 .statusCode(204)
                 .log().all();
     }
}
