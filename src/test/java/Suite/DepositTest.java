package Suite;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class DepositTest extends TestBase {
	

	@BeforeTest
	public void beforetest() throws IOException{
		initialised();

}
	@Test()
	public void Depositmoneytest() throws InterruptedException{
		d.get(Config.getProperty("URL"));
		 doDefaultLogin(Config.getProperty("defaultUsername"));
		 Thread.sleep(3000L);
		 click("hp_TopDeposit_Selector");
		// Thread.sleep(3000L);
		 WebDriverWait wait= new WebDriverWait(d,50);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.app .page-title")));
		 click("cashier_DepositVisa_Selector");
		 Thread.sleep(1000L);
		 d.navigate().back();
		 Thread.sleep(1000L);
			click("hp_sidebarMenuIcon_xpath");
			Thread.sleep(1000L);
			click("hp_sideBarMenu_Logout_xpath");
		 //d.close();
	}

		
	@Test(enabled=false)
	public void Addcardtest() throws InterruptedException{
		d.get(Config.getProperty("URL"));
		 doDefaultLogin(Config.getProperty("defaultUsername"));
		 Thread.sleep(3000L);
		 click("hp_TopDeposit_Selector");
		 Thread.sleep(5000L);
		 WebDriverWait wait= new WebDriverWait(d,50);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.app .page-title")));
		 	//String Xpth_Body="/html/body";
		 	String Selector_addcardobjec="div.allpaymentlist .icon-add-card";
		 WebElement AddCARD=d.findElement(By.cssSelector(Selector_addcardobjec));
		 //WebElement CashierBody=d.findElement(By.xpath(Xpth_Body));
		 //TouchActions act= new TouchActions(d);
		 //act.moveToElement(AddCARD).perform();
		 Actions pat= new Actions(d);
		pat.moveToElement(AddCARD).click();
		 
		 //click("cashier_DepositAddCard_xpath");

		//div.allpaymentlist > form + form
		///html/body
		
	}
}
