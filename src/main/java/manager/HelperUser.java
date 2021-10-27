package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void fillLoginRegistrationForm(User user) {
        type(By.xpath("//input[@autocomplete='username']"), user.getEmail());
        type(By.xpath("//input[@autocomplete='current-password']"), user.getPassword());
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


    public boolean isLoggedSucces() {
        WebDriverWait wait = new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        //явное ожидание - 10 секунд ждать прорисовку конкретного элемента
        return wd.findElement(By.cssSelector(".dialog-container h2")).getText().contains("success");
    }

    public boolean isLoggedSucces2() {
        WebDriverWait wait = new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        //явное ожидание - 10 секунд ждать прорисовку конкретного элемента
        return wd.findElement(By.cssSelector(".dialog-container h2")).getText().contains("success");
    }


    public void clickOkButton() {
        if(isElementPresent(By.xpath("//button[text()='Ok']"))){
            click(By.xpath("//button[text()='Ok']"));
        }
    }
}

