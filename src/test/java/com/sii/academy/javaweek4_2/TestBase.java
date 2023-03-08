package com.sii.academy.javaweek4_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Logger;

public class TestBase {

    private static final Logger logger = Logger.getAnonymousLogger();
    protected WebDriver webDriver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {

        logger.info("Initializing chrome webdriver");
        webDriver = new ChromeDriver();
    }


    @AfterEach
    public void tearDown() {
        webDriver.close();
    }

}
