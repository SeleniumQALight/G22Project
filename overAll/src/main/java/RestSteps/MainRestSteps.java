package RestSteps;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class MainRestSteps {

    final private String baseUrl = "http://restapi.demoqa.com";
    final private String baseUrlPrivat = "http://api.privatbank.ua";

    public RequestSpecification setBaseUrlForDemoQaWetherCity() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = baseUrl + "/utilities/weather/city";

        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        return RestAssured.given();
    }

    public RequestSpecification setBaseUrlForPrivatApi() {
        RestAssured.baseURI = baseUrlPrivat + "/p24api/pubinfo";
        return RestAssured.given().queryParam("json").queryParam("exchange").queryParam("coursid", 5);
    }

    public RequestSpecification setBaseUrlForCustomer() {
        RestAssured.baseURI = baseUrl + "/customer";
        return RestAssured.given();
    }

    public Response getRequest(String addToUrl) {
        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        return setBaseUrlForDemoQaWetherCity().request(Method.GET, addToUrl);
    }

    public Response getRequestToPrivatApi() {
        return setBaseUrlForPrivatApi().request(Method.GET);
    }

    public void checkResponseCode(Response response, int expectedStatusCode) {
        // Get the status code from the Response. In case of
        // a successfull interaction with the web service, we
        // should get a status code of 200.
        int statusCode = response.getStatusCode();
        // Assert that correct status code is returned.
        Assert.assertEquals("Correct status code returned", statusCode /*actual value*/, expectedStatusCode /*expected value*/);
    }

    public ResponseBody getResponseBody(Response response) {
        // Now let us print the body of the message to see what response
        // we have recieved from the server
        ResponseBody responseBody = response.getBody();
        System.out.println("Response Body is =>  " + responseBody.asString());
        return responseBody;
    }

    public Response getRequestAndVerifyStatusCode(String addToUrl) {
        Response response = getRequest(addToUrl);
        checkResponseCode(response, 200);
        return response;
    }

    public Response getRequestToPrivatApiAndVerifyStatusCode() {
        Response response = getRequestToPrivatApi();
        checkResponseCode(response, 200);
        return response;
    }

    public String getValueForKeyFromResponseAsJsonObject(Response response, String key) {
        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();
        // specified by JsonPath: City (Note: You should not put $. in the Java code)
        String value = jsonPathEvaluator.get(key);
        if (value == null) {
            Assert.fail("There is no key '" + key + "' in Json response ");
        }
        return value;
    }


}
