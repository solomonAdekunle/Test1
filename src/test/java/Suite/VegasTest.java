package Suite;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class VegasTest extends TestBase {
	
	
	@BeforeTest
	public void beforetest() throws IOException{
		initialised();

}
	@Test(enabled=false)
	public void lunchvvagastest() throws InterruptedException{
		d.get(Config.getProperty("URL"));
		Thread.sleep(2000l);
		 doDefaultLogin(Config.getProperty("defaultUsername"));// lgging in with default username and password
		 Thread.sleep(2000l);
		click("hp_vegasTab_xpath");
		Thread.sleep(2000l);
		click("vegas_GameCatrgoryAll_xpath");
		Thread.sleep(5000l);
		click("vegas_BlackCatgame_Selector");
		Thread.sleep(2000l);
		click("vegas_BlackCatGamePlay_Selector");// click on the Play button in order to play the game
		Dimension k = new Dimension(320,568);
		//Dimension k = new Dimension(1024,768); //Smalltouch devices such as ipad and tablet
		   d.manage().window().setSize(k);
		   Thread.sleep(3000l);
		
		   //d.switchTo().frame("gameFrame");
		    String Xpath_SoundButtoNo="//iframe";
		    WebElement SoundButton=d.findElement(By.xpath(Xpath_SoundButtoNo));
		  Actions Moves= new Actions(d);
		  Moves.moveToElement(SoundButton,750,300).click().build().perform();
		   //click("vegas_BlackCatgameYoulikeSound_NO_xpath");// click on the sound button No
		   Thread.sleep(3000l);
		   click("vegas_blackCatGameSpin_xpath"); // click on the spin button 
		   Thread.sleep(5000l);
		   List<WebElement>Frames = d.findElements(By.tagName("iframe"));
			System.out.println("Total frame-." + Frames.size());
			System.out.println(Frames.get(0));
			d.switchTo().frame(0);
			click("vegas_blackCatGameMenu_Selector");
			Thread.sleep(2000l);
			click("vegas_CatGameMenu_Home_xpath");
			Thread.sleep(4000l);
			// Verify if user able to navigate back to the Home Page
			boolean Deposit=isElementPresent("hp_TopDeposit_xapth");
			if(isElementPresent("hp_TopDeposit_xapth"))
				System.out.println(Deposit);
			else
				System.out.println(false);
			
			
				
			Thread.sleep(1000L);
			click("hp_sidebarMenuIcon_xpath");
			Thread.sleep(1000L);
			click("hp_sideBarMenu_Logout_xpath");
			//System.out.println(Frames.get(1).getAttribute("id"));
		   //d.switchTo().frame("activate");
		   //WebElement frame= d.findElement(By.cssSelector("#activate"));
		  //List<WebElement>CatFrame=frame.findElements(By.tagName("iframe"));
		   //System.out.println(CatFrame.size());
		   //d.switchTo().frame("Jf").findElement(By.id("slider")).click();
		  /* String Xpath_Menu ="#activate";
		   String Xpath_subMenu="//*[@id=\"home\"]";
		   WebElement CatGameMenu=d.findElement(By.cssSelector(Xpath_Menu));
		   WebElement CatGameMenu_Home=d.findElement(By.xpath(Xpath_subMenu));
		   Actions Move= new Actions(d);
		   Move.moveToElement(CatGameMenu).build().perform();
		   Thread.sleep(2000l);
		   CatGameMenu_Home.click();
		   */
		   
		   
		  
	}
}
