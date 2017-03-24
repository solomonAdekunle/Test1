package Suite;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class JustTest extends TestBase {
	
	@BeforeTest
	public void Beforetest() throws IOException{
		initialised();
	}
	
	
	@Test//(enabled=false)
	public void gamelunchtest() throws InterruptedException{
		d.get(Config.getProperty("URL"));
		 doDefaultLogin(Config.getProperty("defaultUsername"));
		 Thread.sleep(3000L);
		 click("hp_RouletteExpressPremium_xpath");
		 Thread.sleep(3000L);
		 click("hp_RouletteExpPrePlay_Selector");
		 WebElement Tablewraper=d.findElement(By.cssSelector("div #tablewrapper"));
		 System.out.println(d.findElement(By.cssSelector("div #tablewrapper")).isDisplayed());
		  Actions act1 = new Actions(d);
		 //if(!Tablewraper.isDisplayed()){
			WebDriverWait wait= new WebDriverWait(d,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div #tablewrapper")));
			System.out.println(d.findElement(By.cssSelector("div #tablewrapper")).isDisplayed());
			WebElement src1=d.findElement(By.xpath("/html/body/div[2]/div[9]/div[2]/img"));
			 WebElement destination1=d.findElement(By.xpath("//*[@id=\"bet16\"]"));
			act1.dragAndDrop(src1, destination1).build().perform();
				 click("rouletteExpPremium_gameConfirmButton_xpath");
				 // Click Logout out link
				 Thread.sleep(1000L);
				 d.navigate().back();
				 Thread.sleep(1000L);
					click("hp_sidebarMenuIcon_xpath");
					Thread.sleep(1000L);
					click("hp_sideBarMenu_Logout_xpath");
		
}
}