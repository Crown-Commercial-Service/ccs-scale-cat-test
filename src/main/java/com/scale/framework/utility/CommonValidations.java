package com.scale.framework.utility;

import com.scale.pojo.AddPlacePojo;
import com.scale.validations.FTSE;
import cucumber.api.Scenario;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static junit.framework.TestCase.fail;

public class CommonValidations {
    protected Scenario scenario;
    protected ScenarioContext scenarioContext;
    protected APIUtil apiUtil = new APIUtil();
    protected JSONObject jsonObject;
    protected JsonPath jsonPath;
    protected Response response;
    protected ConfigurationReader configurationReader = new ConfigurationReader();
    protected FTSE ftse;
    private Logger log = Log.getLogger(CommonValidations.class);
    AddPlacePojo addPlacePojo = new AddPlacePojo();

    public CommonValidations(Scenario scenario, ScenarioContext scenarioContext) {
        this.scenario = scenario;
        this.scenarioContext = scenarioContext;
    }

    //Method to test basic authentication for username and Password

    protected void basicAuthValidation() {
        scenario.write("");
        if (!((scenarioContext.getContext("username")) == null ||
                !((scenarioContext.getContext("password")) == null))) {
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
            if (!(scenarioContext.getContext("queryParameter").isEmpty() || scenarioContext.getContext("queryParameter") == null)) {
                if (scenarioContext.getContext("queryParameter").equalsIgnoreCase("empty")) {
                    scenario.write(queryParameter + " - " + " ");
                    apiUtil.setQueryParam(queryParameter, "");
                    apiUtil.setQueryParam(queryParameter,addPlacePojo.getPlace_id());
                }
                else {
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

    public void postResponse(String path,String method) {
       // response = apiUtil.postRequest(method, scenarioContext.getContext("endPoint"));
        response = apiUtil.postRequest(method, path);
        scenario.write("CURL for the call - " + apiUtil.getCurl());
        log.info("\n Request details for \n " + apiUtil.getCurl());
        if (response.contentType().contains("json") || response.contentType().contains("Json")) {
            log.info("\n Response details \n "  + response.jsonPath().prettyPrint());
            jsonObject = new JSONObject(response.jsonPath().prettyPrint());
            scenario.write("Response for the above request is " + jsonObject.toString());
        } else if (scenarioContext.getContext("ExpectedStatus").equalsIgnoreCase("201")) {
            scenario.write("Response for 201 contains no body hence no implementation for body validation");
            log.info("\n Response for 201 contains");
            // junit.framework.Assert.assertTrue("The response code is 201 created", true);
        } else {
            scenario.write("Response type is not Json, please check with the developer");
            fail("The content type is not json");
            log.info("\n Response type is not Json");
        }
    }

    public void deleteResponse() {
        response = apiUtil.deleteRequest(scenarioContext.getContext("endpoint"));
        responseTypeValidator(response);
    }

    public void validateResponseCode(String statusCode, String method) {
        scenario.write("Asserting the response code :- " + "Expected response code is" + statusCode);
        Assert.assertEquals(Integer.parseInt(statusCode), response.getStatusCode());
        //  Assert.assertEquals(Integer.parseInt(statusCode), status);
        if (Integer.parseInt(statusCode) == 200)
            validateResponse(method);
      else if (Integer.parseInt(statusCode) == 404)
            validateResponse(method);
        else if (Integer.parseInt(statusCode) == 403)
            ftse.validateResponse_403();
        else if (Integer.parseInt(statusCode) == 500)
            ftse.validateResponse_500();
    }

    protected void setPathAndToken() {
        apiUtil.setBaseURI(configurationReader.get("BaseURL"));
        apiUtil.setOauth2(scenarioContext.getContext("Bearer Token"));
    }

    public void validateResponse(String method) {
        //Add all assertions.
        scenario.write("Schema validation for response 200");
        scenario.write("Asserting the presence of response message");
        switch (method.toUpperCase()) {
            case "POST":
                validatePOSTResponse();
                break;
            case "GET":
                validateGETResponse();
                break;
            case "PUT":
                validatePUTResponse();
                break;
            case "DELETE":
                validateDELETEResponse();
                break;
        }

    }

    public void validatePOSTResponse() {
        scenario.write("Schema validation for response 200");
        // Create a valid schema and validate schema
        response.then().assertThat().body(matchesJsonSchemaInClasspath("data/schema/valid200.json"));
        scenario.write("Asserting the presence of response message");
        scenario.write("Asserting the presence of response element " + "place_id");
        Assert.assertTrue(jsonObject.has("place_id"));
        scenario.write("Asserting the presence of response element " + "reference");
        Assert.assertTrue(jsonObject.has("reference"));
        scenario.write("Asserting the presence of response element " + "id");
        Assert.assertTrue(jsonObject.has("id"));
    }

    public void validateGETResponse() {
        // Create a valid schema and validate schema
        jsonPath = response.jsonPath();
        response.then().assertThat().body(matchesJsonSchemaInClasspath("data/schema/valid200.json"));
        String actName = jsonPath.get("name");
        Assert.assertEquals(actName, scenarioContext.getContext("name"));
        String actAccuracy = jsonPath.get("accuracy");
        Assert.assertEquals(actAccuracy,scenarioContext.getContext("accuracy"));
        String actPhoneNum = jsonPath.get("phone_number");
        Assert.assertEquals(actPhoneNum,scenarioContext.getContext("phone_number"));
        String actAddress = jsonPath.get("address");
        Assert.assertEquals(actAddress,scenarioContext.getContext("address"));
//        String actTypes = jsonPath.get("types");
//        Assert.assertEquals(actTypes,scenarioContext.getContext("types"));
        String actLang = jsonPath.get("language");
        Assert.assertEquals(actLang,scenarioContext.getContext("language"));
    }

    public void validateDELETEResponse() {
        jsonPath = response.jsonPath();
        // Create a valid schema and validate schema
        if(response.statusCode() ==  200) {
            response.then().assertThat().body(matchesJsonSchemaInClasspath("data/schema/valid200.json"));
            Assert.assertTrue(jsonObject.has("status"));
            scenario.write("Asserting the presence of response element " + "status");
        }
        if(response.statusCode() == 404) {
            Assert.assertTrue(jsonObject.has("msg"));
            scenario.write("Asserting the presence of response element " + "msg");
            String actName = jsonPath.get("msg");
            //Assert.assertEquals(actName, scenarioContext.getContext("msg"));
            Assert.assertEquals(actName, "Delete operation failed, looks like the data doesn't exists");

        }

    }

    public void validatePUTResponse() {
        // Create a valid schema and validate schema
        response.then().assertThat().body(matchesJsonSchemaInClasspath("data/schema/valid200.json"));
        Assert.assertTrue(jsonObject.has("msg"));
        scenario.write("Asserting the presence of response element " + "msg");
        jsonPath = response.jsonPath();
        String actName = jsonPath.get("msg");
        Assert.assertEquals(actName, scenarioContext.getContext("msg"));
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
