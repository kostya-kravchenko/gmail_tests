package com.cursor.edu.browsers;

import com.cursor.edu.IBrowser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTemporary implements IBrowser {
    public WebDriver getBrowser() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
