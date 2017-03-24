package Suite;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class LiveTab  extends TestBase{

	
	

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
		 click("Live_RouletteExpressPremiumPlay_Selector");
		 Thread.sleep(1000L);
		 d.navigate().back();
		  Thread.sleep(1000L);
			click("hp_sidebarMenuIcon_xpath");
			Thread.sleep(1000L);
			click("hp_sideBarMenu_Logout_xpath");
}
}