package ABCDRestAssured.Day2.DifferentWaysToCreatePostRequestBody;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostRequestUsingOrgJson {

    @Test(priority = 1)
    void createUser()
    {
        JSONObject data = new JSONObject();

        data.put("name","John");
        data.put("job","Engineer");

        given()
                .contentType("application/json")
                .body(data.toString())

        .when()
                .post("https://reqres.in/api/users")


        .then()
                 .statusCode(201)
                 .body("name",equalTo("John"))
                 .body("job",equalTo("Engineer"))
                 .log().all();

    }
}
