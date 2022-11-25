import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;

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
//        assertTrue(driver.getPageSource().contains("Account Number :"));
        assertTrue(driver.findElement
                (By.xpath("//body//div[@class='ng-scope']//div[@class='ng-scope']//div[2]"))
                .getText().contains("Account Number"));
    }
    @Test
    public void depositMoneyToAccountAndVerifyTest() throws InterruptedException {
        verifyAccountCreatedIsTheSameTest();
        deposit();
    }
    @Test
    public void withdrawMoreMoneyFromAccountThanAvailableBalanceTest() throws InterruptedException {
        verifyAccountCreatedIsTheSameTest();

        driver.findElement(By.xpath("//button[normalize-space()='Withdrawl']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder='amount']")).sendKeys("500");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);

        assertTrue(driver.findElement(By.xpath("//span[@class='error ng-binding']"))
                .getText().contains("Transaction Failed. You can not withdraw amount more than the balance."));

        driver.findElement(By.xpath("//button[normalize-space()='Transactions']")).click();
        Thread.sleep(1000);
    }

    @Test
    public void withdrawAmountLessThanAvailableBalance() throws InterruptedException {
        verifyAccountCreatedIsTheSameTest();
        Thread.sleep(2000);
        deposit();

        driver.findElement(By.xpath("//button[normalize-space()='Transactions']")).click();
        Thread.sleep(1000);
        assertTrue(driver.getPageSource().contains("1000 :"));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[normalize-space()='Withdrawl']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder='amount']")).sendKeys("500");
        driver.findElement(By.cssSelector(".btn-default")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(), 'Transactions')]")).click();
        Thread.sleep(1000);
        assertTrue(driver.getPageSource().contains("Transaction successful"));
    }

    private void assertAccountCreation() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='btn home']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Customer Login']")).click();
        Thread.sleep(2000);

        Select selectCustomerToLogin = new Select(driver.findElement(By.name("userSelect")));
        selectCustomerToLogin.selectByVisibleText("Test Last");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
    }

    public void deposit() throws InterruptedException {
        driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder='amount']")).sendKeys("1000");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[normalize-space()='Transactions']")).click();
        Thread.sleep(1000);
        assertTrue(driver.getPageSource().contains("1000 :"));
        Thread.sleep(1000);
    }
}
