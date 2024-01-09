package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends AbstractPage{
    private final WebDriverWait wait;
    @FindBy(css ="form#new_user input[type='email']")
    private WebElement username;
    @FindBy(css = "form#new_user input#user_password")
    WebElement userpass;
    @FindBy(css = "form#new_user input[type='submit']")
    private WebElement buttonClick;
    @FindBy(xpath = "//input[@type='email']/following::li")
    private WebElement errorLogin;
    @FindBy(xpath = "//input[@type='password']/following::li")
    private WebElement errorPassword;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.wait = wait;
    }

    public void login(String login, String password){
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(login);
        wait.until(ExpectedConditions.visibilityOf(userpass)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(buttonClick)).click();
    }

    public String getTextLogin(){
        return wait.until(ExpectedConditions.visibilityOf(errorLogin)).getText();
    }

    public String getTextPassword(){
        return wait.until(ExpectedConditions.visibilityOf(errorPassword)).getText();
    }
}
