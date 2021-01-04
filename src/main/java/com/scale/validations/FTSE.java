package com.scale.validations;

import com.scale.framework.utility.APIUtil;
import com.scale.framework.utility.CommonValidations;
import com.scale.framework.utility.ScenarioContext;
import cucumber.api.Scenario;
import com.scale.pojo.FTSEPojo;
import org.junit.Assert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class FTSE extends CommonValidations {
    public FTSE(Scenario scenario, ScenarioContext scenarioContext) {
        super(scenario, scenarioContext);
    }

    public void postRequest() {
        apiUtil = new APIUtil();
        apiUtil.setBaseURI(configurationReader.get("BaseURL"));
        scenario.write("Request header parameters are :-");
        String[] headerParameters = {"content-Type", "Host", "Origin"};
        setHeaderParameters(headerParameters);
        scenario.write("Request body parameters are :-");
        FTSEPojo ftsePojo = new FTSEPojo();
        ftsePojo.setSampleTime(scenarioContext.getContext("sampleTime"));
        ftsePojo.setTimeFrame(scenarioContext.getContext("sampleTimeFrame"));
        ftsePojo.setRequestedDataSetType(scenarioContext.getContext("requestedDataSetType"));
        ftsePojo.setChartPriceType(scenarioContext.getContext("chartPriceType"));
        ftsePojo.setKey(scenarioContext.getContext("key"));
        apiUtil.setRequestBody(ftsePojo.toString());
    }

    public void validateResponse_200() {
        //Add all assertions.
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
}
