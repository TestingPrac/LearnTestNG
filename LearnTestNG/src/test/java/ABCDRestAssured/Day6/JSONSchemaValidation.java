package ABCDRestAssured.Day6;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JSONSchemaValidation {
    @Test
    void jsonSchemaValidation()
    {
        given()

        .when()
                .get("http://localhost:3000/store")
        .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SchemaValidationFiles\\store_JsonSchema.json"))
                .log().body();

    }
}
