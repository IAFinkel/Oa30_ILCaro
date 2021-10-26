package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplManager {
    WebDriver wd;
    HelperUser helperUser;

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        helperUser = new HelperUser(wd);
    }

    public void stop() {
        wd.quit();
    }
}
