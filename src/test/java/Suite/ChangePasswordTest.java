package Suite;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
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
	public void changepasswordtest(String oldpassword, String newpassword, String confirmpassword,
			String expectedResult) throws InterruptedException, ConfigurationException {
		d.get(Config.getProperty("URL"));
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
		Thread.sleep(3000L);
		boolean result = isElementPresent("ChangePassword_error_xpath");
		System.out.println("Checking for spot miskate");
		String actualResult = null;
		if (result){
			actualResult = "FAILURE";
	}
		else {
			actualResult = "SUCCESS";
			System.out.println(expectedResult);
			System.out.println(actualResult);
			System.out.println(result);
		// Assert.assertTrue(result);
		}
		Assert.assertEquals(expectedResult, actualResult);
		System.out.println("Expected--------------" + "NoError");

		if (expectedResult.equals("SUCCESS")) {
			System.out.println("cHECKING FOR ERROR");
			Thread.sleep(2000);
			String textTitle = getText("YourPasswordHasSuceesfyllyChange_xpath");
			System.out.println(textTitle);
			boolean result1 = isElementPresent("YourPasswordHasSuceesfyllyChange_xpath");
			System.out.println("cHECKING FOR ERROR1");
			String actualResult1 = null;
			if (result1) {
				actualResult1 = "SUCCESS";
			} else {
				actualResult1 = "FAILURE";
			
			TestUti.updateproperty("defaultPassword", NewPassWord);
			System.out.println(">>" + expectedResult);
			System.out.println(actualResult1);
			}
			// Assert.assertTrue(result1);
			Assert.assertEquals(expectedResult, actualResult1);
			

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
		Object data[][] = new Object[3][4];
		// frist row
		data[0][0] = "@?U~tiS[OqO'8\\%-uQ7o";
		data[0][1] = "$$$$$%%21a";
		data[0][2] = "$$$$$%%21a";
		data[0][3] = "FAILURE";
		// Second row
		data[1][0] = "@?U~tiS[OqO'8\\%-uQ7o";
		data[1][1] = "Bol";
		data[1][2] = "Bol";
		data[1][3] = "FAILURE";
		// Third Row
		data[2][0] = "M|)Hduy38Ek'iM'bwQF@";
		data[2][1] = "{generator}";
		data[2][2] = "{generator}";
		data[2][3] = "SUCCESS";

		return data;
	}
}
// Bola123445678$%^
// Bola123445678$%^
