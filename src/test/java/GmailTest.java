import com.cursor.edu.browsers.Browsers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Objects;

public class GmailTest {

    private final String login = "cursor.edu.for.test.1@gmail.com";
    private final String password = "qwerty+1+qwerty";
    private WebDriver driver;
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (Objects.nonNull(driver)) {
            if (!result.isSuccess()) {
                String testName = result.getName();
                System.out.println("***TC error, name = " + testName + " ERROR");
                // Take Screenshot, Save sourceCode, Save to log, Prepare report, Return to previous state, logout, etc.
            }
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @Test(dataProvider = "browsers")
    public void testGmailLogin(Browsers browser) throws InterruptedException {
        driver = browser.open("https://google.com", IMPLICITLY_WAIT_SECONDS);
        driver.findElement(By.xpath("//a[starts-with(@href, 'https://mail') and contains(@class,'gb_d')]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//a[starts-with(@href,'https://accounts.google.com')]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='identifierId']")));
        WebElement email_input = driver.findElement(By.name("identifier"));
        email_input.clear();
        email_input.sendKeys(login);
//        email_input.sendKeys(Keys.ENTER);
        driver.findElement(By.id("identifierNext")).click();
        new WebDriverWait(driver, Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
        WebElement passwd_input = driver.findElement(By.xpath("//div[@id='password']//input"));
        new WebDriverWait(driver, Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='password']//input")));
        passwd_input.clear();
        passwd_input.sendKeys(password);
//        passwd_input.sendKeys(Keys.ENTER);
        driver.findElement(By.id("passwordNext")).click();
        new WebDriverWait(driver, Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@aria-label,'" + login + "')]")));
        Thread.sleep(3000);
    }

    @DataProvider
    public Object[][] browsers() {
        return new Object[][]{
                {Browsers.DEFAULT},
                {Browsers.CHROME},
//                {Browsers.CHROME_HEADLESS},
                {Browsers.FIREFOX},
                {Browsers.FIREFOX_HEADLESS},
        };
    }
}
