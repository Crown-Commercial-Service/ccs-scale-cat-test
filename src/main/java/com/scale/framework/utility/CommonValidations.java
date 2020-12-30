package com.scale.framework.utility;

import com.scale.validations.FTSE;
import cucumber.api.Scenario;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static junit.framework.TestCase.fail;

public class CommonValidations {
    protected Scenario scenario;
    protected ScenarioContext scenarioContext;
    protected APIUtil apiUtil = new APIUtil();
    protected JSONObject jsonObject;
    protected Response response;
    protected ConfigurationReader configurationReader = new ConfigurationReader();
    protected FTSE ftse;

    public CommonValidations(Scenario scenario, ScenarioContext scenarioContext) {
        this.scenario = scenario;
        this.scenarioContext = scenarioContext;
    }

    //Method to test basic authentication for username and Password

    protected void basicAuthValidation() {
        scenario.write("");
        if (!((scenarioContext.getContext("username")) == null ||
                !((scenarioContext.getContext("password"))==null))) {
            if (scenarioContext.getContext("username").equalsIgnoreCase("empty"))
                apiUtil.setBasicAuth("", configurationReader.get("PasswordRI"));
            else if (scenarioContext.getContext("Password").equalsIgnoreCase("empty"))
                apiUtil.setBasicAuth(configurationReader.get("UserNameRI"), "");
            else if (scenarioContext.getContext("Username").isEmpty())
                apiUtil.setBasicAuth(configurationReader.get("UserNameRI"), scenarioContext.getContext("Password"));
            else if (scenarioContext.getContext("Password").isEmpty())
                apiUtil.setBasicAuth(configurationReader.get("Username"), scenarioContext.getContext("PasswordRI"));
        } else apiUtil.setBasicAuth(configurationReader.get("UserNameRI"), configurationReader.get("PasswordRI"));
    }

    protected void setQueryParameters(String[] queryParameters) {
        scenario.write("Query parameters are : ");
        for (String queryParameter : queryParameters) {
            if (!scenarioContext.getContext("queryParameter").isEmpty()) {
                if (scenarioContext.getContext("queryParameter").equalsIgnoreCase("empty")) {
                    scenario.write(queryParameter + " - " + " ");
                    apiUtil.setQueryParam(queryParameter, "");
                } else {
                    scenario.write(queryParameter + " - " + scenarioContext.getContext(queryParameter));
                    apiUtil.setQueryParam(queryParameter, scenarioContext.getContext(queryParameter));
                }
            }
        }
    }

    protected void setHeaderParameters(String[] headerParameters) {
        scenario.write("Header parameters are : ");
        for (String headerParameter : headerParameters) {
                scenario.write(headerParameter + " - " + scenarioContext.getContext(headerParameter));
                apiUtil.setHeader(headerParameter, scenarioContext.getContext(headerParameter));
        }
    }

    private void responseTypeValidator(Response response) {
        scenario.write("CURL for the call - " + apiUtil.getCurl());
        if (response.contentType().contains("json") || response.contentType().contains("Json")) {
            jsonObject = new JSONObject(response.jsonPath().prettyPrint());
            System.out.println((response.jsonPath().prettyPrint()));
        } else {
            scenario.write("Response type is not json, please verify the result in console");
            fail("Content type is not json");
        }
        scenario.write("Response for the above request is " + jsonObject.toString());
    }

    public void getResponse() {
        response = apiUtil.getRequest(scenarioContext.getContext("endpoint"));
        System.out.println("Response code is " + response.prettyPrint());
        responseTypeValidator(response);
    }

    public void postResponse(String method) {
        response = apiUtil.postRequest(method,scenarioContext.getContext("endPoint"));
        scenario.write("CURL for the call - " + apiUtil.getCurl());
        System.out.println("Response code is "+ response.prettyPrint());
        if (response.contentType().contains("json") || response.contentType().contains("Json")) {
            jsonObject = new JSONObject(response.jsonPath().prettyPrint());
            scenario.write("Response for the above request is " + jsonObject.toString());
       }
//        else if (scenarioContext.getContext("ExpectedStatus").equalsIgnoreCase("201")) {
//            scenario.write("Response for 201 contains no body hence no implementation for body validation");
//            junit.framework.Assert.assertTrue("The response code is 201 created", true);
//        } else {
//            scenario.write("Response type is not Json, please check with the developer");
//            fail("The content type is not json");
//       }
   }

    public void deleteResponse() {
        response = apiUtil.deleteRequest(scenarioContext.getContext("endpoint"));
        responseTypeValidator(response);
    }

    public void validateResponseCode(String statusCode) {
        scenario.write("Asserting the response code :- " + "Expected response code is" + statusCode);
        Assert.assertEquals(Integer.parseInt(statusCode), response.getStatusCode());
        if (Integer.parseInt(statusCode) == 200)
            ftse.validateResponse_200();
        else if (Integer.parseInt(statusCode) == 403)
            ftse.validateResponse_403();
        else if (Integer.parseInt(statusCode) == 500)
            ftse.validateResponse_500();
    }

    protected void setPathAndToken() {
        apiUtil.setBaseURI(configurationReader.get("BaseURL"));
        apiUtil.setOauth2(scenarioContext.getContext("Bearer Token"));
    }

    public void validateResponse_400() {
        scenario.write("Schema validation for response 400");
        response.then().assertThat().body(matchesJsonSchemaInClasspath("data/schema/valid400.json"));
        scenario.write("Asserting the presence of response message");
        Assert.assertTrue(jsonObject.has("message"));
        scenario.write("Asserting the message body, body should contain message " + scenarioContext.getContext("expectedMessage"));
        Assert.assertTrue(jsonObject.get("message").toString().contains(scenarioContext.getContext("expectedMessage")));
    }

    public void validateResponse_400(String schemaName) {
        scenario.write("Schema validation for " + schemaName + " - response 400");
        response.then().assertThat().body(matchesJsonSchemaInClasspath("data/schema/" + schemaName + ".json"));
        scenario.write("Asserting the presence of response message");
        Assert.assertTrue(jsonObject.has("message"));
        scenario.write("Asserting the message body, body should contain message " + scenarioContext.getContext("expectedMessage"));
        Assert.assertTrue(jsonObject.get("message").toString().contains(scenarioContext.getContext("expectedMessage")));
    }

    public void validateResponse_403() {
        scenario.write("Schema validation for response 403");
        response.then().assertThat().body(matchesJsonSchemaInClasspath("data/schema/valid403.json"));
        scenario.write("Asserting the presence of response message");
        Assert.assertTrue(jsonObject.has("message"));
        scenario.write("Asserting the message body, body should contain message " + scenarioContext.getContext("expectedMessage"));
        Assert.assertTrue(jsonObject.get("message").toString().contains(scenarioContext.getContext("expectedMessage")));
    }

    public void validateResponse_403(String schemaName) {
        scenario.write("Schema validation for " + schemaName + " - response 403");
        response.then().assertThat().body(matchesJsonSchemaInClasspath("data/schema/" + schemaName + ".json"));
        scenario.write("Asserting the presence of response message");
        Assert.assertTrue(jsonObject.has("message"));
        scenario.write("Asserting the message body, body should contain message " + scenarioContext.getContext("expectedMessage"));
        Assert.assertTrue(jsonObject.get("message").toString().contains(scenarioContext.getContext("expectedMessage")));
    }

    public void validateResponse_500() {
        scenario.write("Schema validation for response 500");
        response.then().assertThat().body(matchesJsonSchemaInClasspath("data/schema/valid500.json"));
        scenario.write("Asserting the presence of response message");
        Assert.assertTrue(jsonObject.has("message"));
        scenario.write("Asserting the message body, body should contain message " + scenarioContext.getContext("expectedMessage"));
        Assert.assertTrue(jsonObject.get("message").toString().contains(scenarioContext.getContext("expectedMessage")));
    }

    public void validateResponse_500(String schemaName) {
        scenario.write("Schema validation for " + schemaName + " - response 500");
        response.then().assertThat().body(matchesJsonSchemaInClasspath("data/schema/" + schemaName + ".json"));
        scenario.write("Asserting the presence of response message");
        Assert.assertTrue(jsonObject.has("message"));
        scenario.write("Asserting the message body, body should contain message " + scenarioContext.getContext("expectedMessage"));
        Assert.assertTrue(jsonObject.get("message").toString().contains(scenarioContext.getContext("expectedMessage")));
    }


}
