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

public class LoginTestClass {


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

    public void loginBtn() {
        WebElement clickLogin = driver.findElement(By.xpath("//a[@class='ico-login']"));
        clickLogin.click();

        WebElement welcomeText = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String expectedText = "Welcome, Please Sign In!";
        String actualText = welcomeText.getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void login() {

        WebElement clickLogin = driver.findElement(By.xpath("//a[@class='ico-login']"));
        clickLogin.click();

        WebElement welcomeText = driver.findElement(By.xpath("//div[@class='page-title']//h1[text()='Welcome, Please Sign In!']"));
        String expectedText = "Welcome, Please Sign In!";
        String actualText = welcomeText.getText();
        Assert.assertEquals(expectedText, actualText);

       // Thread.sleep(2000);
        WebElement enterEmail = driver.findElement(By.xpath("//input[@id='Email']"));
        enterEmail.sendKeys("heshvipatel17@gmail.com");

        WebElement enterPassword = driver.findElement(By.xpath("//input[@name='Password']"));
        enterPassword.sendKeys("Abc@123");

        WebElement clickLoginbtn = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        clickLoginbtn.click();

        WebElement loginSuccessfully = driver.findElement(By.xpath("//div[@class='topic-block-title']//h2[text()='Welcome to our store']"));
        String expectedLoginPage = "Welcome to our store";
        String actualLoginPage = loginSuccessfully.getText();
        Assert.assertEquals(actualLoginPage, expectedLoginPage);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}


