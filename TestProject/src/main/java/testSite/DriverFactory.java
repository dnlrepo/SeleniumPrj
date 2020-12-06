package testSite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import  java.sql.Connection;
import  java.sql.Statement;
import  java.sql.ResultSet;
import  java.sql.DriverManager;
import  java.sql.SQLException;

public class DriverFactory {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static DriverManager dbQuery;

    private DriverFactory(){
        //prevent instantiation
    }

    public static WebDriver getChromeDriver(){
        if(driver==null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriverWait getWebDriverWait(){
        if(wait==null){
            wait = new WebDriverWait(getChromeDriver(),30);
        }
        return wait;
    }

    public static DriverManager getDriverManager(String queryString) throws ClassNotFoundException, SQLException {

            //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
            String dbUrl = "jdbc:mysql://localhost:3036/emp";

            //Database Username
            String username = "root";

            //Database Password
            String password = "guru99";


        //Load mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");

            //Create Connection to DB
            Connection con = DriverManager.getConnection(dbUrl,username,password);

            //Create Statement Object
            Statement stmt = con.createStatement();

            // Execute the SQL Query. Store results in ResultSet
            ResultSet rs= stmt.executeQuery(queryString);

            // While Loop to iterate through all data and print results
        while (rs.next()){
            String myName = rs.getString(1);
            String myAge = rs.getString(2);
            System. out.println(myName+"  "+myAge);
        }
        // closing DB Connection
        con.close();

        return  dbQuery;
    }



}
