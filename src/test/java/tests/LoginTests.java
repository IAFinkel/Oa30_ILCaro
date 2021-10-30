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

    @Test
    public void wrongEmail(){
        User user = new User().withEmail("goodwin49mail.ru").withPassword("Car12345");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        Assert.assertFalse(app.getHelperUser().yallaIsEnabled());
        Assert.assertTrue(app.getHelperUser().errorMessageWrongEmail());
        Assert.assertFalse(app.getHelperUser().isLogged());


    }

    @Test
    public void wrongPass(){
        User user = new User().withEmail("goodwin49@mail.ru").withPassword("ar12345");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().authorizErrorWindowDisplayed());
        Assert.assertTrue(app.getHelperUser().errorMessageWrongEmailorPassword());
        Assert.assertFalse(app.getHelperUser().isLogged());

    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();

    }
}
