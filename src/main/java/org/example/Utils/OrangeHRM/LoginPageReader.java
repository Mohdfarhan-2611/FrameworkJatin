package org.example.Utils.OrangeHRM;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.POJO.OrangeHRM.LoginTestData;
import org.example.POJO.OrangeHRM.LoginUser;
import org.example.POJO.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginPageReader {


    public static Iterator<LoginUser> readDataFromJson() throws FileNotFoundException {
        File csvFilePath;
        FileReader fileReader = null;
        CSVReader csvReader;
        List<LoginUser> userList;
        LoginUser userData;
        String[] line;

        try {
            csvFilePath= new File(System.getProperty("user.dir")+"/src/main/resources/OrangeHRM/LoginPage.csv");
            fileReader = new FileReader(csvFilePath);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext();  //Skips the column name


            userList = new ArrayList<LoginUser>();
            while ((line = csvReader.readNext())!=null)
            {
                userData = new LoginUser(line[0],line[1],line[2], line[3]);
                userList.add(userData);
            }

//            for(User user : userList)
//            {
//                System.out.println(user);
//            }



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return userList.iterator();


    }

}
