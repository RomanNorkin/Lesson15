import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Lesson16 {

    @Test
    public void lesson17GETRequest() {

        given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then().log().body().and().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void lesson17POSTRawText() {

        given()
                .baseUri("https://postman-echo.com").body("This is expected to be sent back as part of response body.")
                .when()
                .post("/post")
                .then().log().body().and().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void lesson17POSTFormData() {

        given()
                .baseUri("https://postman-echo.com").formParam("foo1", "bar1").and().formParam("foo2", "bar2")
                .contentType("application/x-www-form-urlencoded;charset=utf-8")
                .when()
                .post("/post")
                .then().log().body().and().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void lesson17PUTRequest() {

        given()
                .baseUri("https://postman-echo.com").body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then().log().body().and().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void lesson17PATCHRequest() {

        given()
                .baseUri("https://postman-echo.com").body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then().log().body().and().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void lesson17DELETERequest() {

        given()
                .baseUri("https://postman-echo.com").body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then().log().body().and().statusCode(HttpStatus.SC_OK);
    }
}