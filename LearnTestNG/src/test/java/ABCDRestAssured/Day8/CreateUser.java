package ABCDRestAssured.Day8;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {

    @Test
    void creatingUser(ITestContext context)
    {
        Faker faker = new Faker();

        JSONObject data = new JSONObject();
        data.put("name",faker.name().name());
        data.put("gender","Male");
        data.put("email",faker.internet().emailAddress());
        data.put("status","inactive");

        String bearerToken = "b1b186de86fa01fcdd6920fa9061d58b6ade37aa9658aa0040ffa445cad5cc3d";

        int id = given()
                .header("Authorization","Bearer "+bearerToken)
                .contentType("application/json")
                .body(data.toString())

        .when()
                .post("https://gorest.co.in/public/v2/users")
                .jsonPath().getInt("id");

        System.out.println("Id id: "+id);

        //context.setAttribute("user_id",id);
        context.getSuite().setAttribute("user_id",id);
    }
}
