package com.scale.framework.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

	 private Properties properties;
	    private String path = "config//ApplicationConfig.properties";
	    public ConfigurationReader()
	    {
	        BufferedReader reader;
	        try {
	            reader = new BufferedReader(new FileReader(path));
	            properties = new Properties();
	            try {
	                properties.load(reader);
	                reader.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            throw new RuntimeException("ApplicationConfig.properties not found at " + path);
	        }
	    }

	    public String getApplicationURL()
	    {
	        String URL = properties.getProperty("appURL");
	        if(URL!= null)
	            return URL;
	        else
	            throw new RuntimeException("Application URL not specified in the ApplicationConfig.properties file.");
	    }

	    public String get(String key)
	    {
	        String value = properties.getProperty(key);
	        if(value!= null)
	            return value;
	        else
	            throw new RuntimeException(key + " not specified in the ApplicationConfig.properties file.");
	    }
	    
	    public String postgressqlPort()
	    {
	        String value = properties.getProperty("ccs.postgres.port");
	        if(value!= null)
	            return value;
	        else
	            throw new RuntimeException(" Key not specified in the ApplicationConfig.properties file.");
	    }
	    public String postgressqlServer()
	    {
	        String value = properties.getProperty("ccs.postgres.server");
	        if(value!= null)
	            return value;
	        else
	            throw new RuntimeException(" Key not specified in the ApplicationConfig.properties file.");
	    }
	    public String postgressqlDataBaseName()
	    {
	        String value = properties.getProperty("ccs.postgres.database");
	        if(value!= null)
	            return value;
	        else
	            throw new RuntimeException(" Key not specified in the ApplicationConfig.properties file.");
	    }
	    public String postgressqlUser()
	    {
	        String value = properties.getProperty("ccs.postgres.user");
	        if(value!= null)
	            return value;
	        else
	            throw new RuntimeException(" Key not specified in the ApplicationConfig.properties file.");
	    }
	    public String postgressqlPassword()
	    {
	        String value = properties.getProperty("ccs.postgres.password");
	        if(value!= null)
	            return value;
	        else
	            throw new RuntimeException(" Key not specified in the ApplicationConfig.properties file.");
	    }
	    
}