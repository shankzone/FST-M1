package project;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.IReporter;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RESTAssuredProject {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    String sshKey;
    int resid;
    String token = "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";

    @BeforeClass
    public void setUp() {

        // Create request specification
        requestSpec = new RequestSpecBuilder()
                // Set content type
                .setContentType(ContentType.JSON)
                //.addHeader("token","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")
                .addHeader("Authorization", "Bearer " + token )
                // Set base URL
                .setBaseUri("https://api.github.com")
                // Build request specification
                .build();
    }

    @Test(priority = 1)
    public void addSSHKey() {
        String reqBody = """
        {
              "title": "TestAPIKey",
              "key": "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIFAj51YvLkb8xomx9gEwlRyUlKN0Xsx0NcVN31lVHHyK gmx\\\\003r3c744@IBM-FV2T2F3"
        }
        """;
        Response response =
                given().spec(requestSpec) // Set headers
                        .body(reqBody) // Pass request body from file
                        .when().post("/user/keys"); // Send POST request

        response.then().statusCode(201);
        resid =  response.then().extract().path("id");
        System.out.println(resid);
        Reporter.log("SSH key is successfully added with id " + resid);

    }

    @Test(priority = 2)
    public void getSSHKey() {
        Response response =
                given().spec(requestSpec).when()
                        .pathParam("keyId",resid)
                        .get("/user/keys/{keyId}"); // Send get request

        response.then().statusCode(200);

        Reporter.log("SSH key is" + resid);
    }

    @Test(priority = 3)
    public void deleteSSHKey() {
        Response response =
                given().spec(requestSpec).when()
                        .pathParam("keyId",resid)
                        .delete("/user/keys/{keyId}"); // Send POST request
        response.then().statusCode(204);

        response = given().spec(requestSpec).when()
                        .pathParam("keyId",resid)
                        .get("/user/keys/{keyId}"); // Send get request
        response.then().statusCode(404);

        Reporter.log("SSH key is successfully deleted");


    }


}
