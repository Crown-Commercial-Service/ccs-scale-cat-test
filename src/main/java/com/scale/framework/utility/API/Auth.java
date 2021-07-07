package com.scale.framework.utility.API;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import com.scale.framework.utility.ConfigurationReader;

import cucumber.api.Scenario;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Auth extends APIBase {

    private ConfigurationReader configreader = new ConfigurationReader();
    public String accesstoken;
    public String access_hash;
    private WebDriver driver;
      
    public String Authenticaion() {

        HashMap <String, String> Payload = new HashMap<>();
        Payload.put("username",configreader.get("TokenUserName"));
        Payload.put("password",configreader.get("TokenPassword"));
        Payload.put("client_id",configreader.get("TokenClientID"));
        Payload.put("client_secret",configreader.get("TokenClientSecret"));

        //RestAssured.defaultParser = Parser.JSON;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        Response response = null;
        response = given()
                .spec(setBaseURI())
                //.log().all()
                .header("x-api-key", configreader.get("x-api-key"))
                .contentType("application/json")
                .body(Payload)
                .when()
                .post(configreader.get("TokenURL"));
        // response.prettyPrint();
        //System.out.println("response"+response.statusCode());
        //accesstoken = response.then().extract().path("accesstoken");
        return response.jsonPath().getString("accessToken");


    }

}