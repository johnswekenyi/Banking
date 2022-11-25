import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CustomerActionsTest extends BankManagerTest {
    @Test
    public void loginAsCustomerTest() throws InterruptedException {
        addNewCustomerTest();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(), 'Home')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Customer Login')]")).click();
        Thread.sleep(2000);

        Select selectCustomerToLogin = new Select(driver.findElement(By.name("userSelect")));
        selectCustomerToLogin.selectByVisibleText("Test Last");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(), 'Login')]")).click();

        Thread.sleep(2000);

        //Assert the user logged in is the created user
        //ToDo
    }
    @Test
    public void verifyAccountCreatedIsTheSameTest() {

    }
    @Test
    public void depositMoneyToAccountAndVerifyTest() {

    }
    @Test
    public void withdrawMoneyFromAccountAndVerifyTest() {

    }
}
