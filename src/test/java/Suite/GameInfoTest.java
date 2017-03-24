package Suite;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class GameInfoTest extends TestBase {
	
	
	@BeforeTest
	public void beforetest() throws IOException{
		initialised();

}
	@Test
	public void lunchRouletteExpstest() throws InterruptedException{
		d.get(Config.getProperty("URL"));
		Thread.sleep(2000l);
		 doDefaultLogin(Config.getProperty("defaultUsername"));// logging in with default username and password
		 Thread.sleep(2000l);
		 click("hp_LiveTab_xpath");
		 Thread.sleep(2000l);
		 click("live_RouletteExpressPremium_xpath");
		 Thread.sleep(2000l);
		 click("live_RouletteExpressPremium_MoreInfo_Selector");
		 Thread.sleep(2000l);
		 // Verify that user can nivaget to Roulette Express Premium
		 String text=getText("RouletteExpPremium_xpath");
		 if(text.equalsIgnoreCase("Roulette Express Premium"))
			 System.out.println(text);
		 else
			 System.out.println(false);
		 System.out.println(d.getTitle());
		 String ExpectedRes="Roulette Express Premium - Live Roulette | SuperCasino";
		 String Actual=d.getTitle();
		 Assert.assertEquals(Actual, ExpectedRes, "equal");
		 // Click logout button
		 Thread.sleep(1000L);
			click("hp_sidebarMenuIcon_xpath");
			Thread.sleep(1000L);
			click("hp_sideBarMenu_Logout_xpath");
		 }
	

//RouletteExpPremium_xpath
}
