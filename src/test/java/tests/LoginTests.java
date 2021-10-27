package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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

        User user = new User().withEmail("goodwin49@mail.ru").withPassword("Car12345");

        app.getHelperUser().openLoginRegistrationForm();

        //app.getHelperUser().fillLoginRegistrationForm("goodwin49@mail.ru", "Car12345");
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        // app.getHelperUser().submitLogin2();
        app.getHelperUser().pause(2000);
        //  Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isLoggedSucces());

    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();

    }
}
