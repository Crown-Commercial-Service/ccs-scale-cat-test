package com.scale.framework.utility.API;

import cucumber.api.Scenario;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import com.scale.context.ScenarioContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.Log;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.specification.ProxySpecification.host;

import java.io.File;
import java.io.FileInputStream;;

public class APIBase extends ConfigurationReader {

    public Response response;
    private RequestSpecification request;
    private ResponseSpecification responsespec;
    public ValidatableResponse vresponse;
    private Scenario scenario;
    private ScenarioContext scenarioContext;
    ConfigurationReader configread = new ConfigurationReader();
    private Logger log = Log.getLogger(APIBase.class);
    public String access_hash;

    public RequestSpecification setBaseURI() {
    	
    	//System.out.println("inside");
    	// 1 point
    	//setting basic url link
        RequestSpecification  requestspec = null;
        requestspec = new RequestSpecBuilder().setBaseUri(configread.get("BaseURL")).build();
        return  requestspec;
    }

    public RequestSpecification setBaseURI(String app) {
        RequestSpecification  Jaggaerrequestspec = null;
        if(app.contentEquals("Jaggaer")){
            Jaggaerrequestspec= new RequestSpecBuilder().setBaseUri(configread.get("JaggaerURL")).build();
        }
        return Jaggaerrequestspec;
    }
    
    
    // 2 point (Setting Request/Response application/json
    public String setContentType() {
        String strcontentype = configread.get("content_type");
        return strcontentype;
    }


    public Response getRequest(String URL) {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        response=null;
        response = given()
                .spec(setBaseURI())
                .auth()
                .oauth2(new Auth().Authenticaion())
                .get(URL);
        //log.info(response.prettyPrint().toString());
        return response;
    }

    public Response getRequestJaggaer(String URL, String param) {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
            RestAssured.proxy = host("proxy.cognizant.com").withPort(6050);
            RestAssured.useRelaxedHTTPSValidation();
            response = null;
            response = given()
                    .spec(setBaseURI("Jaggaer"))                    
                    .auth()
                    .oauth2(new Auth().Authenticaion("Jaggaer"))
                    .queryParam("flt",param)
                    .get(URL);
        RestAssured.reset();
        log.info("GET Request sent");
        return response;
    }
    
    public Response Requestpost(String URL, File filepath){
            response=null;
            response = given()
                    .spec(setBaseURI())
                    .auth()
                    .oauth2(new Auth().Authenticaion())
                    .contentType("application/json")
                    .body(filepath)
                    .when()
                    .post(URL);
            //scenario.write(response.toString());
        log.info("POST Request sent");
        return response;
    }
    
    public Response Requestpost(String URL, String jsonstring){
        response=null;
        response = given()
                .spec(setBaseURI())
                .auth()
                .oauth2(new Auth().Authenticaion())
                .contentType("application/json")
                .body(jsonstring)
                .when()
                .post(URL);
        //response.prettyPrint();
        return response;
    }
    
    public Response Requestpost(String URL, String jsonstring, String param){
    	
        response= given()
                .spec(setBaseURI())
                .header("Authorization", "Bearer "+new Auth().Authenticaion())
       		    .contentType(setContentType())
                .pathParams("access_hash",param)
                .body(jsonstring)
                .when()
                .post(URL);
       //scenario.write(response.toString());
        return response;
   }

    
    public Response Requestdel(String URL, File filepath){
        response=null;
        response= given()
                .spec(setBaseURI())
                .contentType(setContentType())
                .body(filepath)
                .header("Authorization", "Bearer "+new Auth().Authenticaion())
                .when()
                .delete(URL);
        scenario.write(response.toString());
        return response;
    }
    
    public Response Requestdel(String URL, String param){
        response=null;
        response= given().spec(setBaseURI()).header("Authorization", "Bearer "+new Auth().Authenticaion())
        		.contentType(setContentType()).pathParams("access_hash",param).when().delete(URL);
        //scenario.write(response.toString());
          //System.out.println("RequestDelete response:== " + response.getStatusCode());
        return response;
    }
    
    
    public Response Requestpatch(String URL) {
        response=null;
        response = given().spec(setBaseURI()).header("Authorization", "Bearer "+new Auth().Authenticaion()).contentType(setContentType()).patch(URL);
        //log.info(response.prettyPrint().toString());
        //System.out.println("RequestPatch response:== " + response.getStatusCode());
        return response;
    }

    public String getvaluefromresponse(String path){
        String  strpathval = response.then().extract().path(path);
        return  strpathval;
    }
    
    public int getvaluefromresponseAsInterger(String path){
        int  strpathval = response.then().extract().path(path);
        return  strpathval;
    }
    
    public int getvaluefromresponseAsInterger(String path,Response response){
        int  strpathval = response.then().extract().path(path);
        return  strpathval;
    }
    
    public String getvaluefromresponse(String path, Response response){
        String  strpathval = response.then().extract().path(path);
        return  strpathval;
    }

    public int getStatusCode(){
        int responsecode =  response.then().extract().statusCode();
        return responsecode;
    }
    
    public int getStatusCode(Response response){
        int responsecode =  response.then().extract().statusCode();
        return responsecode;
    }

}