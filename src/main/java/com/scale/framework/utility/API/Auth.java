package com.scale.framework.utility.API;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class Auth extends APIBase {

    public String Authenticaion(String app, String UserID) {
        Response response;
        HashMap<String, String> Payload = new HashMap<>();
        String token="";
        switch (app){
            case "Jaggaer":
            RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
            RestAssured.useRelaxedHTTPSValidation();
            Payload.put("grant_type", "client_credentials");
            Payload.put("client_id", ConfigData.get("jaggaer-client-id"));
            Payload.put("client_secret", ConfigData.get("jaggaer-client-secret"));
            response = given()
                    .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                    .formParams(Payload)
                    .when()
                    .post(ConfigData.get("jaggaer-token-url"));
            Assert.assertEquals("Jaggaer Token generation failed", 200, response.getStatusCode());
            token = response.jsonPath().getString("token");
            break;

            case "Conclave":
            Payload.put("username",ConfigData.get(UserID));
            Payload.put("password",ConfigData.get("data-key"));
            Payload.put("client_id",ConfigData.get("auth-server-client-id"));
            Payload.put("client_secret",ConfigData.get("auth-server-client-secret"));
            response = given()
                    .header("x-api-key", ConfigData.get("api-key"))
                    .contentType("application/json")
                    .body(Payload)
                    .when()
                    .post(ConfigData.get("auth-token-url"));
            Assert.assertEquals("Conclave Token generation failed", 200, response.getStatusCode());
            token = response.jsonPath().getString("accessToken");
            break;

            default:
                Assert.fail("Invalid App Name");
        }
        Payload.clear();
        RestAssured.reset();
        //Assert.assertNotNull("Auth Token is Null",token);
        return token;
    }
}

