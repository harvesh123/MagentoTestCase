package SeleniumPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ItemDetailPage {
    public ItemDetailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = ".//span[contains(text(),'Men')]//ancestor::a[@class='level-top ui-corner-all']")
    private WebElement MenStoreButton;

    @FindBy(how = How.XPATH, using = "//li[@class='product-item'][1]")
    private WebElement product;

    @FindBy(how = How.XPATH, using = "//div[@class='swatch-option text' and contains(text(),'M')]")
    private WebElement productSize;

    @FindBy(how = How.XPATH, using = "//div[@class='swatch-option color' and @option-label='Gray']")
    private WebElement productColor;

    @FindBy(how = How.CSS, using = ".action.primary.tocart")
    private WebElement addToCartButton;
    @FindBy(how = How.CSS, using = ".action.showcart")
    private WebElement cartPopUpButton;

    @FindBy(how = How.CSS, using = ".action.viewcart")
    private WebElement viewCartButton;

    @FindBy(how = How.XPATH, using = "//li[@class='item']//button[@class='action primary checkout']")
    private WebElement checkoutButton;

    public void clickOnMenStore() {
        MenStoreButton.click();
    }

    public void clickOnProductItem() {
        product.click();
    }

    public void clickOnProductSize() {
        productSize.click();
    }

    public void clickOnProductColor() {
        productColor.click();
    }

    public void clickOnAddToCartButton() throws InterruptedException {
        addToCartButton.click();
    }

    public void clickOnShowCartButton() {
        cartPopUpButton.click();
    }

    public void clickOnCheckoutPageButton() {
        checkoutButton.click();
    }

    public void clickOnViewCartButton() {
        viewCartButton.click();
    }

}
