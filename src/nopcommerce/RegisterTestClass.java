package nopcommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegisterTestClass {
    private WebDriver driver;

    @Before
    public void openBrowser() {
        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @Test
    public void registerPage() {
        WebElement clickToRegLink = driver.findElement(By.xpath("//a[@class='ico-register']"));
        clickToRegLink.click();
        WebElement welcomeText = driver.findElement(By.xpath("//div[@class='title']//strong[text()='Your Personal Details']"));
        String expectedText = "Your Personal Details";
        String actualText = welcomeText.getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void Register() throws InterruptedException {

        WebElement clickToRegLink = driver.findElement(By.xpath("//a[@class='ico-register']"));
        clickToRegLink.click();
        WebElement welcomeText = driver.findElement(By.xpath("//div[@class='title']//strong[text()='Your Personal Details']"));
        String expectedText = "Your Personal Details";
        String actualText = welcomeText.getText();
        Assert.assertEquals(expectedText, actualText);

        Thread.sleep(2000);
        WebElement clickOnMale = driver.findElement(By.xpath("//input[@id='gender-male']"));
        clickOnMale.click();

        WebElement enterFirstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        enterFirstName.sendKeys("Jitu");

        WebElement enterLastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        enterLastName.sendKeys("Patel");

        WebElement day = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        day.sendKeys("1");

        WebElement month = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        month.sendKeys("January");

        WebElement year = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        year.sendKeys("2000");

        WebElement enterEmail = driver.findElement(By.xpath("//input[@name='Email']"));
        enterEmail.sendKeys("heshvipatel17+8@gmail.com");

        WebElement enterComName = driver.findElement(By.xpath("//input[@name='Company']"));
        enterComName.sendKeys("Prime Testing");

        WebElement enterPassword = driver.findElement(By.xpath("//input[@name='Password']"));
        enterPassword.sendKeys("Abc@123");

        WebElement enterConfirmPassword = driver.findElement(By.xpath("//input[@name='ConfirmPassword']"));
        enterConfirmPassword.sendKeys("Abc@123");

        WebElement clickRegiterBtn = driver.findElement(By.xpath("//input[@name='register-button']"));
        clickRegiterBtn.click();

        WebElement actualRegSuccessfully = driver.findElement(By.xpath("//div[@class='page-body']//div[text()='Your registration completed']"));
        String expectedRegText = "Your registration completed";
        String actualRegPage = actualRegSuccessfully.getText();
        Assert.assertEquals(actualRegPage, expectedRegText);


    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}


