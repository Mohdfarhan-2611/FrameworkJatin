package org.example.DataProvider;

import org.example.POJO.User;
import org.example.Utils.CSVReaderUtility;
import org.example.Utils.ExcelReaderUtility;
import org.example.Utils.JSONReaderUtility;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderGETDATA {


    @DataProvider(name="LOGINDATAFROMJSONFILE")
    public static Iterator<Object[]> getLoginDatafromJson() throws FileNotFoundException
    {
        List<Object[]> listdatafromjson = new ArrayList<Object[]>();
        for(User user : JSONReaderUtility.readDataFromJson().getData())
        {
            listdatafromjson.add(new Object[] {user});
        }
        return listdatafromjson.iterator();
    }

    @DataProvider(name="LOGINDATAFROMCSVFILE")
    public static Iterator<User> getLoginDatafromCSV() throws FileNotFoundException {
        return CSVReaderUtility.readDataFromCSV();
    }


    @DataProvider(name="LOGINDATAFROMEXCELFILE")
    public static Iterator<User> getLoginDatafromExcel() throws FileNotFoundException {
        return ExcelReaderUtility.readDataFromExcel();
    }

}
