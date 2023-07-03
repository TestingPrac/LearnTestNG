package ABCDRestAssured.Day2.DifferentWaysToCreatePostRequestBody;

import org.testng.annotations.Test;

import java.util.HashMap;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class PostRequestUsingHashMap {


    @Test(priority = 1)
    void createUser()
    {
        HashMap data = new HashMap();
        data.put("name","John");
        data.put("job","Engineer");

        given()
                .contentType("application/json")
                .body(data)

        .when()
                .post("https://reqres.in/api/users")


        .then()
                 .statusCode(201)
                 .body("name",equalTo("John"))
                 .body("job",equalTo("Engineer"))
                 .log().all();

    }


}
