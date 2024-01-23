package stepsDefinition;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class stepsHealthCheck extends URLBase {

    Response response;
    RequestSpecification request = RestAssured.given();
    String url;

    @Given("^se seteo el \"([^\"]*)\" correcto$")
    public void setupEndpointHealthCheck(String endpoint) {
        url = getUrlBase() + endpoint;
    }

    @When("^se envia la peticion get$")
    public void sendStatus() {
        response = request.header("Content-Type", "application/json").get(url);

        statusCode = response.getStatusCode();
    }

    @Then("^se comprobara que el status es 404$")
    public void getStatus() {
        Assert.assertEquals("404", statusCode.toString());
    }
}
