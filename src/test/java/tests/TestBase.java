package tests;

import manager.ApplManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    static ApplManager app = new ApplManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void startTest(Method m){
        logger.info("Start test--->"+m.getName());
    }

    @AfterMethod
    public void stopTest(Method m){
        logger.info("The end of test--->"+m.getName());
    }
}
