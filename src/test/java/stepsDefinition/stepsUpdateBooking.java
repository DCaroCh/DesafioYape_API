package stepsDefinition;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class stepsUpdateBooking extends URLBase {
    Response response;
    RequestSpecification request = RestAssured.given();
    String url;

    @When("^se genera la url del booking a actualizar con id \"([^\"]*)\"$")
    public void geturl(String bookingId) {
        url = getUrlBooking(bookingId);
    }

    @When("^los datos a editar son \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void sendNewRequest(String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");
        request.header("Cookie", "token=36e277eb7ae953e");
        response = request.log().all().body("{ \"firstname\":\"" + firstname + "\", \"lastname\":\"" + lastname + "\", \"totalprice\":\"" + totalprice + "\", " +
                "\"depositpaid\":" + depositpaid + ", \"bookingdates\": { \"checkin\":\"" + checkin + "\", \"checkout\":\"" + checkout + "\"}, \"additionalneeds\":\"" + additionalneeds + "\"}").put(url);
        statusCode = response.getStatusCode();
    }

    @And("^se valida la actualizacion con los nuevos datos \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void validateNewRequest(String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        JsonPath totalBody = response.jsonPath();
        ResponseBody body = response.getBody();
        System.out.print(body.asString());
        String firstName = totalBody.getString("firstname");
        String lastName = totalBody.getString("lastname");
        String totalPrice = totalBody.getString("totalprice");
        String depositPaid = totalBody.getString("depositpaid");
        String checkIn = totalBody.getString("bookingdates.checkin");
        String checkOut = totalBody.getString("bookingdates.checkout");
        String additionalNeeds = totalBody.getString("additionalneeds");

        Assert.assertEquals(firstname, firstName);
        Assert.assertEquals(lastname, lastName);
        Assert.assertEquals(totalprice, totalPrice);
        Assert.assertEquals(depositpaid, depositPaid);
        Assert.assertEquals(checkin, checkIn);
        Assert.assertEquals(checkout, checkOut);
        Assert.assertEquals(additionalneeds, additionalNeeds);
    }
}
