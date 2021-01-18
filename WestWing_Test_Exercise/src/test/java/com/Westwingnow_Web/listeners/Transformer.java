package com.Westwingnow_Web.listeners;

import com.Westwingnow_Web.base.TestBase;
import com.Westwingnow_Web.testData.DataReader;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Transformer implements IAnnotationTransformer {

    static TestBase testBase = new TestBase();
   
    static HashMap<String, HashMap<String, String>> runmodeData = DataReader.testDataMappedToTestName(TestBase.prop.getProperty("TestDataExcelFileName"), testBase.prop.getProperty("RunModeSheetName"));

    /**
     * This method is used for getting the runmode for current test case
     * @param annotation - instance of ITestAnnotation Interface in TestNG
     * @param testClass - instance of class to implement ITestAnnotation
     * @param testConstructor -instance of constructor to implement ITestAnnotation
     * @param testMethod - instance of Method class to get the current executing method
     */
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {            
            System.out.println(testMethod.getName());
            System.out.println(runmodeData);
            annotation.setEnabled(DataReader.isRunnable(testMethod.getName(), runmodeData));
    }
}
