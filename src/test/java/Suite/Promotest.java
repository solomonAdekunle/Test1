package Suite;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class Promotest extends TestBase{
	
	
	@BeforeTest
	public void beforetest() throws IOException{
		initialised();

}
	
	@Test//(enabled=false)
	public void Promotiontest() throws InterruptedException{
		d.get(Config.getProperty("URL"));
		Thread.sleep(3000L);
		click("hp_PromotionsTab_Selector");
		Thread.sleep(1000L);
		 WebElement promo=d.findElement(By.cssSelector("div.view-promotions .view-content"));
		   List <WebElement> Promlist=promo.findElements(By.cssSelector("div.promo-wrapper"));
		   
		   System.out.println(Promlist.size());
		   
		   for(int i=0; i < Promlist.size(); i++) {
			   
			   System.out.println(i);
			   // Repolulate  the list of all the Elements on all the banner.
			    promo=d.findElement(By.cssSelector("div.view-promotions .view-content"));
			   Promlist = promo.findElements(By.cssSelector("div.promo-wrapper"));
			   WebElement promotion = Promlist.get(i);
					   
			   //get promotion title
			   String promotionTitle = promotion.findElement(By.cssSelector(".promotion-title a")).getText();
			   System.out.println(promotionTitle);
//			   
//			   //navigate
		 WebElement Button1=promotion.findElement(By.cssSelector("a.promo-more-info"));
		 	Button1.click();
  		 //get page title
		 	String pagetitle=getText("titlePage_xpath");
		 	Thread.sleep(200);
		 	System.out.println(pagetitle);
		 	if(pagetitle.equalsIgnoreCase(promotionTitle)){
		 		System.out.println(true);
		 		
		 		Thread.sleep(1000);
		 		d.navigate().back();
		 	}else{
		 		System.out.println(false);
		 		return;

		 	}
		   }
			   
			   
			   //compare
			   
			   
		   }
	@Test(enabled=false)
	public void competitionstest() throws InterruptedException{
		d.get(Config.getProperty("URL"));
		Thread.sleep(3000L);
		click("hp_PromotionsTab_Selector");
		Thread.sleep(1000L);
		click("Promotions_Competition_xpath");
		Thread.sleep(1000L);
		click("Promotions_Torunaments_xpath");
		
	}
	
	
	

}
