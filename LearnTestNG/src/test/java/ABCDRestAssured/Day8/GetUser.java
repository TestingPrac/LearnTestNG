package ABCDRestAssured.Day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUser {

    @Test
    void gettingUserData(ITestContext context)
    {
        //int id = (int) context.getAttribute("user_id");
        int id = (int) context.getSuite().getAttribute("user_id");

        String bearerToken = "b1b186de86fa01fcdd6920fa9061d58b6ade37aa9658aa0040ffa445cad5cc3d";

        given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("id",id)

        .when()
                .get("https://gorest.co.in/public/v2/users/{id}")

        .then()
                .statusCode(200)
                .log().all();
    }
}
