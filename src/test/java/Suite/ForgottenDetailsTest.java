package Suite;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class ForgottenDetailsTest extends TestBase {
	
	@BeforeTest
	public void beforetest() throws IOException{
		initialised();
		
	}
@Test
public void FDLtest() throws InterruptedException{
	d.get(Config.getProperty("URL"));
	Thread.sleep(2000);
	click("hp_TopLogin_xpath");
	Thread.sleep(6000);
	click("forgottenDetails_Selector");
}
@Test
public void newusertest() throws InterruptedException{
	d.get(Config.getProperty("URL"));
	Thread.sleep(2000);
	click("hp_TopLogin_xpath");
	Thread.sleep(6000);
	click("Pop-up_JoinNow_Selector");
}
}

