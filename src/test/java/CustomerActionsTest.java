import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static java.awt.SystemColor.text;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CustomerActionsTest extends BankManagerTest {
    @Test
    public void loginAsCustomerTest() throws InterruptedException {
        addNewCustomerTest();

        Thread.sleep(2000);
        assertAccountCreation();

        //Assert the user logged in is the created user
        assertTrue(driver.getPageSource().contains("Test Last"));
    }
    @Test
    public void verifyAccountCreatedIsTheSameTest() throws InterruptedException {
        createBankAccountForCustomer();
        Thread.sleep(2000);

        assertAccountCreation();
        assertTrue(driver.getPageSource().contains("Account Number : 1016"));
    }
    @Test
    public void depositMoneyToAccountAndVerifyTest() {

    }
    @Test
    public void withdrawMoneyFromAccountAndVerifyTest() {

    }

    private void assertAccountCreation() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(), 'Home')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Customer Login')]")).click();
        Thread.sleep(2000);

        Select selectCustomerToLogin = new Select(driver.findElement(By.name("userSelect")));
        selectCustomerToLogin.selectByVisibleText("Test Last");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(), 'Login')]")).click();
        Thread.sleep(2000);
    }
}
