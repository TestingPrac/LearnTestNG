package ABCDRestAussured.Day2.DifferentWaysToCreatePostRequestBody;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostRequestUsingPOJOclass {



    @Test(priority = 1)
    void createUser()
    {
        POJO_PostRequestSupportingFile data = new POJO_PostRequestSupportingFile();

        data.setName("John");
        data.setJob("Engineer");

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
