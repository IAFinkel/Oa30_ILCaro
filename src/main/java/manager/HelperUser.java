package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void openLoginRegistrationForm() {

        click(By.xpath("//div[@class='header']/a[6]"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[@autocomplete='username']"), email);
        type(By.xpath("//input[@autocomplete='current-password']"), password);
    }

    public void submitLogin() {

        click(By.xpath("//button[@type='submit']"));
    }

    public void submitLogin2() {

        click(By.xpath("//button[@type='button']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[@href=\"/logout?url=%2Fsearch\"]"));
    }

    public void logout() {

        click(By.xpath("//a[@href=\"/logout?url=%2Fsearch\"]"));
    }


}

