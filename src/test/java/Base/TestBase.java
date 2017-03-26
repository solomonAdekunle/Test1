package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

//import TestUtil.Utility;



public class TestBase {
	public static Properties Config=null;
	public static Properties OR= null;
	public static WebDriver d= null;
	public static EventFiringWebDriver dr=null;
	
	public void initialised() throws IOException{
		
		if(d==null){
		// initialising the properties
				Config = new Properties();
		FileInputStream fs= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Config\\Config.Properties");
		Config.load(fs);
           // OR
		  OR = new Properties();
              fs= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Config\\OR.Properties");
              OR.load(fs);
             // System.out.println(OR);
		
	// initialised webdriver
                   if(Config.getProperty("browser").equals("Firefox"))
                	   d= new FirefoxDriver();
                  else if(Config.getProperty("browser").equals("Chrome")){
				//File file= new File("C:\\QA\\Chrome\\chromedriver.exe");
				// File file= new File("C:\\Users\\solomon.adekunle\\OneDrive for Business\\workspace\\BetVernons\\chromedriver.exe");
                	  System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
		         options.addArguments("no-sandbox");
			options.addArguments("--user-agent=" + "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.53");
			//options.addArguments("--user-agent=" + "Mozilla/5.0 (iPad; CPU OS 8_0 like Mac OS X) AppleWebKit/600.1.3 (KHTML, like Gecko) Version/8.0 Mobile/12A4345d Safari/600.1.4");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			//cap.setCapability(CapabilityType.PROXY, p);
			cap.setCapability(ChromeOptions.CAPABILITY , options);
			 d= new ChromeDriver(cap);
		        }
		         else if(Config.getProperty("browser").equals("IE")){
						File file= new File("C:\\QA\\Chrome\\IEDriverServer.exe"); 
                	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
					 d= new InternetExplorerDriver();
		        
		}
		 EventFiringWebDriver dr= new EventFiringWebDriver(d);
         d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
         Dimension k = new Dimension(320,580); //Smalltouch devices such as iPhone, Android and Windows phones
        // Dimension k = new Dimension(768,1024);// ipad or tablet
		    d.manage().window().setSize(k);
		}
	}
	public void navigate(String URLKey){
		d.get(Config.getProperty(URLKey));
		//Utility.takeScreenshot(URLKey);
	}
	public void click(String identifier){
		try{
		if(identifier.endsWith("_xpath"))
			d.findElement(By.xpath(OR.getProperty(identifier))).click();
		else if(identifier.endsWith("_id"))
			d.findElement(By.id(OR.getProperty(identifier))).click();
		else if(identifier.endsWith("_name"))
			d.findElement(By.name(OR.getProperty(identifier))).click();
		else if((identifier.endsWith("_Selector")))
			d.findElement(By.cssSelector(OR.getProperty(identifier))).click();
			}catch(NoSuchElementException e){
				//Utility.takeScreenshot(identifier);
			Assert.fail("Element not found - "+identifier);
			
		}
	}
		public void clear(String identifier){
			try{
				if(identifier.endsWith("_xpath"))
					d.findElement(By.xpath(OR.getProperty(identifier))).clear();
				else if(identifier.endsWith("_id"))
					d.findElement(By.id(OR.getProperty(identifier))).clear();
				else if(identifier.endsWith("_name"))
					d.findElement(By.name(OR.getProperty(identifier))).click();
				else if((identifier.endsWith("_Selector")))
					d.findElement(By.cssSelector(OR.getProperty(identifier))).clear();
				}catch(NoSuchElementException e){
					//Utility.takeScreenshot(identifier);//take screenshot 
					Assert.fail("Element not found - "+identifier);
					
				}
		}
	
		public void input(String identifier,String data){
			try{
			if(identifier.endsWith("_xpath"))
				d.findElement(By.xpath(OR.getProperty(identifier))).sendKeys(data);
			else if(identifier.endsWith("_id"))
				d.findElement(By.id(OR.getProperty(identifier))).sendKeys(data);
			else if(identifier.endsWith("_name"))
				d.findElement(By.name(OR.getProperty(identifier))).sendKeys(data);
			else if((identifier.endsWith("_Selector")))
				d.findElement(By.cssSelector(OR.getProperty(identifier))).sendKeys(data);
			}catch(NoSuchElementException e){
				Assert.fail("Element not found - "+identifier);
				//Utility.takeScreenshot(identifier);
			}
		}
		    public boolean verifyTitle(String expectedTitleKey){
				String expectedTitle=OR.getProperty(expectedTitleKey);
				String actualTitle=d.getTitle();
				//Utility.takeScreenshot(expectedTitleKey);
				if(expectedTitle.equals(actualTitle))
					return true;
				else
					return false;
			}
		    public boolean isElementDisplay(String identifier){
		    	try{
					if(identifier.endsWith("_xpath"))
						d.findElement(By.xpath(OR.getProperty(identifier))).isDisplayed();
					else if(identifier.endsWith("_id"))
						d.findElement(By.id(OR.getProperty(identifier))).isDisplayed();
					else if(identifier.endsWith("_name"))
						d.findElement(By.name(OR.getProperty(identifier))).isDisplayed();
					else if((identifier.endsWith("_Selector")))
						d.findElement(By.cssSelector(OR.getProperty(identifier))).isDisplayed();
					}catch(NoSuchElementException e){
						Assert.fail("Element not found - "+identifier);
					//Utility.takeScreenshot(identifier);
										}
				
		    	return false;
		    	
		    }
			public boolean isElementPresent(String identifier){
				int size=0;
				if(identifier.endsWith("_xpath"))
					size = d.findElements(By.xpath(OR.getProperty(identifier))).size();
				else if(identifier.endsWith("_id"))
					size = d.findElements(By.id(OR.getProperty(identifier))).size();
				else if(identifier.endsWith("_name"))
					size = d.findElements(By.name(OR.getProperty(identifier))).size();
				else if(identifier.endsWith("_Selector"))
					size=d.findElements(By.cssSelector(identifier)).size();
				else // not in prop file
					size=d.findElements(By.xpath(OR.getProperty(identifier))).size();
				//Utility.takeScreenshot(identifier);
				if(size>0)
					return true;
				else
					return false;
		}
			public String getText(String identifier){
				String  text="";
				if(identifier.endsWith("_xpath"))
					text = d.findElement(By.xpath(OR.getProperty(identifier))).getText();
				else if(identifier.endsWith("_id"))
					text = d.findElement(By.id(OR.getProperty(identifier))).getText();
				else if(identifier.endsWith("_name"))
					text =d.findElement(By.name(OR.getProperty(identifier))).getText();
				else if(identifier.endsWith("_Selector"))
					text=d.findElement(By.cssSelector(OR.getProperty(identifier))).getText();
				//Utility.takeScreenshot(identifier);
				return text;
				
			}
			public void quit(){
				if(d!=null){
					d.quit();
					d=null;
				}
			}
			/*****************Application specific functions
			 * @throws InterruptedException *******************/
			
			public void doLogin(String browser,String Username,String Password) throws InterruptedException{
				d.get(Config.getProperty("URL"));
				Thread.sleep(2000);
				click("hp_TopLogin_xpath");
				input("username_Selector",Username);
				input("password_Selector",Password);
				click("Signin_Selector");
				
				WebElement PlayerMessage=d.findElement(By.cssSelector("div.playerMessages-modal .footer .ok"));
				if(PlayerMessage.isDisplayed())
					PlayerMessage.click();
	}
			public void doDefaultLogin(String browser) throws InterruptedException{
				doLogin(browser, Config.getProperty("defaultUsername"), Config.getProperty("defaultPassword"));
			}
			
			// Creating a Dynamatic Data Generator
			
			
			public String generateStringWithAllobedSplChars(int length,String allowdSplChrs){
				  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
				    "1234567890" +   //numbers
				    allowdSplChrs;
				  return RandomStringUtils.random(length, allowedChars);
				 }

						
			public String generateRandomAlphaNumeric(int lenght ,String charcter ){
				String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
				 charcter=RandomStringUtils.random(lenght,characters);
				return charcter ;
				 }
				 

			}
