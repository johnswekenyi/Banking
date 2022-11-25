import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class BaseClass {
    WebDriver driver = new ChromeDriver();
    public static Properties Locators = new Properties();

    public static WebDriverWait wait;
    @Before
    public void setUp() {
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
