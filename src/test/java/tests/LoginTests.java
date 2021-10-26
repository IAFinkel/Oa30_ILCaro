package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void test() {
        String email = "goodwin49@mail.ru";
        String password = "Car12345";

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitLogin();
        app.getHelperUser().submitLogin2();
        app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.xpath("//a[@href=\"/logout?url=%2Fsearch\"]")));


    }
}
