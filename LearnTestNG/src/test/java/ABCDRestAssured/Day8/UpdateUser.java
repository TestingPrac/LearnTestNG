package ABCDRestAssured.Day8;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    @Test
    void updatingUserDetails(ITestContext context)
    {
        Faker faker = new Faker();

        JSONObject data = new JSONObject();
        data.put("name",faker.name().name());
        data.put("gender","Male");
        data.put("email",faker.internet().emailAddress());
        data.put("status","active");

        String bearerToken = "b1b186de86fa01fcdd6920fa9061d58b6ade37aa9658aa0040ffa445cad5cc3d";

        //int id = (int) context.getAttribute("user_id");
        int id = (int) context.getSuite().getAttribute("user_id");

        given()
                .header("Authorization","Bearer "+bearerToken)
                .contentType("application/json")
                .body(data.toString())
                .pathParam("id",id)

        .when()
                .put("https://gorest.co.in/public/v2/users/{id}")

        .then()
                .statusCode(200)
                .log().all();




    }
}
