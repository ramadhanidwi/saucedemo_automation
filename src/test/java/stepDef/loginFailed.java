package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class loginFailed {
    WebDriver driver;
    String baseUrl = "http://www.saucedemo.com/";


    @Given("User launch the application")
    public void user_launch_the_application() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("User input unregistered username")
    public void user_input_unregistered_username() {
        driver.findElement(By.id("user-name")).sendKeys("abnormal_user");

    }

    @And("User input registered password for failed")
    public void user_input_registered_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click login button for failed")
    public void user_click_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("error message launched")
    public void error_message_launched(){
        String errorLogin = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText();
        Assert.assertEquals(errorLogin,"Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
