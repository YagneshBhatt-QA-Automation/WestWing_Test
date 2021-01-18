package com.Westwingnow_Web.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.*;
import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import com.Westwingnow_Web.ObjectRepo.*;



public class TestBase{

    public static Properties prop;
    public static RemoteWebDriver driver;
    private static Logger logger;
    

    static{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hhmmss");
        System.setProperty("current.date", dateFormat.format(new Date()));
    }

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/Westwingnow_Web/config/config.properties");
            prop.load(inputStream);

            PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/resource/log4j.properties");
            logger = Logger.getLogger(MethodHandles.lookup().lookupClass());

        } catch (FileNotFoundException Ex) {
            logger.info("File not found: " + Ex.getMessage());

        } catch (IOException Ex) {
            logger.info("Exception occurred: " + Ex.getMessage());
        }
    }

    /**
     * This is singleton driver initialization method
     * @throws MalformedURLException - In case of invalid appium server url
     */
    public static void driverInitialization() throws MalformedURLException{
        if (driver == null) {
            switch (prop.getProperty("Platform")){
                case "android":
                    logger.info("Running Tests On Android Platform.");
                    androidSetup();
                    break;
                case "browser_stack":
                    logger.info("Running Tests On Browser Stack.");
                    browserStack();
                    break;
                case "ios":
                    logger.info("Running Tests On IOS Platform.");
                    iosSetup();
                    break;
                case "web":
                    logger.info("Running Tests On web Platform.");                    
                    webSetup();
                    break;    
                default:
                    logger.info("Running Tests On Browser Stack.");
                    browserStack();
            }
        }
    }

    /**
     * This method is used for android driver setup
     * @throws MalformedURLException - In case of invalid appium server url
     */
    private static void androidSetup() throws MalformedURLException {
    	//TO DO Setup
    }

    /**
     * This method is used for browser stack driverInitialization
     * @throws MalformedURLException - In case of invalid browser stack server url
     */
    private static void webSetup() throws MalformedURLException {
        
        String ChromedriverPath = System.getProperty("user.dir") + "\\Driver\\chromedriver.exe";        
        System.out.println(ChromedriverPath);
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ybhatt\\test-def-gbl\\chromedriver\\chromedriver.exe"); 
        driver = new ChromeDriver();    	
    	driver.manage().window().maximize();
        logger.info("Starting brower");       
        
		
		PageFactory.initElements(driver, Westwingnow_HomePage_OR.class);
		
    }
    /**
     * This method is used for web driverInitialization
     * @throws MalformedURLException - In case of invalid web  url
     */
    private static void browserStack() throws MalformedURLException {
    	//TO DO Setup
    }

    /**
     * This method is used for ios driver setup
     * @throws MalformedURLException - In case of invalid appium server url
     */
    private static void iosSetup() throws MalformedURLException{
    	//TO DO Setup
    }

}