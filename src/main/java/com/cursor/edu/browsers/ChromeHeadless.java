package com.cursor.edu.browsers;

import com.cursor.edu.IBrowser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadless implements IBrowser {
    public WebDriver getBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-proxy-server");
        options.addArguments("--ignore-certificate-errors");
        return new ChromeDriver(options);
    }
}
