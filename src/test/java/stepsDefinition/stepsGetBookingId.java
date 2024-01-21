package stepsDefinition;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class stepsGetBookingId extends URLBase {

    Response response;
    RequestSpecification request = RestAssured.given();

    @When("^se ejecuta la peticion$")
    public void sendRequest() {
        request.header("Content-Type", "application/json");
        response = request.get();
        statusCode = response.getStatusCode();
    }

    @Then("^se lista todos los codigos de reservas$")
    public void getListIDs() {
        JsonPath totalBody = response.jsonPath(); //recorrer json
        Assert.assertNotEquals(null, totalBody);
    }

    @Given("^se ingreso el \"([^\"]*)\" y el \"([^\"]*)\"$")
    public void sendData(String firstName, String lastName) {
        request.queryParam("firstname", firstName).queryParam("lastname", lastName);
    }

    @Then("^se mostrara la lista de Booking id del usuario$")
    public void getListUserId() {
        String jsonString = response.asString();
        Assert.assertNotEquals(null, jsonString);
    }

    @Then("^se validara una lista vacia$")
    public void getEmptyList() {
        String jsonString = response.asString();
        Assert.assertEquals("[]", jsonString);
    }

    @Given("^se ingreso el \"([^\"]*)\"$")
    public void sendData(String firstName) {
        request.queryParam("firstname", firstName);
    }

    @And("se ingreso en \"([^\"]*)\" y el \"([^\"]*)\"$")
    public void sendDate(String checkIn, String checkOut) {
        request.queryParam("checkin", checkIn).queryParam("checkout", checkOut);
    }

    @Then("^se validara que el status es 500$")
    public void getStatusCode() {
        Assert.assertEquals("500", statusCode.toString());
    }
}

