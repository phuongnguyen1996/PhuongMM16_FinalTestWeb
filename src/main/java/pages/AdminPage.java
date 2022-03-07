package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage {
    public AdminPage(WebDriver driver) {
        super(driver);
    }

//    Logout
    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logOut;

    public void clickLogOut(){
        logOut.click();
    }
}
