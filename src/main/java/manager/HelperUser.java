package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        // click(By.xpath("//button[@type='submit']"));
        WebElement submit = wd.findElement(By.xpath("//button[@type='submit']"));
        new WebDriverWait(wd, 10).until(ExpectedConditions.elementToBeClickable(submit));
        submit.submit();
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
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        //явное ожидание - 10 секунд ждать прорисовку конкретного элемента
        return wd.findElement(By.cssSelector(".dialog-container h2")).getText().contains("success");
    }

    public boolean isLoggedSucces2() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        //явное ожидание - 10 секунд ждать прорисовку конкретного элемента
        return wd.findElement(By.cssSelector(".dialog-container h2")).getText().contains("success");
    }


    public void clickOkButton() {
        if (isElementPresent(By.xpath("//button[text()='Ok']"))) {
            click(By.xpath("//button[text()='Ok']"));
        }
    }

    public boolean yallaIsEnabled() {
        return wd.findElement(By.xpath("//button[@type='submit']")).isEnabled();
    }

    public boolean errorMessageWrongEmail() {
        String error = wd.findElement(By.xpath("//div[contains(text(),\"It'snot\")]")).getText();
        return error.contains("It'snot look like email");
    }

    public boolean authorizErrorWindowDisplayed() {
        return wd.findElement(By.xpath("//mat-dialog-container")).isDisplayed();
    }

    public boolean errorMessageWrongEmailorPassword() {
        String error = wd.findElement(By.xpath("//mat-dialog-container//h2")).getText();
        return error.contains("Wrong email or password");
    }

    public boolean isLoginPresent() {
        return isElementPresent(By.xpath("//a[text()=' Log in ']"));
    }

    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLogin();
        clickOkButton();
        pause(1000);


    }

    public void openRegistrationForm() {
        click(By.xpath("//a[@href='/registration?url=%2Fsearch']"));
    }

    public void fillRegistrationForm(User newUser) {
        type(By.xpath("//input[@autocomplete='name']"), newUser.getName());
        type(By.xpath("//input[@autocomplete='family-name']"), newUser.getLastname());
        type(By.xpath("//input[@autocomplete='email']"), newUser.getEmail());
        type(By.xpath("//input[@autocomplete='new-password']"), newUser.getPassword());


    }

    public void submitRegistration() {
        click(By.xpath("//button[@type='submit']"));
    }

    public boolean RegistrationSucces() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h2[text()='You are logged in success']"))));
        return wd.findElement(By.xpath("//h2[text()='You are logged in success']")).getText().contains("success");
    }

    public void checkPolicy() {
        //click(By.xpath("//input[@class='ng-dirty ng-touched ng-invalid']"));
        // click(By.xpath("//label[contains(text(),'I agree to the')]"));
        //click(By.cssSelector(".checkbox-container"));

        //нахождение элеменета с помощью Java Script
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");
        js.executeScript("document.querySelector('#terms-of-use').checked=true;");

        //нажатие в определенное место элемента по координатам
//        Actions actions = new Actions(wd);
//        WebElement container = wd.findElement(By.cssSelector(".checkbox-container"));
//        Rectangle rect = container.getRect();
////        int x = rect.getX() + rect.getWidth()/10;
////        int x = rect.getX() + 2%;
//        int x = rect.getX() + 5;
//        int y = rect.getY()+(1/4*rect.getHeight());
//
//        actions.moveByOffset(x,y).click().perform();

    }
}

