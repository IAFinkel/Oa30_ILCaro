package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void type(By locator, String text) {
        if (text != null && !text.isEmpty()) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void click(By locator) {

        wd.findElement(locator).click();
    }

    public void pause(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void takeScreenshot(String link) {
        File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File screen = new File(link);
        try {
            Files.copy(tmp, screen);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
