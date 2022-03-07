package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 50);
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void scrollPage(WebElement item) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        int i = 1000;
        int j = 0;
        boolean check = false;

        do {
            try {
                if (item.isDisplayed())
                    check = true;
            } catch (Exception e) {
                check = false;
                js.executeScript("window.scrollBy(" + j + "," + i + ");");
                j = i;
                i += i;
            }
        } while (!check);

    }
}
