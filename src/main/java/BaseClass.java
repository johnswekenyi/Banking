import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    WebDriver driver = new ChromeDriver();
    @Before
    public void setUp() {
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
