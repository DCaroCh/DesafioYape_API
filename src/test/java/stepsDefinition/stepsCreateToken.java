package stepsDefinition;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class stepsCreateToken extends URLBase {

    Response response;

    @Given("^se ingreso el \"([^\"]*)\" correcto$")
    public void setupEndpoint(String endpoint) {
        RestAssured.baseURI = getUrlBase() + endpoint;
    }

    @When("^el usuario es \"([^\"]*)\" y la clave es \"([^\"]*)\"$")
    public void sendRequest(String user, String pass) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + user + "\", \"password\":\"" + pass + "\"}").post();
        statusCode = response.getStatusCode();
    }

    @Then("^se validara que el status es 200$")
    public void getStatusCode() {
        Assert.assertEquals("200", statusCode.toString());
    }

    @Then("^se validara que la respuesta sea Bad Credentials$")
    public void getBadCredentials() {
        JsonPath totalBody = response.jsonPath();
        String reason = totalBody.get("reason");

        Assert.assertEquals("Bad credentials", reason);
    }
}
