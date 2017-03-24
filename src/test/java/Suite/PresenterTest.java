package Suite;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class PresenterTest extends TestBase {
	
	
	@BeforeTest
	public void beforetest() throws IOException{
		initialised();


}
	@Test
	public void presenterstest() throws InterruptedException{
		d.get(Config.getProperty("URL"));
		 doDefaultLogin(Config.getProperty("defaultUsername"));
		 Thread.sleep(3000L);
		 click("hp_sidebarMenuIcon_xpath");
		 Thread.sleep(1000L);
		 click("hp_sideBarMenu_TVPresenter_xpath");
		 Thread.sleep(1000L);
		 click("presenter_FindoutmoreLeeBaldry_xpath");
		 Thread.sleep(1000L);
		 String P1=getText("presenterName1_xpath");
		 if(P1.equalsIgnoreCase("Lee Baldry"))// Verify if the name of displayed on the page is the Lee Baldry
			 System.out.printf("Result Verification---Pass",true);
		 else
			 Assert.fail();
		 Thread.sleep(3000L);
		 click("hp_Term&ConditionsBackButton_xpath");
		 Thread.sleep(2000L);
		 click("presenter_FindoutmoreEmilyDeCosimo_xpath");
		 Thread.sleep(1000L);
		 String P2=getText("presenterName2_xpath");
		 if(P2.equalsIgnoreCase("Emily De Cosimo"))
			 System.out.printf("Result Verification---Pass",true);
		 else
			 Assert.fail();
		 Thread.sleep(3000L);
		 click("hp_Term&ConditionsBackButton_xpath");
		 Thread.sleep(2000L);
		 click("presenter_FindoutmoreDerekGibbons_xpath");
		 Thread.sleep(1000L);
		 String P3=getText("presenterName3_xpath");
		 if(P3.equalsIgnoreCase("Derek Gibbons"))
			 System.out.printf("Result Verification---Pass",true);
		 else
			 Assert.fail();
		 Thread.sleep(3000L);
		 click("hp_Term&ConditionsBackButton_xpath");
		 Thread.sleep(3000L);
		 click("preneter_FindoutmoreAnnaJardine_xpath");
		 Thread.sleep(3000L);
		 String P4=getText("presenterName4_xpath");
		 if(P4.equalsIgnoreCase("Anna Jardine Jones"))
			 System.out.printf("Result Verification---Pass",true);
		 else
			 Assert.fail();
		 Thread.sleep(3000L);
		 click("hp_Term&ConditionsBackButton_xpath");
		 Thread.sleep(2000L);
		 click("presenter_FindoutmoreRobLamarr_xpath");
		 Thread.sleep(3000L);
		 String P5=getText("presenterName5_xpath");
		 if(P5.equalsIgnoreCase("Rob Lamarr"))
			 System.out.printf("Result Verification---Pass",true);
		 else
			 Assert.fail();
		 Thread.sleep(3000L);
		 click("hp_Term&ConditionsBackButton_xpath");
		 Thread.sleep(2000L);
		 click("presenter_FindoutmoreBrynLucas_xpath");
		 Thread.sleep(3000L);
		 String P6=getText("presenterName6_xpath");
		 Thread.sleep(3000L);
		 if(P6.equalsIgnoreCase("Bryn Lucas"))
			 System.out.printf("Result Verification---Pass",true);
		 else
			 Assert.fail();
		 Thread.sleep(3000L);
		 click("hp_Term&ConditionsBackButton_xpath");
		 Thread.sleep(2000L);
		 click("presenter_FindoutmoreJohnMason_xpath");
		 Thread.sleep(3000L);
		 String P7=getText("presenterName7_xpath");
		 if(P7.equalsIgnoreCase("John Mason"))
			 System.out.printf("Result Verification---Pass",true);
		 else
			 Assert.fail();
		 Thread.sleep(3000L);
		 click("hp_Term&ConditionsBackButton_xpath");
		 Thread.sleep(2000L);
		 click("presenter_FindoutmoreEilidhNairn_xpath");
		 Thread.sleep(3000L);
		 String P8=getText("presenterName8_xpath");
		 Thread.sleep(3000L);
		 if(P8.equalsIgnoreCase("Eilidh Nairn"))
			 System.out.printf("Result Verification---Pass",true);
		 else
			 Assert.fail();
		 Thread.sleep(3000L);
		 click("hp_Term&ConditionsBackButton_xpath");
		 Thread.sleep(2000L);
		 click("presnter_FindoutmoreHelenShephard_xpath");
		 Thread.sleep(3000L);
		 String P9=getText("presenterName9_xpath");
		 Thread.sleep(3000L);
		 if(P9.equalsIgnoreCase("Helen Shephard"))
			System.out.printf("Result Verification---Pass",true);
		 else
			 Assert.fail();
		 Thread.sleep(3000L);
		 click("hp_Term&ConditionsBackButton_xpath");
		  Thread.sleep(1000L);
			click("hp_sidebarMenuIcon_xpath");
			Thread.sleep(1000L);
			click("hp_sideBarMenu_Logout_xpath");
			
		 

}
	
}
