package com.scale.TestRunner;

import com.scale.context.*;
import com.scale.framework.utility.API.APIBase;
import com.scale.framework.utility.API.Auth;
import com.scale.framework.utility.JSONUtility;
import org.json.simple.parser.ParseException;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import java.io.IOException;
import java.util.Map;
///*
@RunWith(Cucumber.class)
@CucumberOptions(
        strict = false,
        features = {"src/test/resources/FeatureFiles"},
        glue={"com.scale.stepdefs", "com.scale.context"},
        monochrome = true,
        plugin = { "pretty", "html:target/cucumber-html-reports", "json:target/cucumber-html-reports/cucumber.json"}
        ,tags = "@CaT"
        //dryRun = false
)
//*/


public class TestRunner {
//@Test
    public void fun(){
//    Map<String, Object> payload =new JSONUtility().convertJSONtoMAP("./src/test/resources/TestData/CreateProject.json");
//    System.out.println(payload.get("agreementID").toString()+payload.get("lotID").toString());
        System.out.println(new Auth().Authenticaion("Jaggaer"));


}

}
 
