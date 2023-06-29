package ABCDRestAussured.Day2.DifferentWaysToCreatePostRequestBody;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostRequestUsingExternalJSONFile {


    @Test(priority = 1)
    void createUser() throws FileNotFoundException {
        File f = new File("C:\\Users\\a853684\\IdeaProjects\\LearnTestNG\\src\\test\\resources\\Payloads\\reqresRequestBody.json");

        FileReader fr = new FileReader(f);

        JSONTokener jt = new JSONTokener(fr);

        JSONObject data = new JSONObject(jt);



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
