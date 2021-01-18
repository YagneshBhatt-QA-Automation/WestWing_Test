package com.Westwingnow_Web.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.Westwingnow_Web.base.TestBase;




public class Westwingnow_HomePage_OR extends TestBase{
	
	

	@FindAll({@FindBy(tagName  = "img")})
	public static java.util.List<WebElement> allImages;
	
	@FindBy(xpath = "//*[@id=\'onetrust-accept-btn-handler\']")
	public static WebElement AcceptCookies;
	
	@FindBy(xpath = "//div[@class=\'looksMain__filters__value__filter\']")	
	public static WebElement Filter;
	
	@FindAll({@FindBy(xpath  = "//div[@class='room__spot__icon__circle js-circle']")})
	public static java.util.List<WebElement> allspots;
	
	@FindBy(xpath = "//input[@name='LoginForm[email]']")
	public static WebElement username;
	
	@FindBy(xpath = "//input[@name='LoginForm[password]']")
	public static WebElement Pwd;

	@FindBy(xpath = "//input[@id='is_newsletter_subscribed']")
	public static WebElement checkbox;
	
	@FindBy(xpath = "//button[@class='btn-primary blockClubRegistrationForm__submit qa-blockClubRegistrationForm__submit']")
	                                  
	public static WebElement submit;	
	//
	@FindBy(xpath = "//div[@class='IconsButtonTray__IconItemWrapper-sc-1k6jcrl-6 kQuyVZ qa-header__sign-up-link']")
	public static WebElement LoginIcon;
	
	@FindBy(xpath = "//button[@class='blockRegisterPanel__switchButton qa-blockRegisterPanel__switchButton']")
	public static WebElement SwitchtoMainLogin;
	
	//************************************
	
	@FindBy(xpath = "//input[@data-testid='search-input']")
	public static WebElement Search;	
	
	
	@FindBy(xpath = "//*[@id=\"app-root\"]/div/div[1]/div[7]/div/div/main/div/div[2]/div[1]/a/div/div[2]/div[2]")
	public static WebElement Item1WishListicon;
	
	@FindBy(xpath = "//input[@name='email']")
	public static WebElement username_atWishList;
	
	@FindBy(xpath = "//input[@name='password']")
	public static WebElement Pwd_atWishList;
	
	@FindBy(xpath = "//input[@name='isTermsAccepted']")	
	public static WebElement checkbox_atWishList;
	
	@FindBy(xpath = "//button[@data-testid='login_reg_submit_btn']")
	public static WebElement submit_atWishList;
	
	@FindBy(xpath = "//span[@data-testid='wishlist-counter']")
	public static WebElement WishListCounter;
	
	@FindBy(xpath = "//div[@data-testid='wishlist-bubble']")
	public static WebElement WishListBubble;	
	
	
	@FindBy(xpath = "//button[@class=\"blockListProduct__delete qaBlockListProduct__delete\"]")
	public static WebElement WishListProductDeleteBtn;
	
	
	
	
	
	
	

	
}
