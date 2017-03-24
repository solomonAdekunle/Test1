package Suite;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Constants;
import Base.TestBase;

public class LunchGameTest extends TestBase {


	@BeforeTest
	public void beforetest() throws IOException{
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
		Thread.sleep(1000L);

		this.gameTest();
		
		Thread.sleep(6000L);
		d.navigate().back();		
		Thread.sleep(1000L);
		click("hp_sidebarMenuIcon_xpath");
		Thread.sleep(1000L);
		click("hp_sideBarMenu_Logout_xpath");
	}

	private void gameTest() throws InterruptedException {

		System.out.println("gameTest");

		WebElement Tablewraper=d.findElement(By.cssSelector("div #tablewrapper"));
		System.out.println(d.findElement(By.cssSelector("div #tablewrapper")).isDisplayed());
		Actions act1 = new Actions(d);
		// if Table is close then wait for 60 seconds for the game table to be opened.
		WebDriverWait wait= new WebDriverWait(d,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div #tablewrapper")));
		System.out.println(d.findElement(By.cssSelector("div #tablewrapper")).isDisplayed());// return true or false if the table is displayed or not
		// Check if there is time to place the bet
		String Timer=d.findElement(By.cssSelector("div.seconds-remaining")).getText().trim();
		System.out.println(Timer);
		
		if (Timer.isEmpty() == false) {  // check time if there is time to place the bet, it should place the bet
			int i= Integer.parseInt(Timer);
			System.out.println(i);
			if(i<=2){// if time is less than 2 then it should wait 
				this.gameTest();
			}else{
				System.out.println("Timer is integer");
				WebElement src1=d.findElement(By.xpath("/html/body/div[2]/div[9]/div[2]/img"));
				WebElement destination1=d.findElement(By.xpath("//*[@id=\"bet16\"]"));
				WebElement destination2=d.findElement(By.xpath("//*[@id=\"bet0\"]"));
				act1.dragAndDrop(src1, destination1).build().perform();
				act1.dragAndDrop(src1, destination2).build().perform();
				click("rouletteExpPremium_gameConfirmButton_xpath");// click confirm button
				// To verify if the bet is played succefully
				Thread.sleep(2000);
				String Text=getText("PlaceBetSuceesfullText_xpath");
				if(Text.equalsIgnoreCase("GOOD LUCK,"+"Your bets have been successfully placed.")){
					System.out.println(Text);
				}else
					System.out.println(Text);
				
				//END
				
			}
					
		}else{
			System.out.println("Timer is empty");
			this.gameTest();
			// Place the bet
		
		
		}
		
		//}


		//click("hp_FrankDettorisPlay_Selector");
		//Dimension k = new Dimension(580,320); //Smalltouch devices such as iPhone, Android and Windows phones
	} //d.manage().window().setSize(k);

	@Test(enabled=false)   
	public void gamelunch2test() throws InterruptedException{
		d.get(Config.getProperty("URL"));
		doDefaultLogin(Config.getProperty("defaultUsername"));
		Thread.sleep(3000L);
		click("hp_vegasTab_xpath");
		Thread.sleep(2000L);
		click("vegas_BlackCatgame_Selector");
		Thread.sleep(2000L);
		click("vegas_BlackCatGamePlay_Selector");
		Dimension k = new Dimension(1024,768); //Smalltouch devices such as iPhone, Android and Windows phones
		d.manage().window().setSize(k);
		Thread.sleep(3000L);
		//String Sound_ButtonNo=""
		Actions Moves= new Actions(d);
		Moves.moveByOffset(700, 500).click().build().perform();
		Thread.sleep(3000L);
		click("vegas_blackCatGameSpin_xpath");
		Thread.sleep(3000L);
		d.close();
	}

	/*private void placeBet(Number bet) {

		Actions act1 = new Actions(d);

		WebElement destination1=d.findElement(By.xpath("//*[@id=\"bet" + bet + "\"]"));
		WebElement src1=d.findElement(By.xpath("/html/body/div[2]/div[9]/div[2]/img"));

		act1.dragAndDrop(src1, destination1);

	}
	 */
}

