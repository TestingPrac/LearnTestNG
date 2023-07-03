package ABCDRestAssured.Day3;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HeadersDemo {
    @Test
    void getHeadersDemo()
    {
        Response res = given()

                .when()
                .get("https://www.google.com");

        //Get Single Header
        //String headerValue = res.getHeader("Content-Type");
        //System.out.println("Value of the Header is : "+headerValue);

        //Get All Cookies
        Headers myHeaders = res.getHeaders();

        for(Header hd: myHeaders)
        {
            System.out.println(hd.getName()+" :"+hd.getValue());
        }

    }
}
