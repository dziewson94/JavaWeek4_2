package com.sii.academy.javaweek4_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Logger;

public class TestBase {

    protected static final String CHROMEDRIVER_PATH = "C:\\Users\\mdziewa\\webdriver\\chromedriver.exe";
    protected static final String CHROME_DRIVER_SYSTEM_PROPERTY = "webdriver.chrome.driver";
    private static final Logger logger = Logger.getAnonymousLogger();
    protected WebDriver webDriver;

    @BeforeEach
    public void setup() {

        System.setProperty(CHROME_DRIVER_SYSTEM_PROPERTY, CHROMEDRIVER_PATH);
        logger.info("Initializing chrome webdriver");
        webDriver = new ChromeDriver();
    }


    @AfterEach
    public void tearDown() {
        webDriver.close();
    }

}
