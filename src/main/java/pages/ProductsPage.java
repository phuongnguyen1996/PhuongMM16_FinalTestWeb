package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    //    Add new
    @FindBy(xpath = "//a[@href='/Admin/Product/Create']")
    private WebElement btnAddNew;

    //    Export
    @FindBy(xpath = "(//div[@class='btn-group']//button)[1]")
    private WebElement btnExport;

    //    Import
    @FindBy(name = "importexcel")
    private WebElement btnImport;

    //    Delete
    @FindBy(id = "delete-selected")
    private WebElement btnDelete;

    //    Product name
    @FindBy(id = "SearchProductName")
    private WebElement productName;

    //    Warehouse
    @FindBy(id = "SearchWarehouseId")
    private WebElement warehouse;

    //    Category
    @FindBy(id = "SearchCategoryId")
    private WebElement category;

    //    Product type
    @FindBy(id = "SearchProductTypeId")
    private WebElement productType;

    //    Alert create success
    @FindBy(xpath = "//div[contains(@class,'alert')]")
    private WebElement messageCreateSuccess;

    public boolean verifyPresentOnProductsPage() {
        return btnAddNew.isDisplayed() && btnExport.isDisplayed() && btnImport.isDisplayed() && btnDelete.isDisplayed()
                && productName.isDisplayed() && warehouse.isDisplayed() && category.isDisplayed() && productType.isDisplayed();
    }

    public void clickButtonAddNew() {
        btnAddNew.click();
    }

    public boolean verifyMessageCreateNewProduct(String m) {
        getWait().until(ExpectedConditions.visibilityOf(messageCreateSuccess));
        return messageCreateSuccess.getText().substring(1).trim().equals(m);
    }
}
