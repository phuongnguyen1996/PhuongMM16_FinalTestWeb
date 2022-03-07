package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //    Email
    @FindBy(id = "Email")
    private WebElement email;

    //    Pass
    @FindBy(id = "Password")
    private WebElement pass;

    //    button Login in
    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement btnLogIn;

    //    title
    @FindBy(tagName = "strong")
    private WebElement title;

    public void navigateToLogin(String url) {
        getDriver().get(url);
    }

    public void clickButtonLogIn(String e, String p) {
        getWait().until(ExpectedConditions.visibilityOf(email)).clear();
        email.sendKeys(e);
        getWait().until(ExpectedConditions.visibilityOf(pass)).clear();
        pass.sendKeys(p);
        btnLogIn.click();
    }

    public boolean verifyLogOutSuccess(String t) {
        getWait().until(ExpectedConditions.visibilityOf(title));
        return title.getText().equals(t);
    }
}
