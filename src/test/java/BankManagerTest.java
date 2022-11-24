import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class BankManagerTest extends BaseClass {
    @Test
    public void loginAsBankManagerTest() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(), 'Bank Manager Login')]")).click();
        Thread.sleep(2000);
    }
    @Test()
    public void addNewCustomerTest() throws InterruptedException {
        loginAsBankManagerTest();
        driver.findElement(By.xpath("//button[contains(text(), 'Add Customer\n" +
                "\t\t')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("Test");
        driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Last");
        driver.findElement(By.cssSelector("input[placeholder='Post Code']")).sendKeys("00100");
        driver.findElement(By.cssSelector(".btn-default")).click();

        Thread.sleep(2000);
    }

    @Test
    public void createBankAccountForCustomer() {

    }

    @Test
    public void deleteCreatedUserTest() {

    }
}
