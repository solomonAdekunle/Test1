package Suite;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class LoginErrorTest  extends TestBase {
	
	@BeforeTest
	public void beforetest() throws IOException{
		initialised();
		
	}
	
	@Test
	public void logintest() throws InterruptedException{
		d.get(Config.getProperty("URL"));
		Thread.sleep(2000);
		click("hp_TopLogin_xpath");
		input("username_Selector","solomon2014");
		click("Signin_Selector");
		// Verify if the Follwowing Elements are displayed within the LoginError Pop-up Box:
		// Supercasino logo, username input box, password input box, Signin Button, ForgottenDetails Link, New user link and Join Now button.
		WebDriverWait wait= new WebDriverWait(d,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.modal-dialog  .login-error .login-overlay-header h2")));
		boolean Logo=isElementPresent("loginErrorMessageBox_superLogo_Selector");
		System.out.println(Logo);
		String errorText=getText("loginErrorMessageBox_Text_Selector");
		if(errorText.equalsIgnoreCase("Incorrect Username or Password – please re-enter."))
			System.out.println(errorText);
		else
			System.out.println("Text not present");
		
		click("loginErrorMessageBox_ForgottenDetailsLink_Selector");
		  Thread.sleep(100);
		// Verify if forgottenDetails link navigated to forgettenDetails Page
			String Text=getText("titlePage_xpath");
			
			if(Text.equalsIgnoreCase("Forgotten Details")){
				System.out.println(Text);
			}else{
				System.out.println("Text Not Present");
			}
			
	  }
	@Test()
	public void JoinNowtest() throws InterruptedException{
		d.get(Config.getProperty("URL"));
		Thread.sleep(2000);
		click("hp_TopLogin_xpath");
		input("username_Selector","solomon2014");
		click("Signin_Selector");
		click("loginErrorMessageBox_JoinNow_Selector");
		Thread.sleep(100);
		String Text1=getText("titlePage_xpath");
		if(Text1.equalsIgnoreCase("Register")){
			System.out.println(Text1);
		}else
			System.out.println("Text Not Present");
		
		//click("loginErrorMessageBox_CloseIcon_Selector");
		// d.close();
		}
		
	
	@Test()
	public void errorLogintest() throws InterruptedException{
		d.get(Config.getProperty("URL"));
		Thread.sleep(2000);
		click("hp_TopLogin_xpath");
		input("username_Selector","solomon2014");
		click("Signin_Selector");
		input("loginErrorMessageBox_username_Selector",Config.getProperty("defaultUsername"));
		input("loginErrorMessageBox_password_Selector",Config.getProperty("defaultPassword"));
		click("loginErrorMessageBox_SignIn_Selector");
		//WebDriverWait wait= new WebDriverWait(d,5);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.region-header a.button-3")));
		boolean Button=isElementPresent("hp_TopDeposit_Selector");
			if(isElementPresent("hp_TopDeposit_Selector"))
			System.out.println(true);
			 Thread.sleep(300L);
			 click("hp_sidebarMenuIcon_xpath");
			 Thread.sleep(1000);
			 click("hp_sideBarMenu_Logout_xpath");
	
	}
	
	

}

           