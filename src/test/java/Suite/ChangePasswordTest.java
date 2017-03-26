package Suite;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

import Utility.TestUti;

public class ChangePasswordTest extends TestBase {

	@BeforeTest
	public void beforetest() throws IOException {
		initialised();

	}

	@Test(dataProvider = "getdata")
	public void changepasswordtest(String oldpassword, String newpassword, String confirmpassword, String Result,
			String expectedResult) throws InterruptedException, ConfigurationException {
		//d.get(Config.getProperty("URL"));
		doDefaultLogin(Config.getProperty("defaultUsername"));
		Thread.sleep(3000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(1000L);
		click("hp_sideBarMenuMyAccount_xpath");
		Thread.sleep(1000L);
		click("hp_sideBarMenuMyAccount_changepassword_xpath");
		input("changepassword_Oldpassword_xpath", oldpassword);
		String NewPassWord = newpassword;
		if (NewPassWord.equals("{generator}")) {
			NewPassWord = generateRandomAlphaNumeric(20, "");
		}
		input("changepassword_newpassword_xpath", NewPassWord);

		if (confirmpassword.equals("{generator}")) {
			input("chnagepassword_confirmpassword_xpath", NewPassWord);
			System.out.println(NewPassWord);
		} else {
			input("chnagepassword_confirmpassword_xpath", confirmpassword);
		}
		click("changepassword_submit_xpath");
		if (Result.equals("Correct")) {
			System.out.println("cHECKING FOR ERROR");
			Thread.sleep(2000);
			String textTitle = getText("YourPasswordHasSuceesfyllyChange_xpath");
			System.out.println(textTitle);
			Assert.assertEquals(textTitle,"YOUR PASSWORD HAS BEEN SUCCESSFULLY CHANGED" );
			System.out.println("good1");
			TestUti.updateproperty("defaultPassword", NewPassWord);
			System.out.println("good2");
		}
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(1000);
		click("hp_sideBarMenu_Logout_xpath");
		Thread.sleep(1000);
	}

	/*
	 * String actualResult=null; //Assert.assertEquals(ExpectedResult,
	 * actualResult); if(expectedResult.equals("SUCCESS"))
	 * System.out.println(expectedResult); else System.out.println(false);
	 */

	@DataProvider
	public Object[][] getdata() {
		Object data[][] = new Object[3][5];
		// frist row
		data[0][0] = "Bola123$%^";
		data[0][1] = "$$$$$%%21a";
		data[0][2] = "$$$$$%%21a";
		data[0][3] = "Incompete";
		data[0][4] = "FAILURE";
		// Second row
		data[1][0] = "Bola123$%^";
		data[1][1] = "Bol";
		data[1][2] = "Bol";
		data[1][3] = "Incompelete";
		data[1][4] = "FAILURE";
		// Third Row
		data[2][0] = "VXHX]]-=oc>NAs2VK&x1";
		data[2][1] = "{generator}";
		data[2][2] = "{generator}";
		data[2][3] = "Correct";
		data[2][4] = "SUCCESS";

		return data;
	}
}
// Bola123445678$%^
// Bola123445678$%^
