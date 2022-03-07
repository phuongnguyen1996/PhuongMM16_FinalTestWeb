package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddNewCategoryPage extends BasePage {
    public AddNewCategoryPage(WebDriver driver) {
        super(driver);
    }

//    Category Name
    @FindBy(id = "Name")
    private WebElement categoryName;

//    button save
    @FindBy(name = "save")
    private WebElement btnSave;

    public void addNewCategory(String n){
        getWait().until(ExpectedConditions.visibilityOf(categoryName)).sendKeys(n);
        btnSave.click();
    }

}
