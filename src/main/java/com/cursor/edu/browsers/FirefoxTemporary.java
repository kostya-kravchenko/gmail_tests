package com.cursor.edu.browsers;

import com.cursor.edu.IBrowser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTemporary implements IBrowser {
    public WebDriver getBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
