package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuLeft extends BasePage {
    public MenuLeft(WebDriver driver) {
        super(driver);
    }

    //    menu left
    @FindBy(xpath = "//aside//nav/ul")
    private WebElement menuLeft;

    //    Catalog
    @FindBy(xpath = "(//p[contains(text(),'Catalog')]//parent::a)[1]")
    private WebElement catalogItem;

    //    Categories
    @FindBy(xpath = "//p[contains(text(),'Categories')]//parent::a")
    private WebElement categoriesItem;

    //    Products
    @FindBy(xpath = "(//p[contains(text(),'Products')]//parent::a)[1]")
    private WebElement productsItem;

    public boolean verifyMenuLeftPresentOnAdminPage() {
        getWait().until(ExpectedConditions.visibilityOf(menuLeft));
        return menuLeft.isDisplayed();
    }

    public void goToScreenCategories(){
        getWait().until(ExpectedConditions.visibilityOf(catalogItem)).click();
        getWait().until(ExpectedConditions.visibilityOf(categoriesItem)).click();
    }

    public void goToScreenProducts(){
        getWait().until(ExpectedConditions.visibilityOf(catalogItem)).click();
        getWait().until(ExpectedConditions.visibilityOf(productsItem)).click();
    }
}
