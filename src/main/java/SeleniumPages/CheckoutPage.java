package SeleniumPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "street[0]")
    private WebElement streetNumber;

    @FindBy(how = How.NAME, using = "street[1]")
    private WebElement streetName;

    @FindBy(how = How.NAME, using = "city")
    private WebElement city;

    @FindBy(how = How.NAME, using = "region_id")
    private WebElement state;

    @FindBy(how = How.NAME, using = "postcode")
    private WebElement zipCode;

    @FindBy(how = How.NAME, using = "country_id")
    private WebElement country;

    @FindBy(how = How.NAME, using = "telephone")
    private WebElement phoneNumber;

    @FindBy(how = How.XPATH, using = "//input[@name='ko_unique_3' and @value='flatrate_flatrate']")
    private WebElement flatRate;

    @FindBy(how = How.CSS, using = ".button.action.continue.primary")
    private WebElement nextButton;

    @FindBy(how = How.CSS, using = ".action.primary.checkout")
    private WebElement placeOrderButton;

    @FindBy(how = How.XPATH, using = "//*[@class='page-title']/span[@class='base']")
    private WebElement verifyOrderMessage;

    public void enterStreetNumber(String street_Number) {
        streetNumber.sendKeys(street_Number);
    }

    public void enterStreetName(String street_Name) {
        streetName.sendKeys(street_Name);
    }

    public void enterCityName(String city_Name) {
        city.sendKeys(city_Name);
    }

    public void enterStateName(String state_Name) {
        Select stateName = new Select(state);
        stateName.selectByVisibleText(state_Name);
    }

    public void enterZipCode(String zip_Name) {
        zipCode.sendKeys(zip_Name);
    }

    public void enterCountryName(String Country_Name) {
        Select countryName = new Select(country);
        countryName.selectByVisibleText(Country_Name);
    }

    public void enterPhoneNumber(String phone_Name) {
        phoneNumber.sendKeys(phone_Name);
    }

    public void clickOnFlatRate() {
        flatRate.click();
    }

    public void clickOnNextPageButton() {
        nextButton.click();
    }

    public void clickOnPlaceOrderButton() {
        placeOrderButton.click();
    }

    public String getVerifyPurchaseMessage() {
        return verifyOrderMessage.getText();
    }
}
