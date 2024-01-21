package stepsDefinition;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class stepsCreateBooking extends URLBase {
    Response response;
    RequestSpecification request = RestAssured.given();

    @Given("^los datos sean \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void sendRequest(String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        request.header("Content-Type", "application/json");

        response = request.body("{ \"firstname\":\"" + firstname + "\", \"lastname\":\"" + lastname + "\", \"totalprice\":\"" + totalprice + "\", " +
                "\"depositpaid\":" + depositpaid + ", \"bookingdates\": { \"checkin\":\"" + checkin + "\", \"checkout\":\"" + checkout + "\"}, \"additionalneeds\":\"" + additionalneeds + "\"}").post();
        statusCode = response.getStatusCode();
    }

    @Then("^la nueva reserva esta asignada a \"([^\"]*)\" y \"([^\"]*)\"$")
    public void getNewBookingId(String firstname, String lastname) {
        JsonPath totalBody = response.jsonPath();
        String firstName = totalBody.getString("booking.firstname");
        String lastName = totalBody.getString("booking.lastname");

        Assert.assertEquals(firstname, firstName);
        Assert.assertEquals(lastname, lastName);
    }
}