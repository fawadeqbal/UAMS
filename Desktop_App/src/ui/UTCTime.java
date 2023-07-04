/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.TimeZone;   
import java.text.ParseException;
  
// create class UTCTimeExample1 to get the current UTC time by using SimpleDateFormat  
public class UTCTime {  
      
    // main() method start  
    public static void main(String args[])  
    {  
        // use try-catch block to execute the code or catch the exception  
        try {  
            // print current time zone   
            System.out.println("IST Time is:"+new Date());  
            System.out.println("UTC Time is: "+getCurrentUtcTime());  
        }   
        // for handling parsing errors and exceptions  
        catch (ParseException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
      
    // create getCurrentUtcTime() method to get the current UTC time   
    public static Date getCurrentUtcTime() throws ParseException {  // handling ParseException  
        // create an instance of the SimpleDateFormat class  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");  
        // set UTC time zone by using SimpleDateFormat class  
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));  
        //create another instance of the SimpleDateFormat class for local date format  
        SimpleDateFormat ldf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");  
        // declare and initialize a date variable which we return to the main method  
        Date d1 = null;  
        // use try catch block to parse date in UTC time zone  
        try {  
            // parsing date using SimpleDateFormat class  
            d1 = ldf.parse( sdf.format(new Date()) );  
        }   
        // catch block for handling ParseException  
        catch (java.text.ParseException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
            System.out.println(e.getMessage());  
        }  
        // pass UTC date to main method.  
        return d1;  
    }  
} 