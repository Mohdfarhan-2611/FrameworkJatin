package org.example.Utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.POJO.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {

    public static Iterator<User> readDataFromExcel()  {

        File xlsxfile = new File(System.getProperty("user.dir")+"/src/main/resources/loginData.xlsx");
        XSSFWorkbook xssfworkbook = null;
        XSSFSheet xssfSheet;
        Iterator<Row> rowiterator;
        Row row;
        Cell emailAddresscell;
        Cell passwordcell;
        List<User> userList=null;
        User user;

        try {
            xssfworkbook = new XSSFWorkbook(xlsxfile);
            xssfSheet = xssfworkbook.getSheet("LoginData");
            userList = new ArrayList<User>();
            rowiterator= xssfSheet.iterator();
            rowiterator.next();

            while (rowiterator.hasNext())
            {
                row = rowiterator.next();
                emailAddresscell = row.getCell(0);
                passwordcell = row.getCell(1);
                user = new User(emailAddresscell.toString(),passwordcell.toString());
                userList.add(user);
                xssfworkbook.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        return userList.iterator();
    }

}
