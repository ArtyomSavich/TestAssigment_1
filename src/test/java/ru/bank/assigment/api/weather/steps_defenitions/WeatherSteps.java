package ru.bank.assigment.api.weather.steps_defenitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class WeatherSteps {

    private static final Logger logger = LogManager.getLogger(WeatherSteps.class);

    private Response response;
    private static final String BASE_URL = "http://api.weatherapi.com/v1";
    private final String API_TOKEN = "8f24530f819845149d4154241240403";
    private final String INVALID_API_TOKEN = "8f24530f819845149d443fdfssdf41240403";

    @Given("I have an API token")
    public void testIHaveApiToken() {
        logger.info( "testIHaveApiToken started" );
        assertNotNull("Api token is undefined.", API_TOKEN);
        logger.info( "testIHaveApiToken finished" );
    }

    @When("I request current weather for different {}")
    public void testRequestWeatherFor(String city) {
        logger.info( "testRequestWeatherFor started" );
        logger.info("City: " + city);
        response = given()
                .queryParam("key", API_TOKEN)
                .queryParam("q", city)
                .when()
                .get(BASE_URL + "/current.json");
        logger.info( "testRequestWeatherFor finished" );

    }

    @Then("I should receive data of weather and successfull status code 200")
    public void testReceiveDataOfWeather() {
        logger.info( "testReceiveDataOfWeather started" );
        assertEquals("Status code is not as expected.", HttpStatus.SC_OK, response.getStatusCode());
        assertNotNull("Response doesn't contain value.", response.getBody().jsonPath().get("location.name"));
    }

    @And("I receive the response which contains different {}")
    public void testReceiveResponseWhichContainsCity(String city) {
        logger.info( "testReceiveResponseWhichContainsCity started" );
        Map<String, String> expectedCountries = new HashMap<>();
        expectedCountries.put("Minsk","Belarus");
        expectedCountries.put("Moscow","Russia");
        expectedCountries.put("Dubai","United Arab Emirates");
        expectedCountries.put("London","United Kingdom");
        assertEquals("Location name is not as expected", city, (response.getBody().jsonPath().get("location.name")));
        assertEquals("Country is not as expected.", expectedCountries.get(city), (response.getBody().jsonPath().get("location.country")));
    }

    // invalid API key 403 error

    @Given("I have an invalid API key")
    public void testIHaveInvalidApiToken() {
        logger.info( "testIHaveInvalidApiToken started" );
        assertNotNull("Api token is undefined.", API_TOKEN);
    }

    @When("I request current weather for Minsk with invalid Token")
    public void testRequestWeatherForMinskWithInvalidToken() {
        logger.info( "testRequestWeatherForMinskWithInvalidToken started" );
        response = given()
                .queryParam("key", INVALID_API_TOKEN)
                .queryParam("q", "Minsk")
                .when()
                .get(BASE_URL + "/current.json");
    }

    @Then("I should receive an error response code 403 with invalid Token")
    public void testReceiveErrorCodeWithInvalidToken() {
        logger.info( "testReceiveErrorCodeWithInvalidToken started" );
        assertEquals("Status code is not as expected.", HttpStatus.SC_FORBIDDEN, response.getStatusCode());
    }


    // Incorrect City Name 400

    @Given("I have a valid API key")
    public void testIHaveValidApiToken() {
        logger.info( "testIHaveValidApiToken started" );
        assertNotNull("Api token is undefined.", API_TOKEN);
    }

    @When("I request current weather for incorrect city name")
    public void testRequestWeatherForIncorrectCityName() {
        logger.info( "testRequestWeatherForIncorrectCityName started" );
        response = given()
                .queryParam("key", API_TOKEN)
                .queryParam("q", "M")
                .when()
                .get(BASE_URL + "/current.json");
    }

    @Then("I should receive an error response code 400")
    public void testReceiveErrorCode() {
        logger.info( "testReceiveErrorCode started" );
        assertEquals("Status code is not as expected.", HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }

    // Incorrect URL - 404 error

    @When("I request current weather in case incorrect URL")
    public void testRequestWeatherForInCaseIncorrectURL() {
        logger.info( "testRequestWeatherForInCaseIncorrectURL started" );
        response = given()
                .queryParam("key", API_TOKEN)
                .queryParam("q", "Minsk")
                .when()
                .get(BASE_URL + "/current");
    }

    @Then("I should receive an error response code 404")
    public void testReceiveErrorCodeInCaseIncorrectURL() {
        logger.info( "testReceiveErrorCodeInCaseIncorrectURL started" );
        assertEquals("Status code is not as expected.", HttpStatus.SC_NOT_FOUND, response.getStatusCode());
    }

    // Without p parameter - 404 error


    @When("I request current weather in case without q parameter")
    public void testRequestWeatherForInCaseWithoutQParameter() {
        logger.info( "testRequestWeatherForInCaseWithoutQParameter started" );
        response = given()
                .queryParam("key", API_TOKEN)
                .when()
                .get(BASE_URL + "/current");
    }

    @Then("I should receive an error response code 400 in case without q parameter")
    public void testReceiveErrorCodeInCaseWithoutQParameter() {
        logger.info( "testReceiveErrorCodeInCaseWithoutQParameter started" );
        assertEquals("Status code is not as expected.", HttpStatus.SC_NOT_FOUND, response.getStatusCode());
    }
}
