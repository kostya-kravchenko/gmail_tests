package com.cursor.edu.browsers;

import com.cursor.edu.IBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitTemporary implements IBrowser {
    public WebDriver getBrowser() {
        return new HtmlUnitDriver(true);
    }

}
