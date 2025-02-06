package org.example.Utils;

import org.example.Constant.Env;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    private static final String QA_PROPERTY_PATH = System.getProperty("user.dir") + "/src/test/resources/QA.Properties";
    private static final String UAT_PROPERTY_PATH = System.getProperty("user.dir")+"/src/test/resources/UAT.Properties";

    public static String readkey(String key) throws IOException {

        Properties properties = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(UAT_PROPERTY_PATH);
            properties = new Properties();
            properties.load(fileInputStream);
            return properties.getProperty(key.toLowerCase());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}