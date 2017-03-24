package Suite;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class LoginTest extends TestBase{
	
	
	
	@BeforeTest
	public void beforetest() throws IOException{
		initialised();
		
	}
	
	@Test(dataProvider="getdata")
	public void logintest(String Username, String Password, String expectedResult) throws InterruptedException{
		d.get(Config.getProperty("URL"));
		Thread.sleep(2000);
		click("hp_TopLogin_xpath");
		input("username_Selector",Username);
		input("password_Selector",Password);
		click("Signin_Selector");
		boolean result=isElementPresent("hp_TopDeposit_xpath");
	    String actualResult=null;
	    if(result)
			actualResult="SUCCESS";
		else
			actualResult="FAILURE";
	 		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@DataProvider
	public Object[][] getdata(){
		Object data[][]= new Object[3][3];
		
		data[0][0]="Solomon2014";
		data[0][1]="";
		data[0][2]="FAILURE";
		//Second row
		data[1][0]="SafeCharge";
		data[1][1]="Bola12";
		data[1][2]="FAILURE";
		//Third Row
		data[2][0]="Bonus104";
		data[2][1]="Bola1234$%^";
		data[2][2]="SUCCESS";
		return data;

}
}