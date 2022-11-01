package SeleniumPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterUserPage {
    public RegisterUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "firstname")
    private WebElement firstName;
    @FindBy(how = How.NAME, using = "lastname")
    private WebElement lastName;
    @FindBy(how = How.NAME, using = "email")
    private WebElement email;
    @FindBy(how = How.NAME, using = "password")
    private WebElement password;
    @FindBy(how = How.NAME, using = "password_confirmation")
    private WebElement passwordConfirmation;

    @FindBy(how = How.XPATH, using = ".//button[@class='action submit primary']")
    private WebElement CreateButton;

    @FindBy(how = How.XPATH, using = ".//div[contains(text(),'Thank you')]")
    private WebElement verifyMessage;


    public void enterFirstName(String first_Name) {
        firstName.sendKeys(first_Name);
    }

    public void enterLastName(String last_Name) {
        lastName.sendKeys(last_Name);
    }

    public void enterEmailId(String email_Id) {
        email.sendKeys(email_Id);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void enterPasswordConfirmation(String password_Confirmation) {
        passwordConfirmation.sendKeys(password_Confirmation);
    }

    public void clickCreateButton() {
        CreateButton.click();
    }

    public String getVerifyMessage() {
        return verifyMessage.getText();
    }

}
