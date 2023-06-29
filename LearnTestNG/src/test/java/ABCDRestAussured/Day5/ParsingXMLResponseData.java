package ABCDRestAussured.Day5;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ParsingXMLResponseData {
    @Test(priority=1)
    void testXMLResponse1()
    {
        //Approach1
        given()


        .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1")

        .then()
                .statusCode(200)
                .body("TravelerinformationResponse.page",equalTo("1"))
                .body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"))
                .log().all();
    }

    @Test(priority = 2)
    void testXMLResponse2()
    {
        //Approach 2
        Response res =given()

        .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1");

        Assert.assertEquals(res.statusCode(),200);
        Assert.assertEquals(res.getHeader("Content-Type"),"application/xml; charset=utf-8");

        String pageNum = res.xmlPath().get("TravelerinformationResponse.page").toString();
        System.out.println(pageNum);
        Assert.assertEquals(pageNum,"1");

        String firstTravellerName = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
        System.out.println(firstTravellerName);
        Assert.assertEquals(firstTravellerName,"Developer");

    }

    @Test
    void testXMLResponseBodyData()
    {
        Response res = given()

        .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1");


        XmlPath xp = new XmlPath(res.asString());

        //Verify Total No.of Travellers

        List<String> travellers = xp.getList("TravelerinformationResponse.travelers.Travelerinformation");
        Assert.assertEquals(travellers.size(),10);


        //Printing all the names of the Travellers

        List<String> traveller_names = xp.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
        for(String travellerName:traveller_names)
        {
            System.out.println(travellerName);
        }


        //Verify Traveller Name is present in the response

        boolean status = false;
        for(String travellerName:traveller_names)
        {
            if(travellerName.equals("Developer"))
            {
                status = true;
                break;
            }
        }

        Assert.assertEquals(status,true);
    }
}
