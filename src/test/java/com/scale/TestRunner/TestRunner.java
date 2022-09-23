package com.scale.TestRunner;

import com.scale.context.GlobalContext;
import com.scale.framework.utility.AWSParameterStore;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/FeatureFiles"},
        glue={"com.scale.stepdefs", "com.scale.context"},
        monochrome = true,
        plugin = { "pretty", "html:target/cucumber-html-reports/report.html", "json:target/cucumber-html-reports/cucumber.json"}
        ,tags = "@1FC-Flow",
        dryRun = false
)


public class TestRunner {

    @BeforeClass
    public static void aws() {
        //AWSParameterStore PS = new AWSParameterStore();
        //HashMap<String, String> param = new HashMap<>();
        //param.putAll(PS.getValuesByPath("/cat/int/"));
        //param.putAll(PS.getValuesByPath("/cat/test-team/"));
        //GlobalContext.getGlobalInstance().setGlobalData(param);

    	//New Code
    	
    	Properties props = new Properties();
        try {
			props.load(new FileInputStream( "C:\\Users\\571154\\OneDrive - Cognizant\\Desktop\\MyProperties.txt"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}



       HashMap<String, String> param = new HashMap<>();
        props.forEach((k, v) -> param.put(k.toString(), v.toString()));
        GlobalContext.getGlobalInstance().setGlobalData(param);
    	
    	
    	
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