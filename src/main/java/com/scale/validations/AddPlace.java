package com.scale.validations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        switch (method.toUpperCase()) {
            case "POST":
                String[] queryParameters1 = {"key"};
                setQueryParameters(queryParameters1);
                createPostRequest();
                break;
            case "GET":
                String[] queryParameters = {"key","place_id"};
                setQueryParameters(queryParameters);
                apiUtil.getRequestBody();
                break;
            case "PUT":
                String[] queryParameters2 = {"key","place_id"};
                setQueryParameters(queryParameters2);
                createPutRquest();
                break;
            case "DELETE":
                String[] queryParameters3 = {"key"};
                setQueryParameters(queryParameters3);
                createDeleteRequest();
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
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            apiUtil.setRequestBody(objectMapper.writeValueAsString(addPlacePojo));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    public void createDeleteRequest() {
        addPlacePojo.setPlace_id(scenarioContext.getContext("place_id"));
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            apiUtil.setRequestBody(objectMapper.writeValueAsString(addPlacePojo));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    public void createPutRquest() {
        addPlacePojo.setPlace_id(scenarioContext.getContext("place_id"));
        addPlacePojo.setPlace_id(scenarioContext.getContext("key"));
        addPlacePojo.setPhone_number(scenarioContext.getContext("phone_number"));
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            apiUtil.setRequestBody(objectMapper.writeValueAsString(addPlacePojo));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
