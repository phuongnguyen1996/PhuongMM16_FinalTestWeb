package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CategoriesPage extends BasePage {
    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    //    Add new
    @FindBy(xpath = "//a[@href='/Admin/Category/Create']")
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

    //    Category name
    @FindBy(id = "SearchCategoryName")
    private WebElement categoryName;

    //    Published
    @FindBy(id = "SearchPublishedId")
    private WebElement published;

    //    Alert create success
    @FindBy(xpath = "//div[contains(@class,'alert')]")
    private WebElement messageCreateSuccess;

    public boolean verifyPresentOnCategoriesPage() {
        return btnAddNew.isDisplayed() && btnExport.isDisplayed() && btnImport.isDisplayed() && btnDelete.isDisplayed()
                && categoryName.isDisplayed() && published.isDisplayed();
    }

    public void clickButtonAddNew() {
        btnAddNew.click();
    }

    public boolean verifyMessageCreateNewCategory(String m) {
        getWait().until(ExpectedConditions.visibilityOf(messageCreateSuccess));
        return messageCreateSuccess.getText().substring(1).trim().equals(m);
    }
}
