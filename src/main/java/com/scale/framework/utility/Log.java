package com.scale.framework.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

public class Log {

    private static boolean root=false;

    public static Logger getLogger(Class<?> cls){
        if(root){
            return LogManager.getLogger(cls);
        }
        //PropertyConfigurator.configure("config//log4j2.properties");
        root = true;
        return LogManager.getLogger(cls);
    }
}