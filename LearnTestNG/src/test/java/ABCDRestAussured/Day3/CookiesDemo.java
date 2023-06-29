package ABCDRestAussured.Day3;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CookiesDemo {
    @Test
    void getCookiesDemo()
    {
        Response res = given()

        .when()
                .get("https://www.google.com");

        //Get Single Cookie
        //String cookieValue = res.getCookie("AEC");
        //System.out.println("Value of the Cookie is : "+cookieValue);

        //Get All Cookies
        Map<String,String> cookies_values = res.getCookies();
        //System.out.println(cookies_values.keySet());
        for(String key : cookies_values.keySet())
        {
            String cookie_value = res.getCookie(key);
            System.out.println(key+": "+cookie_value);
        }
    }
}
