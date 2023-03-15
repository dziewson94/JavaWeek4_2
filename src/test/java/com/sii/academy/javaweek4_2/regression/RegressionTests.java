package com.sii.academy.javaweek4_2.regression;

import com.sii.academy.javaweek4_2.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Execution(ExecutionMode.CONCURRENT)
class RegressionTests extends TestBase {


    @Tag("Regression")
    @ParameterizedTest
    @ValueSource(strings = {"https://wwww.siiportal.sii.pl", "http://www.onet.pl", "http://www.kotuszkowo.pl/", "https://www.filmweb.pl/", "https://www.selenium.dev/documentation/en/webdriver/"})
    void siiPortalTest(String url) {
        logger.info(String.format("Parallel testing website %s title. Process id=%d", url, Thread.currentThread().getId()));
        webDriver.get(url);
        String title = webDriver.getTitle();
        logger.info(String.format("Downloaded title: %s", title));
        assertNotNull(title, "Page title can't be initialized. Failure");
        assertFalse(title.isBlank(), "Title contains only white spaces. Failure");
        assertFalse(title.isEmpty(), "Empty title. Failure");

    }
}
