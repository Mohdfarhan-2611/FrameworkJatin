package org.example.Utils;


import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import org.example.POJO.TestData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONReaderUtility {


     public static TestData readDataFromJson() throws FileNotFoundException {
          Gson gson = new Gson();
          TestData data = null;
          File jsonfilepath;
          FileReader fileReader;

         try {
             jsonfilepath = new File(System.getProperty("user.dir")+"/src/main/resources/loginData.JSON");
             fileReader = new FileReader(jsonfilepath);
             data = gson.fromJson(fileReader, TestData.class);   ////Deserialization
         } catch (FileNotFoundException e) {
             throw new RuntimeException(e);
         } catch (JsonSyntaxException e) {
             throw new RuntimeException(e);
         } catch (JsonIOException e) {
             throw new RuntimeException(e);
         }
         return data;
     }



}
