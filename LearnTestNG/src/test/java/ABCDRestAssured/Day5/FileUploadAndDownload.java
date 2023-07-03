package ABCDRestAssured.Day5;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class FileUploadAndDownload {

    @Test(priority = 1)
    void singleFileUpload()
    {
        File myfile = new File("C:\\Users\\a853684\\OneDrive - Atos\\Documents\\Testing&Automation Files\\API Testing Documents\\Session8 FileUpload\\Text1.txt");
        given()
                .multiPart("file",myfile)
                .contentType("multipart/form-data")

        .when()
                .post("http://localhost:8080/uploadFile")

        .then()
                .statusCode(200)
                .body("fileName",equalTo("Text1.txt"))
                .log().all();
    }

    @Test(priority = 3)
    void multipleFileUpload()
    {
        File myfile1 = new File("C:\\Users\\a853684\\OneDrive - Atos\\Documents\\Testing&Automation Files\\API Testing Documents\\Session8 FileUpload\\Text1.txt");
        File myfile2 = new File("C:\\Users\\a853684\\OneDrive - Atos\\Documents\\Testing&Automation Files\\API Testing Documents\\Session8 FileUpload\\Text2.txt");

        given()
                .multiPart("files",myfile1)
                .multiPart("files",myfile2)
                .contentType("multipart/form-data")

        .when()
                .post("http://localhost:8080/uploadMultipleFiles")

        .then()
                .statusCode(200)
                .body("[0].fileName",equalTo("Text1.txt"))
                .body("[1].fileName",equalTo("Text2.txt"))
                .log().all();
    }


    @Test(priority = 2,dependsOnMethods = "singleFileUpload")
    void fileDownloadVerification()
    {
        given()


        .when()
                .get("http://localhost:8080/downloadFile/Text1.txt")

        .then()
                .statusCode(200)
                .log().body();
    }
}
