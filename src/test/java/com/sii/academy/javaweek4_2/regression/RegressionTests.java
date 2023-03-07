package com.sii.academy.javaweek4_2.regression;

import com.sii.academy.javaweek4_2.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Execution(ExecutionMode.CONCURRENT)
class RegressionTests extends TestBase {
    private static final Logger logger = Logger.getAnonymousLogger();


    @Tag("Regression")
    @Tag("Sii")
    @ParameterizedTest
    @ValueSource(strings = {"https://siiportal.sii.pl"})
    void siiPortalTest(String url) {
        testPageTitle(url);

    }


    @Tag("Regression")
    @Tag("Onet")
    @ParameterizedTest
    @ValueSource(strings = {"http://www.onet.pl"})
    void onetTest(String url) {
        testPageTitle(url);
    }

    @Tag("Regression")
    @Tag("Kittens")
    @ParameterizedTest
    @ValueSource(strings = {"http://kotuszkowo.pl/"})
    void kittenTest(String url) {
        testPageTitle(url);
    }

    @Tag("Regression")
    @Tag("Filmweb")
    @ParameterizedTest
    @ValueSource(strings = {"https://www.filmweb.pl/"})
    void filmwebTest(String url) {
        testPageTitle(url);
    }

    @Tag("Regression")
    @Tag("Selenium")
    @ParameterizedTest
    @ValueSource(strings = {"https://www.selenium.dev/documentation/en/webdriver/"})
    void seleniumTest(String url) {
        testPageTitle(url);
    }

    private void testPageTitle(String url) {

        logger.info(String.format("Parallel testing website %s title. Process id=%d", url, Thread.currentThread().getId()));
        webDriver.get(url);
        String title = webDriver.getTitle();
        logger.info(String.format("Downloaded title: %s", title));
        assertNotNull(title, "Page title can't be initialized. Failure");
        assertFalse(title.isBlank(), "Title contains only white spaces. Failure");
        assertFalse(title.isEmpty(), "Empty title. Failure");

    }
}
