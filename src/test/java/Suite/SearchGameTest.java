package Suite;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class SearchGameTest extends TestBase {
	
	
	@BeforeTest
	public void beforetest() throws IOException{
		initialised();

}
	@Test(enabled=false)
	public void serachgametest() throws InterruptedException{
		d.get(Config.getProperty("URL"));
		Thread.sleep(2000l);
		 doDefaultLogin(Config.getProperty("defaultUsername"));// logging in with default username and password
		 Thread.sleep(2000l);
		 click("hp_Searchicon_xpath");
		 Thread.sleep(2000l);
		 input("hp_searchtextbox_xpath","Great Blue");
		 Thread.sleep(3000l);
	// Verify if Great blue game will return
	if(isElementPresent("hp_SearchResultGreatBlue_Selector"))
		System.out.printf("Result Verification---Pass",true);
	else
		Assert.fail("Diffrent image or game");
	
	 d.close();

}
	@Test()
	public void searchgameVegastest() throws InterruptedException{
		d.get(Config.getProperty("URL"));
		Thread.sleep(2000l);
		 doDefaultLogin(Config.getProperty("defaultUsername"));// logging in with default username and password
		 Thread.sleep(2000l);
		 click("hp_vegasTab_xpath");
		 Thread.sleep(2000l);
		 click("vegas_searchicon_xpath");
		 Thread.sleep(200l);
		 input("vegas_searchtextbox_xpath","WILD GAMBLER");
		 Thread.sleep(4000l);
			boolean element=isElementPresent("search_resultVegasWildGamble_Selector");
		 System.out.println(element);
		  click("hp_sidebarMenuIcon_xpath");
		 Thread.sleep(1000);
		 click("hp_sideBarMenu_Logout_xpath");
	    
		
		 

		 
	}
	@Test()
	public void searchLivegames() throws InterruptedException{
		d.get(Config.getProperty("URL"));
		Thread.sleep(2000l);
		 doDefaultLogin(Config.getProperty("defaultUsername"));// logging in with default username and password
		 Thread.sleep(2000l);
		 click("hp_Searchicon_xpath");
		 Thread.sleep(2000l);
		 input("hp_searchtextbox_xpath","Live Games");
		 WebDriverWait wait= new WebDriverWait(d,30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.search-bar-enabled .netplay-games.lr")));
		try{
		 boolean element=d.findElement(By.cssSelector("search_resultLiveRoulette_Selector")).isDisplayed();
		 System.out.println(element);
		 }catch(NoSuchElementException e){
			 //e.getStackTrace();
			 
		 }
		 click("hp_sidebarMenuIcon_xpath");
		 Thread.sleep(1000);
		 click("hp_sideBarMenu_Logout_xpath");
	
	}
}
