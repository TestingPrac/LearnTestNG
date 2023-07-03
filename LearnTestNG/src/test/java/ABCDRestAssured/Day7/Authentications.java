package ABCDRestAssured.Day7;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Authentications {

    @Test(priority = 1)
    void basicAuthentication()
    {
        given()
                .auth().basic("postman","password")

        .when()
                .get("https://postman-echo.com/basic-auth")
        .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

    @Test(priority = 2)
    void digestAuthentication()
    {
        given()
                .auth().digest("postman","password")

        .when()
                .get("https://postman-echo.com/digest-auth")

        .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

    @Test(priority = 3)
    void preemptiveAuthentication()
    {
        given()
                .auth().preemptive().basic("postman","password")

        .when()
                .get("https://postman-echo.com/basic-auth")

        .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

    @Test(priority = 4)
    void bearerTokenAuthentication()
    {
        String bearerToken = "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";
        given()
                .header("Authorization","Bearer "+bearerToken)

        .when()
                .get("https://api.github.com/user/repos")

        .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 5)
    void apiKeyAuthentication()
    {

        given()
                .queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c")

        .when()
                .get("https://api.openwheathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")

        .then()
                .statusCode(200)
                .log().all();
    }

}
