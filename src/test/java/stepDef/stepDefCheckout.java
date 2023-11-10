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

public class stepDefCheckout {

    WebDriver driver;
    String baseUrl = "http://www.saucedemo.com/";

    @Given("User in page cart")
    public void user_in_page_cart(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String page_cart = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        Assert.assertEquals(page_cart,"Swag Labs");
    }

    @And("User click Add To Cart button for products want to buy")
    public void user_click_add_to_cart(){
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

    }
    @And("User click Cart button")
    public void user_click_cart_button(){
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
    }
    @Then("User is on Your Cart page")
    public void user_is_on_your_cart_page(){
        String user_data = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(user_data,"Your Cart");
    }

    @And("User click Checkout button")
    public void user_click_checkout_button_in_cart(){
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @Then("User is on form personal data page")
    public void user_is_on_form_personal_data_page(){
        String personal_data = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(personal_data,"Checkout: Your Information");
    }

    @And("User input firstname")
    public void user_input_firstname(){
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("ramadhani");
    }

    @And("User input lastname")
    public void user_input_lastname(){
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("dwi");
    }

    @And("User input postal code")
    public void user_input_postal_code(){
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("40425");
    }

    @And("User click Continue button")
    public void user_click_continue_button(){
        driver.findElement(By.xpath("//input[@id='continue']")).click();
    }

    @Then("User is on overview page")
    public void user_is_on_overview_page(){
        String overview = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(overview,"Checkout: Overview");
    }

    @And("User click Finish button")
    public void user_click_finish_button(){
        driver.findElement(By.xpath("//button[@id='finish']")).click();

    }

    @Then("a success message page is launch")
    public void a_success_message_page_is_launch(){
        String success_message = driver.findElement(By.xpath("//h2[normalize-space()='Thank you for your order!']")).getText();
        Assert.assertEquals(success_message,"Thank you for your order!");
    }

}
