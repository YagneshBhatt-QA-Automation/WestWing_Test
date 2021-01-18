package com.Westwingnow_Web.testcases;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Westwingnow_Web.Functionality.HomePageWestWing;
import com.Westwingnow_Web.Util.ReusableFunctions;
import com.Westwingnow_Web.base.TestBase;
import com.Westwingnow_Web.testData.DataReader;
import com.Westwingnow_Web.listeners.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class DriverScript extends TestBase {
    
    private static SoftAssert _softAssert;
    private static String testCaseName = null;
    private static ExtentTest extentLogger = null;
    private static ExtentReports extent = null;
    private static Logger logger = null;

    private static HashMap<String, HashMap<String, String>> tcData = DataReader.
            testDataMappedToTestName(prop.getProperty("TestDataExcelFileName"), prop.getProperty("TestDataSheetName"));

    @BeforeMethod
    public static void setUp(Method method) throws IOException {
        driverInitialization();       
        _softAssert = new SoftAssert();
        testCaseName = method.getName();
        extent = ExtentManager.getReporter();
        extentLogger = ExtentManager.getLogger(testCaseName);
        logger = Logger.getLogger(DriverScript.class.getName());
    }

    @Test(priority = 1)
    public void VerifyLooksListingPageandDetailPage(){
        logger.info("Running Step: VerifyLooksListingPage");
        String URL = prop.getProperty("WebURL");
        
        if(!HomePageWestWing.OpenURL(URL))
        {
        	logger.error("Open URL unsuccessfull ");
           _softAssert.fail("Open URL unsuccessfull ");
        }        
              
        if(!HomePageWestWing.validateFilter())
        {
        	logger.error("fail to validate filter");
            _softAssert.fail("fail to validate filter");
        }
        
        if(!HomePageWestWing.validateListofProducts("Listoflooks"))
        {
        	logger.error("fail to validate list of products");
           _softAssert.fail("fail to validate list of products");
        }
        
        
        
        URL = prop.getProperty("WebURL2");
        
        if(!HomePageWestWing.validateSpots(URL))
        {
        	logger.error("fail to validate Sports");
            _softAssert.fail("fail to validate Sports");
        }
        
        _softAssert.assertAll();
    }

    @Test(priority = 2)
    public void VerifyWishListFunctionality(){
    
    	 logger.info("Running Step: VerifyWishListFunctionality");
         //String URL = prop.getProperty("WebURL");
         
//         if(!HomePageWestWing.OpenURL(URL))
//         {
//         	logger.error("Open URL unsuccessfull ");
//            _softAssert.fail("Open URL unsuccessfull ");
//         }       
        
         
         String SearchText = tcData.get(testCaseName).get("Search");
         
         if(!HomePageWestWing.Search(SearchText))
         {
         	logger.error("Search unsuccessfull ");
            _softAssert.fail("Search unsuccessfull ");
         }
         
         if(!HomePageWestWing.ClickWishList())
         {
         	logger.error("Click on wish icon unsuccessfull ");
            _softAssert.fail("Click on wish icon unsuccessfull ");
         }        
         
         
         
         
         _softAssert.assertAll();
    }
    
    @AfterMethod
    public void getResult(ITestResult result) throws Exception{

        if(result.getStatus() == ITestResult.FAILURE){
            String screenShotPath = ReusableFunctions.takeScreenShot("FailWebPage");
            extentLogger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            extentLogger.fail(result.getThrowable());
            extentLogger.fail("Snapshot below: " + extentLogger.addScreenCaptureFromPath(screenShotPath, testCaseName));

        }else if(result.getStatus() == ITestResult.SKIP){
            extentLogger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test case SKIPPED due to below issues:", ExtentColor.GREY));
            extentLogger.skip(result.getThrowable());

        }else if(result.getStatus() == ITestResult.SUCCESS){
            extentLogger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test case PASSED.", ExtentColor.GREEN));
        }

        
    }
    @AfterTest
    public void tearDown(){
        extent.flush();
        driver.quit();
    }
}

