package com.scale.TestRunner;

import com.scale.context.GlobalContext;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/FeatureFiles"},
        glue={"com.scale.stepdefs", "com.scale.context"},
        monochrome = true,
        plugin = { "pretty", "html:target/cucumber-html-reports/report.html", "json:target/cucumber-html-reports/cucumber.json"},
        tags = "@1FC-Flow",
        dryRun = false
)


public class TestRunner {

    @BeforeClass

    public static void aws() throws IOException {

        Properties props = new Properties();
        props.load(new FileInputStream( "C:\\MyProperties.txt"));

        HashMap<String, String> param = new HashMap<>();
        props.forEach((k, v) -> param.put(k.toString(), v.toString()));
        GlobalContext.getGlobalInstance().setGlobalData(param);

        //AWSParameterStore PS = new AWSParameterStore();
        //HashMap<String, String> param = new HashMap<>();
        //param.putAll(PS.getValuesByPath("/cat/int/"));
        //param.putAll(PS.getValuesByPath("/cat/test-team/"));
        //GlobalContext.getGlobalInstance().setGlobalData(param);



        //TODO: - Trigger only for API Tests
        /*
        Auth auth =new Auth();
        GlobalContext.getGlobalInstance().setGlobalDataValue("Jag_Token", auth.Authenticaion("Jaggaer"));
        */
    	
    	
    }

    @AfterClass
    public static void teardown(){
        GlobalContext.getGlobalInstance().clearGlobalData();
    }

}