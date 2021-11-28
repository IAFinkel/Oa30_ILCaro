package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//@Listeners(NGListener.class)

public class LoginTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test(dataProvider = "loginDto", dataProviderClass = MyDataProvider.class)
    public void test(String email, String password) {

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitLogin();
        // app.getHelperUser().submitLogin2();
        app.getHelperUser().pause(2000);
        //  Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isLoggedSucces());

    }

    @Test(dataProvider = "loginModelDto", dataProviderClass = MyDataProvider.class)
    public void test2(User user) {

        logger.info("Test Login Posit" +
                "ive starts with email-->" + user.getEmail());
        logger.info("Test Login Positive starts with password-->" + user.getPassword());

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        // app.getHelperUser().submitLogin2();
        app.getHelperUser().pause(2000);
        //  Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isLoggedSucces());

    }

    @Test
    public void wrongEmail() {
        User user = new User().withEmail("goodwin49mail.ru").withPassword("Car12345");
        logger.info("Test Login Negative wrong email starts with email-->" + user.getEmail());
        logger.info("Test Login Negative wrong email starts with password-->" + user.getPassword());

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        Assert.assertFalse(app.getHelperUser().yallaIsEnabled());
        Assert.assertTrue(app.getHelperUser().errorMessageWrongEmail());
        Assert.assertFalse(app.getHelperUser().isLogged());


    }

    @Test
    public void wrongPass() {
        User user = new User().withEmail("goodwin49@mail.ru").withPassword("ar12345");
        logger.info("Test Login Negative wrong password starts with email-->" + user.getEmail());
        logger.info("Test Login Negative wrong password starts with password-->" + user.getPassword());

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
