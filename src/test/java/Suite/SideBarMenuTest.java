package Suite;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class SideBarMenuTest extends TestBase {

	@BeforeTest
	public void beforetest() throws IOException {
		initialised();

	}

	@Test()
	public void menutest() throws InterruptedException {
		d.get(Config.getProperty("URL"));
		doDefaultLogin(Config.getProperty("defaultUsername"));
		Thread.sleep(3000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(2000L);
		click("hp_sidebarMenu_GettingStarted_xpath");
		Thread.sleep(1000L);
		click("hp_sidebarMenuGettingStarted_HowToGetStarted_xpath");
		Thread.sleep(1000L);
		// Verify if the user navigate to Getting Started page.
		String text = getText("GettingStarted_xpath");
		if (getText("GettingStarted_xpath").equalsIgnoreCase("Getting Started"))
			System.out.println(text);
		else
			System.out.println(false);
		Thread.sleep(1000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(1000L);
		click("hp_sideBarMenu_Logout_xpath");

	}

	@Test()
	public void menutest1() throws InterruptedException {
		d.get(Config.getProperty("URL"));
		doDefaultLogin(Config.getProperty("defaultUsername"));
		Thread.sleep(3000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(3000L);
		click("hp_sidebarMenu_GettingStarted_xpath");
		Thread.sleep(1000L);
		click("hp_sideBarMenuGettingStarted_HowToDeposit_xpath");
		String text1 = getText("HowToDesposit_xpath");
		if (getText("HowToDesposit_xpath").equalsIgnoreCase("How To Deposit"))
			System.out.println(text1);
		else
			System.out.println(false);
		Thread.sleep(1000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(1000L);
		click("hp_sideBarMenu_Logout_xpath");
	}

	@Test()
	public void menutest2() throws InterruptedException {
		d.get(Config.getProperty("URL"));
		doDefaultLogin(Config.getProperty("defaultUsername"));
		Thread.sleep(3000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(3000L);
		click("hp_sidebarMenu_GettingStarted_xpath");
		Thread.sleep(1000L);
		click("hp-sidebarMenuGettingStarted_HowToWithdraw_xpath");
		String text2 = getText("HowToWithdraw_xpath");
		if (getText("HowToWithdraw_xpath").equalsIgnoreCase("How To Withdraw")) {
			System.out.println(text2);
		} else {
			System.out.println(false);
		}
		Thread.sleep(1000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(1000L);
		click("hp_sideBarMenu_Logout_xpath");
		

	}

	@Test()
	public void menutest3() throws InterruptedException {
		d.get(Config.getProperty("URL"));
		doDefaultLogin(Config.getProperty("defaultUsername"));
		Thread.sleep(3000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(2000L);
		click("hp_sidebarMenu_GettingStarted_xpath");
		Thread.sleep(1000L);
		click("hp_sidebarMenuGettingStarted_IsMyDepositSafe_xpath");
		String text3 = getText("IsMyDepositSafe_xpath");
		if (getText("IsMyDepositSafe_xpath").equalsIgnoreCase("Is my Deposit Safe?"))
			System.out.println(text3);
		else
			System.out.println(false);
		Thread.sleep(1000L);
		 click("hp_sidebarMenuIcon_xpath");
		 Thread.sleep(1000L);
		 click("hp_sideBarMenu_Logout_xpath");
		// d.quit();

	}

	@Test()
	public void menutest4() throws InterruptedException {
		d.get(Config.getProperty("URL"));
		doDefaultLogin(Config.getProperty("defaultUsername"));
		Thread.sleep(3000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(2000L);
		click("hp_sidebarMenu_GettingStarted_xpath");
		Thread.sleep(1000L);
		click("hp_sidebarMenuGettingStarted_Security_xpath");
		Thread.sleep(1000L);
		String text4 = getText("Security_xpath");
		if (getText("Security_xpath").equalsIgnoreCase("Security"))
			System.out.println(text4);
		else
			System.out.println(false);
		Thread.sleep(1000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(1000L);
		click("hp_sideBarMenu_Logout_xpath");
		// d.quit();
	}

	@Test()
	public void helptest() throws InterruptedException {
		d.get(Config.getProperty("URL"));
		doDefaultLogin(Config.getProperty("defaultUsername"));
		Thread.sleep(3000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(2000L);
		click("hp_sideBarMenu_Help_xpath");
		Thread.sleep(1000L);
		String text5 = getText("contact-Us_xpath");
		if (getText("contact-Us_xpath").equalsIgnoreCase("CONTACT US"))
			System.out.println(text5);
		else
			System.out.println(false);
		Thread.sleep(1000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(1000L);
		click("hp_sideBarMenu_Logout_xpath");
		// d.quit();
	}

	@Test()
	public void Tvpresentertest() throws InterruptedException {
		d.get(Config.getProperty("URL"));
		doDefaultLogin(Config.getProperty("defaultUsername"));
		Thread.sleep(3000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(3000L);
		click("hp_sideBarMenu_TVPresenter_xpath");
		Thread.sleep(1000L);
		String text6 = getText("presenters_xpath");
		if (getText("presenters_xpath").equalsIgnoreCase("Presenters"))
			System.out.println(text6);
		else
			System.out.println(false);
		Thread.sleep(1000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(1000L);
		click("hp_sideBarMenu_Logout_xpath");
		// d.quit();
	}

	/*
	 * @Test//(enabled=false) public void viptest()throws InterruptedException{
	 * d.get(Config.getProperty("URL"));
	 * doDefaultLogin(Config.getProperty("defaultUsername"));
	 * Thread.sleep(3000L); click("hp_sidebarMenuIcon_xpath");
	 * click("hp_sideBarMenu_VIP_xpath"); Thread.sleep(1000L); String
	 * text7=getText("benefits_xpath");
	 * if(getText("benefits_xpath").equalsIgnoreCase("Benefits"))
	 * System.out.println(text7); else System.out.println(false);
	 * Thread.sleep(1000L); click("hp_sidebarMenuIcon_xpath");
	 * Thread.sleep(1000L); click("hp_sideBarMenu_Logout_xpath");
	 * Thread.sleep(1000L); d.close(); }
	 */
	@Test()
	public void RespGamblingtest() throws InterruptedException {
		d.get(Config.getProperty("URL"));
		doDefaultLogin(Config.getProperty("defaultUsername"));
		Thread.sleep(3000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(2000);
		click("hp_sideBarMenu_ResponsibleGambling_xpath");
		Thread.sleep(1000L);
		String text8 = getText("RespGambling_xpath");
		if (getText("RespGambling_xpath").equalsIgnoreCase("Responsible Gambling"))
			System.out.println(text8);
		else
			System.out.println(false);
		Thread.sleep(1000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(1000L);
		click("hp_sideBarMenu_Logout_xpath");
		Thread.sleep(1000L);
		// d.quit();
	}

	@AfterMethod(enabled = false)
	public void close() {
		quit();

	}
}