package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplManager {
    WebDriver wd;
    HelperUser helperUser;
    CarHelper car;

    Logger logger = LoggerFactory.getLogger(ApplManager.class);

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public CarHelper getCar() {return car;}

    public void init() {
        wd = new ChromeDriver();
        logger.info("Tests starts on Chrome Driver");
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        helperUser = new HelperUser(wd);
        car = new CarHelper(wd);
    }

    public void stop() {
        logger.info("Tests passed");
        wd.quit();
    }
}
