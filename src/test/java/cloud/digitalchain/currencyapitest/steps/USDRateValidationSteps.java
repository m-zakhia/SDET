package cloud.digitalchain.currencyapitest.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import net.serenitybdd.rest.SerenityRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class USDRateValidationSteps {

    private Response response;
    private static final String wrong_URL = "https://open.er-api.com/v6/latest/UUD";
    private static final String correct_URL = "https://open.er-api.com/v6/latest/USD";

    @Given("I make a request to the USD exchange rate API with Serenity")
    public void iMakeARequestToTheUSDExchangeRateAPI() {
        response = SerenityRest.given()
                .when()
                .get(correct_URL);
    }

    @When("I receive the response")
    public void iReceiveTheResponse() {
        // This step may not require any code if the response is already captured in the Given step
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response status should indicate success")
    public void theResponseStatusShouldIndicateSuccess() {
        response.then().body("result", equalTo("success"));
    }

    @Then("the USD to AED rate should be between {float} and {float}")
    public void theUSDToAEDRateShouldBeBetweenAnd(float minRate, float maxRate) {
        response.then().body("rates.AED", allOf(greaterThanOrEqualTo(minRate), lessThanOrEqualTo(maxRate)));
    }

    @Then("the response should include a timestamp")
    public void theResponseShouldIncludeATimestamp() {
        response.then().body("time_last_update_unix", notNullValue());
    }

    @Then("the API response time should be less than {int} seconds")
    public void theAPIResponseTimeShouldBeLessThanSeconds(int seconds) {
        response.then().time(lessThan((long)seconds * 1000));
    }

    @Then("the response should contain {int} currency pairs")
    public void theResponseShouldContainCurrencyPairs(int count) {
        response.then().body("rates.size()", equalTo(count));
    }

    @Then("the response status should indicate failure")
    public void theResponseStatusShouldIndicateFailure() {
        response = SerenityRest.given().contentType("application/json").header("Content-Type", "application/json").when().get(wrong_URL);
        response.then().body("result", not(equalTo("success")));
    }

    @Then("the error message should be descriptive")
    public void theErrorMessageShouldBeDescriptive() {
        response.then().body("error", notNullValue());
    }

    @Then("the response should match the expected JSON schema")
    public void theResponseShouldMatchTheExpectedJSONSchema() {
        // Assume that the JSON schema is stored in src/test/resources/schemas/usd_rate_schema.json
        response.then().body(matchesJsonSchemaInClasspath("schemas/usd_rate_schema.json"));
    }
}