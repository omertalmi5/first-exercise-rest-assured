import Contracts.RegisterContract;
import Contracts.SuccessMessage;
import io.restassured.response.Response;
import org.junit.Test;

import static Utils.StringUtils.getRandomString;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class loginTest {

  @Test
  public void test() {
    baseURI = "http://restapi.demoqa.com/customer";
    Response response =
        given()
            .header("Content-Type", "application/json")
            .body(new RegisterContract(getRandomString(), getRandomString(), getRandomString(), getRandomString(), getRandomString() + "@gmail.com"))
            .post("/register");
    SuccessMessage successMessage = response.as(SuccessMessage.class);
    assertThat(response.getStatusCode(), is(ConstParams.CREATED_CODE));
    String successCode = response.jsonPath().get("SuccessCode");
    response
        .then()
        .assertThat()
        .statusCode(ConstParams.CREATED_CODE)
        .body("SuccessCode", equalTo(ConstParams.successCodeOfRegistration));
    assertThat(
        "Correct Success code was returned",
        successCode,
        is(ConstParams.successCodeOfRegistration));
  }
}
