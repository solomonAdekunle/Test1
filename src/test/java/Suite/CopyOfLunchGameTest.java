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

public class CopyOfLunchGameTest extends TestBase {


	@BeforeTest
	public void beforetest() throws IOException{
		initialised();

	}
	
	@Test//(enabled=false)
	public void gamelunchtest() throws InterruptedException {
		
		//login the user
		this.loginUser();
		
		//click the game
		this.clickTheGame();
		
		//test Game
		this.testGame();
		Thread.sleep(6000L);
		d.navigate().back();		
		Thread.sleep(1000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(1000L);
		click("hp_sideBarMenu_Logout_xpath");
	}
	
	private void loginUser() throws InterruptedException {
		d.get(Config.getProperty("URL"));
		doDefaultLogin(Config.getProperty("defaultUsername"));
		Thread.sleep(3000L);
	}
	
	private void clickTheGame() throws InterruptedException {
		click("hp_RouletteExpressPremium_xpath");
		Thread.sleep(3000L);
		click("hp_RouletteExpPrePlay_Selector");
		Thread.sleep(1000L);
	}
	
	private void testGame() throws InterruptedException {
		
		//check the table opened/closed
		//wait
		//WebElement Tablewraper=d.findElement(By.cssSelector("div #tablewrapper"));
		//System.out.println(d.findElement(By.cssSelector("div #tablewrapper")).isDisplayed());
		
		// if Table is close then wait for 60 seconds for the game table to be opened.
		WebDriverWait wait= new WebDriverWait(d,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div #tablewrapper")));
		//System.out.println(d.findElement(By.cssSelector("div #tablewrapper")).isDisplayed());// return true or false if the table is displayed or not
		
		//check timer
		Boolean TimerOK = false;
		String Timer=d.findElement(By.cssSelector("div.seconds-remaining")).getText().trim();
		System.out.println(Timer);
		if (Timer.isEmpty() == false) {
			int i= Integer.parseInt(Timer);
			
			if(i <=9) {
				TimerOK = false;
			}else{
				TimerOK = true;
			}
		}
		
		
		if (TimerOK){
			//place the bets
			this.placeBets();
			
			//confirm the bets
			this.confirmBets();
			
			//print result
		}else{
			this.testGame();
		}

	}
	
	private void placeBets() throws InterruptedException {
		Actions act1 = new Actions(d);
		WebElement src1=d.findElement(By.xpath("/html/body/div[2]/div[9]/div[2]/img"));
		WebElement destination1=d.findElement(By.xpath("//*[@id=\"bet16\"]"));
		WebElement destination2=d.findElement(By.xpath("//*[@id=\"bet0\"]"));
		act1.dragAndDrop(src1, destination1).build().perform();
		act1.dragAndDrop(src1, destination2).build().perform();
	}
	
	
	private void confirmBets() throws InterruptedException {
		
		click("rouletteExpPremium_gameConfirmButton_xpath");// click confirm button
		// To verify if the bet is played succefully
		Thread.sleep(2000);
		String Text=getText("PlaceBetSuceesfullText_xpath");
		if(Text.equalsIgnoreCase("GOOD LUCK,"+"Your bets have been successfully placed.")){
			System.out.println(Text);
		}else
			System.out.println(Text);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

