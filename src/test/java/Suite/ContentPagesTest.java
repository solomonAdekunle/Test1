package Suite;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class ContentPagesTest  extends TestBase{
	
	@BeforeTest
	public void beforetest() throws IOException{
		initialised();

}
	@Test
	public void termsAndcondtest() throws InterruptedException{
		d.get(Config.getProperty("URL"));
		Thread.sleep(2000l);
		 doDefaultLogin(Config.getProperty("defaultUsername"));// logging in with default username and password
		 Thread.sleep(2000l);
		click("hp_footerTerm&Conditions_Selector");
		String PageHeaderTitle=getText("termsAndcond_xpath");
		//Assert.assertEquals(PageHeaderTitle, "Terms and Conditions for UK");
		if(PageHeaderTitle.equalsIgnoreCase("Terms and Conditions for UK"))
			System.out.printf("Result Verification---Pass",true);
		else
			Assert.fail();
			//System.out.printf("Result Verification---Failed",true);
		click("hp_Term&ConditionsBackButton_xpath");
		Thread.sleep(2000l);
		click("hp_footerPrivacyPolicy_Selector");// navigate to Privacy policy page by clicking on the privacy policy link
		Thread.sleep(2000l);
		String HeaderTitle1=getText("privacyPol_xpath");
		if(HeaderTitle1.equalsIgnoreCase("Privacy Policy UK"))
			System.out.printf("Result Verification---Pass",true);
		else
			Assert.fail();
		click("hp_Term&ConditionsBackButton_xpath");// click back button
		Thread.sleep(2000l);
		click("hp_footerResponisbleGambling_Selector");
		Thread.sleep(2000l);
		String HeaderTitle2=getText("RespGambling_xpath");
		if(HeaderTitle2.equalsIgnoreCase("Responsible Gambling"))
			System.out.printf("Result Verification---Pass",true);
		else
			Assert.fail();
		
		Thread.sleep(1000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(1000L);
		click("hp_sideBarMenu_Logout_xpath");

}
}