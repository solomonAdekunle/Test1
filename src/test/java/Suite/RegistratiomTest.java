 package Suite;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class RegistratiomTest extends TestBase {
	
	
	
	
	@BeforeTest
	public void beforetest() throws IOException{
		initialised();
		
	}
	
	@Test(dataProvider="getdata")
	public void registertest(String username, String password, String confPassword, String ScreenName, String Email, String Title, String Fname, String Lname, String Day, String Month,String Year, String address, String City, String County, String Postcode, String Contact, String expectedResult,String Result) throws InterruptedException{
		d.get(Config.getProperty("URL"));
		Thread.sleep(2000);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(2000);
		click("hp_sideBarMenu_JoinNow_xpath");
		Thread.sleep(2000);
		String Username = username;
		if( Username.equals("{generator}")){
			Username =generateStringWithAllobedSplChars(20,"");
		}
		input("register_username_xpath",Username);
		input("register_password_xpath",password);
		input("register_confirpassword_xpath",confPassword);
		String screename=ScreenName;
		if(screename.equals("{generator}")){
			screename=generateRandomAlphaNumeric(16,"");
			
		}
		input("register_screenname_xpath",screename);
		input("register_email_xpath",Email);
		input("register_Title_xpath",Title);
		input("register_firstname_xpath",Fname);
		input("register_surname_xpath",Lname);
		input("register_DOBday_xpath",Day);
		input("register_DOBmonth_xpath",Month);
		input("register_DOByear_xpath",Year);
		click("register_addressManully_xpath");
		input("register_Addresss_xpath",address);
		input("register_city_xpath",City);
		input("register_county_xpath",County);
		input("register_postcode_xpath",Postcode);
		Thread.sleep(2000l);
	    click("register_FindAddress_xpath");
	    Thread.sleep(2000l);
		input("register_PleaseSelectAddress_xpath","Netplay TV Plc 80 silverthorne road London");
		input("register_ContactNumber_xpath",Contact);
		Thread.sleep(2000l);
		click("register_over18yrs_xpath");
		Thread.sleep(2000l);
		click("register_Submit_xpath");
		Thread.sleep(3000);
		// Verifying if user navigated to Welcome Page 
		String Welcome_title=getText("welcomeTitlePage_xpath");
		System.out.println(Welcome_title);
		boolean result=isElementPresent("welcomeTitlePage_xpath");
		String actualResult=null;
	    if(result)
			actualResult="SUCCESS";
		else
			actualResult="FAILURE";
	 	Assert.assertEquals(expectedResult, actualResult);
		 
		if(d.getCurrentUrl().equals("https://www.supercasino.com/welcome"))
			System.out.println("USER HAS REGISTER SUCCESSFULLY");
		else
			System.out.println("USER FAILED TO REGISTER");
		Thread.sleep(1000);
		// Check after user has successful register and logout.
		if(Result.equals("complete"))
			Thread.sleep(1000);
			 click("hp_sidebarMenuIcon_xpath");
		 Thread.sleep(1000);
		 click("hp_sideBarMenu_Logout_xpath");

}
	@ DataProvider
	public Object[][] getdata(){
		Object data[][]= new Object[3][18];
		// frist row
		data[0][0]="qWERTwe";
		data[0][1]="QWET";
		data[0][2]="QWETY";
		data[0][3]="qwerts";
		data[0][4]="tesy@playtech.com";
		data[0][5]="Mrs";
		data[0][6]="qwert";
		data[0][7]="tyres";
		data[0][8]="17";
		data[0][9]="Mar";
		data[0][10]="1999"; 
		data[0][11]="80";
		data[0][12]="London";
		data[0][13]="L";
		data[0][14]="sw8 3he";
		data[0][15]="020300675512";
		data[0][16]="FAILURE";
		data[0][17]="Incomplete";
		
		
		// 2nd row
		data[1][0]="qwert";
		data[1][1]="bola323";
		data[1][2]="loadipo2";
		data[1][3]="123685";
		data[1][4]="test@olaytech.com";
		data[1][5]="Dr";
		data[1][6]="mark";
		data[1][7]="bola323";
		data[1][8]="2";
		data[1][9]="May";
		data[1][10]="2008";
		data[1][11]="80";
		data[1][12]="hull";
		data[1][13]="EAST RIDING OF YORKSHIRE  united kingdom european";
		data[1][14]="hu6 7rx";
		data[1][15]="0207yt3252123";
		data[1][16]="FAILURE";
		data[1][17]="Incomplete";
		
		// 3rd Row
		data[2][0]="{generator}";
		data[2][1]="Bola123$%^";
		data[2][2]="Bola123$%^";
		data[2][3]="{generator}";
		data[2][4]="test@playtech.com";
		data[2][5]="Mr";
		data[2][6]="mark";
		data[2][7]="bola";
		data[2][8]="8";
		data[2][9]="Aug";
		data[2][10]="1990";
		data[2][11]="80";
		data[2][12]="London";
		data[2][13]="London";
		data[2][14]="Sw8 3he ";
		data[2][15]="001789986541";
		data[2][16]="SUCCESS";
		data[2][17]="complete";
	return data;

}
}
