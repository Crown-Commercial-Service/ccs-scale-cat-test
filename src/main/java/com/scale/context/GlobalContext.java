package com.scale.context;

import java.util.HashMap;
import java.util.Map;

public class GlobalContext {
    private static GlobalContext globalInstance = null;
    private HashMap<String,String> awsdata= new HashMap<>();

    private GlobalContext() {
    }
    public static GlobalContext getGlobalInstance() {
        if (globalInstance == null)
            globalInstance = new GlobalContext();
        return globalInstance;
    }

    public void setGlobalDataValue(String Key, String Value){
        awsdata.put(Key, Value);
    }

    public String getGlobalDataValue(String Key){
        return awsdata.get(Key);
    }

    public void setGlobalData(HashMap<String,String> map){
        awsdata.putAll(map);
    }

    public HashMap<String, String> getGlobalData(){
        return awsdata;
    }
}