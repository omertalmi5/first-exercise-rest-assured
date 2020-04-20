import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Test;

import static Contracts.RegisterContract.aRegisterDetails;
import static Utils.StringUtils.getRandomString;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class loginTest {

  @Test
  public void test() {

    JSONObject requestParams = new JSONObject();
    requestParams.put("FirstName", getRandomString());
    requestParams.put("LastName", getRandomString());
    requestParams.put("UserName", getRandomString());
    requestParams.put("Password", getRandomString());
    requestParams.put("Email", getRandomString() + "@gmail.com");

    // requestParams.toJSONString()
    // aRegisterDetails().build()
    baseURI = "http://restapi.demoqa.com/customer";
    Response response =
        given()
            .header("Content-Type", "application/json")
            .body(aRegisterDetails().build())
            .post("/register");
    response.then().assertThat().statusCode(ConstParams.CREATED_CODE);
    assertThat(response.getStatusCode(), is(ConstParams.CREATED_CODE));
    String successCode = response.jsonPath().get("SuccessCode");
    response
        .then()
        .assertThat()
        .body("SuccessCode", equalTo(ConstParams.successCodeOfRegistration));
    assertThat(
        "Correct Success code was returned",
        successCode,
        is(ConstParams.successCodeOfRegistration));
  }
}
