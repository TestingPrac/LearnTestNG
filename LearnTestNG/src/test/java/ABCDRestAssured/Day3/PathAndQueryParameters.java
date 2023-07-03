package ABCDRestAssured.Day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathAndQueryParameters {

    @Test
    void settingPathAndQueryParameters()
    {

         given()
                 .pathParam("myPath","users")
                 .queryParam("page",2)
                 .queryParam("id",5)

         .when()
                 .get("https://reqres.in/api/{myPath}")

         .then()
                 .statusCode(200)
                 .log().all();
    }
}
