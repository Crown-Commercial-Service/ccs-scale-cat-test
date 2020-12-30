package com.scale.validations;

import com.scale.framework.utility.APIUtil;
import com.scale.framework.utility.CommonValidations;
import com.scale.framework.utility.ScenarioContext;
import com.scale.pojo.*;
import cucumber.api.Scenario;


public class AddPlace extends CommonValidations {

    AddPlacePojo addPlacePojo = new AddPlacePojo();
    LocationPojo locationPojo = new LocationPojo();

    public AddPlace(Scenario scenario, ScenarioContext scenarioContext) {
        super(scenario, scenarioContext);
    }

    public void postRequest(String method) {
        apiUtil = new APIUtil();
        apiUtil.setBaseURI(configurationReader.get("BaseURL"));
        String[] headerParameters = {"content-Type", "host", "origin"};
        setHeaderParameters(headerParameters);
        String[] queryParameters = {"key"};
        setQueryParameters(queryParameters);
        switch (method.toUpperCase()) {
            case "POST":
                createPostRequest();
                response = apiUtil.postRequest(method, scenarioContext.getContext("endPoint"));
                break;
            case "GET":
                getResponse();
                break;
            case "PUT":
                createPutRquest();
                response = apiUtil.putRequest(method,scenarioContext.getContext("endPoint"));
                break;
            case "DELETE":
                response = apiUtil.deleteRequest(scenarioContext.getContext("endPoint"));
                break;
        }
    }


    public void createPostRequest() {
        addPlacePojo.setAccuracy(scenarioContext.getContext("accuracy"));
        addPlacePojo.setAddress(scenarioContext.getContext("address"));
        addPlacePojo.setLanguage(scenarioContext.getContext("language"));
        addPlacePojo.setName(scenarioContext.getContext("name"));
        addPlacePojo.setPhone_number(scenarioContext.getContext("phone_number"));
        addPlacePojo.setWebsite(scenarioContext.getContext("website"));
        addPlacePojo.setTypes(scenarioContext.getContext("types"));
        locationPojo.setLat(scenarioContext.getContext("location_lat"));
        locationPojo.setLng(scenarioContext.getContext("location_lng"));
        addPlacePojo.setLocation(locationPojo);
        apiUtil.setRequestBody(addPlacePojo.toString());
        System.out.println(addPlacePojo.toString());
    }

    public void createPutRquest(){

    }


}
