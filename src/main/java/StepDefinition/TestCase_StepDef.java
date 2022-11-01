package StepDefinition;

import Parser.Result;
import Parser.UserResponseModel;
import RestAssuredRequest.Request;
import SeleniumPages.CheckoutPage;
import SeleniumPages.ItemDetailPage;
import SeleniumPages.RegisterUserPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TestCase_StepDef {
    WebDriver driver;
    public final static int TIMEOUT = 10;
    Request request = new Request();

    Result userData = new Result();

    @Given("^Generate User On RandomUser$")
    public void generate_user_on_randomuser() throws Throwable {
        UserResponseModel userResponse = request.getRandomUser();
        userData = userResponse.getResults().get(0);
    }

    @When("^Open Register User Page Of Magento Application$")
    public void open_register_user_page_of_magento_application() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    @Then("^Verify User Successfully Registration$")
    public void verify_user_successfully_registration() throws Throwable {
        RegisterUserPage registerUserPage = new RegisterUserPage(driver);
        Assert.assertEquals(registerUserPage.getVerifyMessage(), "Thank you for registering with Fake Online Clothing Store.");
    }

    @And("^Enter Fields Value In Register User Page$")
    public void enter_fields_value_in_register_user_page() throws Throwable {
        RegisterUserPage registerUserPage = new RegisterUserPage(driver);
        registerUserPage.enterFirstName(userData.getName().getFirst());
        registerUserPage.enterLastName(userData.getName().getLast());
        registerUserPage.enterEmailId(userData.getEmail());
        registerUserPage.enterPassword("Test123@" + userData.getLogin().getPassword());
        registerUserPage.enterPasswordConfirmation("Test123@" + userData.getLogin().getPassword());
        registerUserPage.clickCreateButton();
    }

    @And("^Go to Men Store Section$")
    public void go_to_men_store_section() throws Throwable {
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver);
        itemDetailPage.clickOnMenStore();
    }

    @And("^Click on Any Item to purchase$")
    public void click_on_any_item_to_purchase() throws Throwable {
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver);
        itemDetailPage.clickOnProductItem();
    }

    @Then("^Select Size Color and click on Add To Cart$")
    public void select_size_color_and_click_on_add_to_cart() throws Throwable {
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver);
        itemDetailPage.clickOnProductSize();
        itemDetailPage.clickOnProductColor();
        itemDetailPage.clickOnAddToCartButton();
        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(15));
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-bind,'prepareMessageForHtml')]")));
    }

    @And("^Click on Checkout Page Button$")
    public void click_on_checkout_page_button() throws Throwable {
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver);
        itemDetailPage.clickOnShowCartButton();
        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(15));
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action.viewcart")));
        itemDetailPage.clickOnViewCartButton();
        itemDetailPage.clickOnCheckoutPageButton();
    }

    @Then("^Enter Shipping Address Details In Page$")
    public void enter_shipping_address_details_in_page() throws Throwable {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterStreetNumber(userData.getLocation().getStreet().getNumber());
        checkoutPage.enterStreetName(userData.getLocation().getStreet().getName());
        checkoutPage.enterCityName(userData.getLocation().getCity());
        checkoutPage.enterStateName("Alaska");
        checkoutPage.enterZipCode(userData.getLocation().getPostcode());
        checkoutPage.enterCountryName("United States");
        checkoutPage.enterPhoneNumber(userData.getPhone());
    }

    @And("^Click on FlatRate Option And Click On Next Page Button$")
    public void click_on_flatrate_option_and_click_on_next_page_button() throws Throwable {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickOnFlatRate();
        checkoutPage.clickOnNextPageButton();
    }

    @Then("^Click On Place Order Button and Verify that the purchase was successful$")
    public void click_on_place_order_button_and_verify_that_the_purchase_was_successful() throws Throwable {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(15));
        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='billing-address-details']")));
        checkoutPage.clickOnPlaceOrderButton();
        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".order-number")));
        Assert.assertEquals(checkoutPage.getVerifyPurchaseMessage(), "Thank you for your purchase!");
        driver.quit();
    }


}


