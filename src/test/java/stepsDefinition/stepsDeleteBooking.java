package stepsDefinition;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.net.URL;

public class stepsDeleteBooking extends URLBase {
    Response response;
    RequestSpecification request = RestAssured.given();
    String URL;

        @Given("^se genera la url del booking a actualizar con \"([^\"]*)\"$")
        public void getURL(String bookingId) {
            URL = getUrlBooking(bookingId);
        }

    @When("^se ejecuta la peticion delete$")
    public void sendDelete() {
        request.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");
        request.header("Cookie", "token=abc123");
        response = request.log().all().delete(URL);
        statusCode = response.getStatusCode();
    }
    @Then("^se validara que el status es 201")
    public void getStatusCode() {
            Assert.assertEquals("201", statusCode.toString());
        }

    @Then("^se validara que el status es 405")
    public void getWrongStatusCode() {
        Assert.assertEquals("405", statusCode.toString());
    }
    }

