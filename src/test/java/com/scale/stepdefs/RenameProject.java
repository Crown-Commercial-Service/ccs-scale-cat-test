package com.scale.stepdefs;

import com.scale.context.GlobalContext;
import cucumber.api.java.en.Given;

import java.util.HashMap;

public class RenameProject {
    HashMap<String, String> ConfigData=GlobalContext.getGlobalInstance().getGlobalData();

    @Given("Global Data from AWS and Auth")
    public void globalDataFromAWSAndAuth() {
        System.out.println("ConfigData Size "+ConfigData.size());
        ConfigData.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
