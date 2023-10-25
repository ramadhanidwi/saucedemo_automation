package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "http://www.saucedemo.com/";

    @Given("User launch the application success")
    public void user_launch_the_application_success (){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @And("User input registered username")
    public void user_input_registered_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User input registered password")
    public void user_input_registered_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click login button")
    public void user_click_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("Page home launched")
    public void page_home_launched() {
        String loginSuccess = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(loginSuccess,"Products");
        driver.close();
    }
}
