package tests;

import manager.ApplManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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
}
