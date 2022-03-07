package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddNewProductPage extends BasePage {
    public AddNewProductPage(WebDriver driver) {
        super(driver);
    }

    //    Product Name
    @FindBy(id = "Name")
    private WebElement productName;

    //    Short description
    @FindBy(id = "ShortDescription")
    private WebElement shortDesc;

    //    SKU
    @FindBy(id = "Sku")
    private WebElement sku;

    //    Categories
    @FindBy(xpath = "//*[@id='SelectedCategoryIds_taglist']/following-sibling::input")
    private WebElement categories;

    @FindBy(xpath = "//div[text()='Product info']/following-sibling::div/button")
    private WebElement productInfo;

    @FindBy(xpath = "(//*[@id=\"SelectedCategoryIds_listbox\"]//li)[1]")
    private WebElement categoryItem;

    //    Price
    @FindBy(id = "Price")
    private WebElement price;

    //    Old price
    @FindBy(id = "OldPrice")
    private WebElement oldPrice;

    //advanced
    @FindBy(id = "advanced-settings-mode")
    private WebElement advancedBtn;

    //    button save
    @FindBy(name = "save")
    private WebElement btnSave;

    public void addNewProduct(String n, String des, String s, String p, String o){
//        getWait().until(ExpectedConditions.visibilityOf(advancedBtn)).click();
        getWait().until(ExpectedConditions.visibilityOf(productName)).sendKeys(n);
        getWait().until(ExpectedConditions.visibilityOf(shortDesc)).sendKeys(des);
        getWait().until(ExpectedConditions.visibilityOf(sku)).sendKeys(s);
        getWait().until(ExpectedConditions.visibilityOf(categories)).click();
        getWait().until(ExpectedConditions.visibilityOf(categoryItem)).click();
        getWait().until(ExpectedConditions.visibilityOf(productInfo)).click();
        getWait().until(ExpectedConditions.visibilityOf(price)).clear();
        price.sendKeys(p);
        getWait().until(ExpectedConditions.visibilityOf(oldPrice)).clear();
        oldPrice.sendKeys(o);
        btnSave.click();
    }

}
