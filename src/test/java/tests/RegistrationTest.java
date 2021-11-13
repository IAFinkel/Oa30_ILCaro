package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void regTestPositive(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        User newUser = new User().withEmail("asdh"+i+"@gmail.com").withPassword("Qwery1234").withName("Ilia")
                .withLastname("Petrov");
        logger.info("Test Registration Positive starts with email--->"+newUser.getEmail());
        logger.info("Test Registration Positive starts with password--->"+newUser.getPassword());

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().
                fillRegistrationForm(newUser);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().RegistrationSucces());

    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();

    }

}
