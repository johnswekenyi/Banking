import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BankManagerTest extends BaseClass {
    @Test
    public void loginAsBankManagerTest() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(), 'Bank Manager Login')]")).click();
        Thread.sleep(2000);
    }
    @Test()
    public void addNewCustomerTest() throws InterruptedException {
        loginAsBankManagerTest();
        driver.findElement(By.xpath("//button[contains(text(), 'Add Customer')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("Test");
        driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Last");
        driver.findElement(By.cssSelector("input[placeholder='Post Code']")).sendKeys("00100");
        driver.findElement(By.cssSelector(".btn-default")).click();

        //Assert customer is successfully created
        assertThat(driver.switchTo().alert().getText(), is("Customer added successfully with customer id :6"));
        Alert alert = driver.switchTo().alert();
        alert.accept();

        Thread.sleep(2000);
    }
    @Test
    public void createBankAccountForCustomer() throws InterruptedException {
        addNewCustomerTest();
        driver.findElement(By.xpath("//button[contains(text(), 'Open Account')]")).click();
        Thread.sleep(2000);

        //Select Created customer
        Select selectCustomer = new Select(driver.findElement(By.name("userSelect")));
        selectCustomer.selectByVisibleText("Test Last");

        //Select currency for account creation
        Select selectCurrency = new Select(driver.findElement(By.name("currency")));
        selectCurrency.selectByVisibleText("Dollar");
        driver.findElement(By.xpath("//button[contains(text(), 'Process')]")).click();
        Thread.sleep(2000);

        assertThat(driver.switchTo().alert().getText(), is("Account created successfully with account Number :1016"));
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @Test
    public void deleteCreatedUserTest() {

    }
}
