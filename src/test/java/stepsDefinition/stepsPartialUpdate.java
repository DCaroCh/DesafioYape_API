package stepsDefinition;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.net.URL;

public class stepsPartialUpdate extends URLBase {
    Response response;
    RequestSpecification request = RestAssured.given();
    String web;

    @Given("^se concatena la url del booking a actualizar con \"([^\"]*)\"$")
    public void getweb(String bookingID) {
        web = getUrlBooking(bookingID);
    }
    @When("^los datos a actualizar son \"([^\"]*)\" y \"([^\"]*)\"$")
    public void sendNewUpdate(String checkin, String checkout) {
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");
        request.header("Cookie", "token=36e277eb7ae953e");
        request.header("Accept", "application/json");
        response = request.body("{ \"bookingdates\": { \"checkin\":\"" + checkin + "\", \"checkout\":\"" + checkout + "\"}}").patch(web);
        statusCode = response.getStatusCode();
    }

    @And("^se valida la actualizacion con los nuevos datos \"([^\"]*)\" y \"([^\"]*)\"$")
    public void validateNewUpdate(String checkin, String checkout) {
        JsonPath totalBody = response.jsonPath();
        ResponseBody body = response.getBody();
        System.out.print(body.asString());
        String checkIn = totalBody.getString("bookingdates.checkin");
        String checkOut = totalBody.getString("bookingdates.checkout");

        Assert.assertEquals(checkin, checkIn);
        Assert.assertEquals(checkout, checkOut);
    }
}





