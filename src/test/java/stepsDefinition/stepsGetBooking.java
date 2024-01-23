package stepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class stepsGetBooking extends URLBase {
    Response response;
    RequestSpecification request = RestAssured.given();
    String url;

    @When("^se ejecuta la peticion get$")
    public void sendBookingID() {
        response = request.header("Content-Type", "application/json").get(url);

        statusCode = response.getStatusCode();
    }

    @When("^se genera la url del booking con id \"([^\"]*)\"$")
    public void geturl(String bookingId) {
        url = getUrlBooking(bookingId);
    }

    @Then("^se validara el \"([^\"]*)\" del usuario$")
    public void getUserName(String name) {
        JsonPath totalBody = response.jsonPath();
        String firstname = totalBody.get("firstname");

        Assert.assertEquals(name, firstname);
    }

    @Then("^se validara que el status es 404$")
    public void getStatusCode() {
        Assert.assertEquals("404", statusCode.toString());
    }
}

