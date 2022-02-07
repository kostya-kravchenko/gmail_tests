package com.cursor.edu.browsers;

import com.cursor.edu.IBrowser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeProfile implements IBrowser {
    public WebDriver getBrowser() {
        WebDriverManager.chromedriver().setup();
        String userProfile = System.getenv("HOMEPATH") + "\\AppData\\Local\\Google\\Chrome\\User Data";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + userProfile);
        return new ChromeDriver(options);
    }
}
