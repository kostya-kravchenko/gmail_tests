package com.cursor.edu.browsers;

import com.cursor.edu.IBrowser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PhantomjsTemporary  implements IBrowser {
    public WebDriver getBrowser() {
//        WebDriverManager.phantomjs().setup();
        return new PhantomJSDriver();
    }
}
