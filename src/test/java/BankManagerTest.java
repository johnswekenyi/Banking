import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BankManagerTest {
    @Before
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }
    @Test
    public void loginAsBankManagerTest() {

    }

    @Test
    public void addNewCustomerTest(){

    }

    @Test
    public void createBankAccountForCustomer() {

    }

    @Test
    public void deleteCreatedUserTest() {

    }
}
