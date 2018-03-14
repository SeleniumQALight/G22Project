package restTest;

import RestSteps.MainRestSteps;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import libs.CurrencyValues;
import libs.ResponseStructureForRestAssuredTest;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static libs.Utils.getDateAndTimeFormated;


public class TestRestAssured {
    MainRestSteps mainRestSteps = new MainRestSteps();
    @Test
    @Ignore
    public void getCursDetails() {

        Response response = mainRestSteps.getRequestToPrivatApiAndVerifyStatusCode();

        ResponseBody responseBody = mainRestSteps.getResponseBody(response);

//        System.out.println("Privat Curse" +responseBody.toString());
//        String testString = responseBody.asString();
//        String [] testString1 = testString.split("\"");
//
//        for (int i = 0; i < testString1.length; i++) {
//            System.out.println(i + " -> " + testString1 [i]);
//        }
//        System.out.println(" Kust " + testString1[3] + " = " + testString1[11] + " and " + testString1[15]);

        CurrencyValues[] responseStructure = responseBody.as(CurrencyValues[].class);

        for (CurrencyValues currencyElement : responseStructure ) {
            System.out.println("Cur " + currencyElement.ccy + " to " + currencyElement.base_ccy + " has for buy " + currencyElement.buy + " and for sale " + currencyElement.sale);
        }



    }



    @Test
    @Ignore
    public void getWeatherDetails() {

        Response response = mainRestSteps.getRequestAndVerifyStatusCode("/London");

        ResponseBody responseBody = mainRestSteps.getResponseBody(response);

        System.out.println("City received from Response " + mainRestSteps.getValueForKeyFromResponseAsJsonObject(response, "City"));

        ResponseStructureForRestAssuredTest responseStructure = responseBody.as(ResponseStructureForRestAssuredTest.class);

        System.out.println("City from json " + responseStructure.City);
    }

    @Test
    @Ignore
    public void registrationSuccessful() {
        String dateTime = getDateAndTimeFormated();
        RequestSpecification request = mainRestSteps.setBaseUrlForCustomer();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Virender" + dateTime); // Cast
        requestParams.put("LastName", "Singh" + dateTime);
        requestParams.put("UserName", "sdimpleuser2dd20111" + dateTime);
        requestParams.put("Password", "password");
        requestParams.put("Email", "sample" + dateTime + "@gmail.com");

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");

        request.body(requestParams.toMap());


        Response response = request.post("/register");


        int statusCode = response.getStatusCode();
        Assert.assertEquals(201, statusCode);
        ResponseBody responseBody = response.getBody();

        System.out.println(response.asString());
        if (response.jsonPath().get("SuccessCode") == null) {
            String failCode = response.jsonPath().get("FaultId");
            Assert.fail(failCode);
        } else {
            Assert.assertEquals("Correct Success code was returned", response.jsonPath().get("SuccessCode"), "OPERATION_SUCCESS");
        }
    }


}
