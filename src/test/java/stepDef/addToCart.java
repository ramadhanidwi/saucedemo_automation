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

public class addToCart {
    WebDriver driver;
    String baseUrl = "http://www.saucedemo.com/";

    @Given("User launch the application to add the cart")
    public void user_launch_the_application_to_add_the_cart (){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("User click 'Add To Cart' button")
    public void user_click_add_to_cart_button(){
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @And("User click the button with the cart logo")
    public void user_click_the_button_with_the_cart_logo(){
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @Then("Page cart will launch")
    public void page_cart_will_launch() {
        String pageCart = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(pageCart,"Your Cart");
        driver.quit();
    }
}
