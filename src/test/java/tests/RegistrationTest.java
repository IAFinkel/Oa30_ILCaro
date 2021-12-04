package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

//    @Test(dataProvider = "registrationCSV", dataProviderClass = MyDataProvider.class)
//    public void regTestPositive(User user) {
//        logger.info("Test Registration Positive starts with email--->" + user.getEmail());
//        logger.info("Test Registration Positive starts with password--->" + user.getPassword());
//        logger.info("Test Registration Positive starts with name--->" + user.getName());
//        logger.info("Test Registration Positive starts with lastname--->" + user.getLastname());
//
//        app.getHelperUser().openRegistrationForm();
//        app.getHelperUser().
//                fillRegistrationForm(user);
//        app.getHelperUser().checkPolicy();
//        app.getHelperUser().submitRegistration();
//
//        Assert.assertTrue(app.getHelperUser().RegistrationSucces());
//
//    }

    @Test(dataProvider = "registrationDto", dataProviderClass = MyDataProvider.class)
    public void regTestPositive(User user) {
        logger.info("Test Registration Positive starts with email--->" + user.getEmail());
        logger.info("Test Registration Positive starts with password--->" + user.getPassword());
        logger.info("Test Registration Positive starts with name--->" + user.getName());
        logger.info("Test Registration Positive starts with lastname--->" + user.getLastname());

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().
                fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().registrationSucces());

    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        app.getHelperUser().clickOkButton();

    }

}
