package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplManager {
   // WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser helperUser;
    CarHelper car;
    String browser;

    public ApplManager(String browser) {
        this.browser = browser;
    }

    Logger logger = LoggerFactory.getLogger(ApplManager.class);

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public CarHelper getCar() {return car;}

    public void init() {
        if(browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Tests starts on Chrome Driver");
        }else  if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Tests starts on FireFox Driver");
        }


        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        helperUser = new HelperUser(wd);
        car = new CarHelper(wd);
        wd.register(new MyListener());
    }

    public void stop() {
        wd.quit();
    }
}
