package com.cursor.edu.browsers;

import com.cursor.edu.IBrowser;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public enum Browsers {
    DEFAULT(new ChromeTemporary()),
    FIREFOX(new FirefoxTemporary()),
    FIREFOX_HEADLESS(new FirefoxHeadless()),
    CHROME(new ChromeTemporary()),
    CHROME_PROFILE(new ChromeProfile()),
    CHROME_HEADLESS(new ChromeHeadless());

    private final IBrowser instance;

    Browsers(IBrowser browser) {
        this.instance = browser;
    }

    public WebDriver open(String url, Long implicitlyWait) {
        WebDriver driver = instance.getBrowser();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}
