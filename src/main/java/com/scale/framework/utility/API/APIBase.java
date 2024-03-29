package com.scale.framework.utility.API;

import com.scale.context.GlobalContext;
import com.scale.framework.utility.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth2;

public class APIBase extends ConfigurationReader {

    public Response response;
    ConfigurationReader configread = new ConfigurationReader();
    private static final Logger log = LogManager.getLogger(APIBase.class.getName());
    HashMap<String, String> ConfigData = GlobalContext.getGlobalInstance().getGlobalData();

    public RequestSpecification getRequestSpec(String app, String UserID) {
        RequestSpecification requestspec;
        requestspec = new RequestSpecBuilder().setBaseUri(configread.get("BaseURL")).build();
        switch (app) {
            case "Jaggaer":
                requestspec = new RequestSpecBuilder()
                        .setBaseUri(ConfigData.get("jaggaer-base-url"))
                        .setAuth(oauth2(new Auth().Authentication("Jaggaer", "")))
                        .setAccept(ContentType.ANY)
                        .setContentType(ContentType.JSON)
                        .build();
                break;
            case "Conclave":
                requestspec = new RequestSpecBuilder()
                        .setBaseUri(configread.get("BaseURL"))
                        .setAuth(oauth2(new Auth().Authentication("Conclave", UserID)))
                        .setAccept(ContentType.ANY)
                        .setContentType(ContentType.JSON)
                        .build();
                break;
            default:
                Assert.fail("Invalid App name");
        }

        return requestspec;
    }


    // 2 point (Setting Request/Response application/json
    public String setContentType() {
        return configread.get("content_type");
    }


    public Response getRequest(String URL, String UserID) {
        //RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        response = null;
        response = given()
                .spec(getRequestSpec("Conclave", UserID))
                .get(URL);
        //log.info(response.prettyPrint().toString());
        Assert.assertEquals("FAILED - Tenders API GET "+URL, 200, response.getStatusCode());
        return response;
    }

    public Response getRequestJaggaer(String URL, String param) {
        //RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.useRelaxedHTTPSValidation();
        response = null;
        response = given()
                .spec(getRequestSpec("Jaggaer", ""))
                .queryParam("flt", param)
                .get(URL);
        RestAssured.reset();
        log.info("GET Request sent");
        Assert.assertEquals("FAILED - Jaggaer GET "+URL, 200, response.getStatusCode());
        return response;
    }

    public Response Requestpost(String URL, File filepath, String UserID) {
        response = null;
        response = given()
                .spec(getRequestSpec("Conclave", UserID))
                .body(filepath)
                .post(URL);
        //scenario.write(response.toString());
        Assert.assertEquals("FAILED - Tenders API POST "+URL, 200, response.getStatusCode());
        log.info("POST Request sent");
        return response;
    }

    public Response Requestpost(String URL, Map<String, String> Body, String UserID) {
        //RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        response = null;
        response = given()
                .spec(getRequestSpec("Conclave", UserID))
                .body(Body)
                .post(URL);
        //scenario.write(response.toString());
        log.info("POST Request sent");
        Assert.assertEquals("FAILED - Tenders API POST "+URL, 200, response.getStatusCode());
        return response;
    }

    public Response Requestpost(String URL, Object obj, String UserID) {
        //RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        response = null;
        response = given()
                .spec(getRequestSpec("Conclave", UserID))
                .body(obj)
                .post(URL);
        //scenario.write(response.toString());
        log.info("POST Request sent");
        Assert.assertEquals("FAILED - Tenders API POST "+URL, 200, response.getStatusCode());
        return response;
    }

    public Response Requestpost(String URL, String jsonstring, String UserID) {
        response = null;
        response = given()
                .spec(getRequestSpec("Conclave", UserID))
                .body(jsonstring)
                .post(URL);
        Assert.assertEquals("FAILED - Tenders API POST "+URL, 200, response.getStatusCode());
        return response;
    }

    public Response Requestput(String URL, String jsonstring, String UserID) {
        response = null;
        response = given()
                .spec(getRequestSpec("Conclave", UserID))
                .body(jsonstring)
                .put(URL);
        Assert.assertEquals("FAILED - Tenders API PUT "+URL, 200, response.getStatusCode());
        return response;
    }

    public Response Requestput(String URL, Map<String, String> Body, String UserID) {
        //RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        response = null;
        response = given()
                .spec(getRequestSpec("Conclave", UserID))
                .body(Body)
                .put(URL);
        //scenario.write(response.toString());
        log.info("POST Request sent");
        Assert.assertEquals("FAILED - Tenders API PUT "+URL, 200, response.getStatusCode());
        return response;
    }
    public Response Requestget(String URL, String UserID) {
        response = null;
        response = given()
                .spec(getRequestSpec("Conclave", UserID))
                .get(URL);
        Assert.assertEquals("FAILED - Tenders API GET "+URL, 200, response.getStatusCode());
        return response;
    }


    public int getStatusCode1() {
        return response.then().extract().statusCode();
    }

}