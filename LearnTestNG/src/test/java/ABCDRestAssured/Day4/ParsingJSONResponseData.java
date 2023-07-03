package ABCDRestAssured.Day4;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ParsingJSONResponseData {
    @Test(priority=1)
    void testJSONResponse1()
    {
        //Approach1
        given()
                .contentType(ContentType.JSON)

        .when()
                .get("http://localhost:3000/store")

        .then()
                .statusCode(200)
                .body("book[2].title",equalTo("Ramayana"))
                .log().all();
    }

    @Test(priority = 2)
    void testJSONResponse2()
    {
        //Approach 2
        Response res =given()
                       .contentType(ContentType.JSON)

        .when()
                .get("http://localhost:3000/store");

        Assert.assertEquals(res.statusCode(),200);
        Assert.assertEquals(res.getHeader("Content-Type"),"application/json; charset=utf-8");

        String bookTitle = res.jsonPath().get("book[2].title").toString();
        System.out.println(bookTitle);
        Assert.assertEquals(bookTitle,"Ramayana");

    }

    @Test(priority = 3)
    void testJSONResponseBodyData()
    {
        //Approach 2
        Response res =given()
                .contentType(ContentType.JSON)

        .when()
                .get("http://localhost:3000/store");

        Assert.assertEquals(res.statusCode(),200);

        JSONObject jo = new JSONObject(res.asString());  //Converting Response Type to JSON Object Type

        //Printing all the titles of the books
        for(int i=0; i<jo.getJSONArray("book").length(); i++)
        {
           String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
           System.out.println(bookTitle);
        }

        //For Validating Ramayana Book is present in the books or not
        boolean status = false;
        for(int i=0; i<jo.getJSONArray("book").length(); i++)
        {
            String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
            if(bookTitle.equals("Ramayana"))
            {
                status = true;
                System.out.println("Ramayana Book Found in "+i);
                break;
            }
        }
        Assert.assertEquals(status,true);


        //Validate Total Price of books
        double totalPrice = 0;
        for(int i=0; i<jo.getJSONArray("book").length(); i++)
        {
            String bookPrice = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
            totalPrice = totalPrice + Double.parseDouble(bookPrice);
        }
        System.out.println("Total Price: "+totalPrice);
        Assert.assertEquals(totalPrice,950.5);


    }

}
