package com.cb.automation.pages;

import com.cb.automation.base.BasePage;
import com.cb.automation.base.LocalDriverContext;
import org.openqa.selenium.By;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteTxt extends BasePage {

    public static void writeText(String locator,String locator1){


    Date date = new Date() ;
    SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-yyyy HH-mm") ;

    Writer writer = null;

    //      Find the value and write it to the text file 'Smoke_004 DD-MM-yyyy HH-mm.txt'
    try {
        writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("Smoke_004 " + dateFormat.format(date) + ".txt"), "utf-8"));
        writer.write("ProductName: " +  locator);
        writer.write("               ProductPrice: " +  locator1);

    } catch (IOException ex) {
        // report
    } finally {
        try {
            writer.close();
        } catch (Exception ex) {
        }
    }
    }
}
