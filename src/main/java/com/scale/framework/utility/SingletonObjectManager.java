package com.scale.framework.utility;

import com.scale.pojo.AddPlacePojo;
import com.scale.validations.AddPlace;
import cucumber.api.Scenario;
import com.scale.pojo.FTSEPojo;
import com.scale.validations.FTSE;

public class SingletonObjectManager {
    private Scenario scenario;
    private ScenarioContext scenarioContext;
    //  API Classes
    private FTSEPojo ftsePojo;
    private FTSE ftse;
    private AddPlacePojo addPlacePojo;
    private AddPlace addPlace;

    public SingletonObjectManager(Scenario scenario, ScenarioContext scenarioContext) {
        this.scenario = scenario;
        this.scenarioContext = scenarioContext;
    }

    public FTSEPojo getFTSEPOJO() {
        return ftsePojo == null ? ftsePojo = new FTSEPojo() : ftsePojo;
    }

    public FTSE getFTSEObj() {
        return ftse == null ? ftse = new FTSE(scenario, scenarioContext) : ftse;
    }

    public AddPlacePojo getaddPlacePojo() {
        return addPlacePojo == null ? addPlacePojo = new AddPlacePojo() : addPlacePojo;
    }

    public AddPlace getAddPlace() {
        return addPlace == null ? addPlace = new AddPlace(scenario, scenarioContext) : addPlace;
    }
}