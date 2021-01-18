package com.Westwingnow_Web.Functionality;


import com.Westwingnow_Web.base.TestBase;
import com.Westwingnow_Web.ObjectRepo.Westwingnow_HomePage_OR;
import com.Westwingnow_Web.Util.PropertyData;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Westwingnow_Web.Util.ReusableFunctions;


public class HomePageWestWing extends TestBase {

    private static Logger logger = Logger.getLogger(HomePageWestWing.class.getName());
    PropertyData data = new PropertyData();
    ReusableFunctions rf = new ReusableFunctions();

    // Android App
    
     
    public static boolean OpenURL(String url)
    {
    	boolean flag = true;
 	    
 	    try
 	    {
 	    	driver.get(url); 	    	
 	    	
 	    	if(Westwingnow_HomePage_OR.AcceptCookies.isDisplayed())
 	    	{Westwingnow_HomePage_OR.AcceptCookies.click();}
 	    	
 	    	Thread.sleep(5000);
 	    }    
    catch(Exception Ex){
        flag = false;
        logger.error("Exception Occurred While Opening URL: "+Ex.getMessage());
    }
    	return flag;
    }
    
    public static boolean validateListofProducts(String screenname)
    { boolean flag = true;
    
      int AllExistingLooksSize = Westwingnow_HomePage_OR.allImages.size();	
      try {
    	  
      if (AllExistingLooksSize <= 0)
      {
    	  flag = false;
      }
      else
      {	  
    	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
    	  logger.info("Page shown list of looks. Number of Listing found");	    	  
    	  ReusableFunctions.takeScreenShotPass(screenname);
      }
      }catch(Exception e){
    	  
    	  logger.error("Exception Occurred While validating looks: "+e.getMessage());
    	  flag = false;
      }
      return flag; 	
    }
    
    public static boolean validateFilter()
    { boolean flag = true;
    
    	try
    	{
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		Thread.sleep(5000);
    		if(Westwingnow_HomePage_OR.Filter.isDisplayed()) {
    		Westwingnow_HomePage_OR.Filter.click();}
    		logger.info("validated filter successfully");
    		ReusableFunctions.takeScreenShotPass("Filter");
    		
    	}
    	catch(Exception ex)
    	{
    		logger.error("Exception Occurred While validating filter: "+ex.getMessage());
      	  flag = false;
    	}
    	
    	return flag;
    }
    
    public static boolean validateSpots(String url)
    {  boolean flag= true;
    	
    	try
    	{
    		 
    		driver.navigate().to(url);
    		
    		String username = prop.getProperty("username");
    		String password = prop.getProperty("pwd");   		
    		login(username, password);
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		Thread.sleep(5000);
    		int AllSpots = Westwingnow_HomePage_OR.allspots.size();	
    		
    		if(AllSpots <=-0)
    		{
    			flag = false;
    		}
    		else
    		{
    			int num = 1;
    			for (WebElement e : Westwingnow_HomePage_OR.allspots)
    			{
    				e.click();
    				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    				ReusableFunctions.takeScreenShotPass("Spot" + num);    				
    				num++;
    				if(num==8)
    				{
    					logger.info("validating first 8 sports");
    					break;
    					
    				}
    			}
    		}
    		
    	}
    	catch(Exception ex)
    	{
    		logger.error("Exception Occurred While validating spots: "+ex.getMessage());
        	  flag = false;
    	}
    	return flag;
    }
    
    public static boolean login(String username, String Pwd)
    {
    	boolean flag = true;
    	try
    	{
    		
//    		Westwingnow_HomePage_OR.LoginIcon.click();	
//    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    		Westwingnow_HomePage_OR.SwitchtoMainLogin.click();
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		Westwingnow_HomePage_OR.username.sendKeys(username);
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		Westwingnow_HomePage_OR.Pwd.sendKeys(Pwd);
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    		Westwingnow_HomePage_OR.checkbox.click();
//    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);    		
    		Westwingnow_HomePage_OR.submit.click();
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		logger.info("Login Successfully");
    		Thread.sleep(20000);
    		//driver.navigate().to(prop.getProperty("WebURL"));
    		
    	}
    	catch(Exception e)
    	{
    		logger.error("Exception Occurred While login: "+e.getMessage());
      	  flag = false;
    	}
    	return flag;
    }

    
    public static boolean Search(String SearchText)
    {
    	boolean flag =true;
    	
    	try
    	{
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		Westwingnow_HomePage_OR.Search.sendKeys(SearchText + Keys.ENTER);    		
    		ReusableFunctions.takeScreenShotPass("Search"); 
    		logger.info("Search the text "+SearchText);    		
    	}
    	catch(Exception e)
    	{
    		logger.error("Exception Occurred While Search: "+e.getMessage());
      	    flag = false;
    	}
    	
    	return flag;
    }
    
    public static boolean ClickWishList()
    {
    	boolean flag =true;
    	
    	try
    	{
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		Westwingnow_HomePage_OR.Item1WishListicon.click();   	
    		//String username = prop.getProperty("username");
    		 //String password = prop.getProperty("pwd");
    		 //loginForWishList(username, password);  
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Thread.sleep(30000);                      
            ReusableFunctions.takeScreenShotPass("Item1WishIconSelected");
            String wishcountvalue= Westwingnow_HomePage_OR.WishListCounter.getText();
            logger.info("Wish counter "+wishcountvalue); 
            Westwingnow_HomePage_OR.WishListBubble.click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            ReusableFunctions.takeScreenShotPass("Item1WishIconSelectedProduct");
            Westwingnow_HomePage_OR.WishListProductDeleteBtn.click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            ReusableFunctions.takeScreenShotPass("Item1WishIconSelectedProductDeleted");           
            
    	}
    	catch(Exception e)
    	{
    		logger.error("Exception Occurred While Click on Wish icon and delete the wish product: "+e.getMessage());
      	    flag = false;
    	}
    	
    	return flag;
    }
    
    
    public static boolean loginForWishList(String username, String Pwd) //This is defect but time being made it separatly.
    {
    	boolean flag = true;
    	try
    	{
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		Westwingnow_HomePage_OR.username_atWishList.sendKeys(username);
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		Westwingnow_HomePage_OR.Pwd_atWishList.sendKeys(Pwd);
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		Westwingnow_HomePage_OR.checkbox_atWishList.click();
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);    		
    		Westwingnow_HomePage_OR.submit_atWishList.click();
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		logger.info("Login Successfully");
    		
    	}
    	catch(Exception e)
    	{
    		logger.error("Exception Occurred While login: "+e.getMessage());
      	  flag = false;
    	}
    	return flag;
    }
}