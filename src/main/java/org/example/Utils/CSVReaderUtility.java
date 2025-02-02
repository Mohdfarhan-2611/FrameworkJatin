package org.example.Utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.POJO.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {


    public static Iterator<User> readDataFromCSV() throws FileNotFoundException {
        File csvFilePath;
        FileReader fileReader = null;
        CSVReader csvReader;
        List<User> userList;
        User userData;
        String[] line;

        try {
            csvFilePath= new File(System.getProperty("user.dir")+"/src/main/resources/loginData.csv");
            fileReader = new FileReader(csvFilePath);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext();  //Skips the column name


            userList = new ArrayList<User>();
            while ((line = csvReader.readNext())!=null)
            {
                userData = new User(line[0],line[1]);
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
