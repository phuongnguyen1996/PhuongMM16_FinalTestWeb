package test;

import core.BaseTest;
import core.ExcelUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class TestCase extends BaseTest {
    @Test(groups = {"CreateNewCategory"}, testName = "TC-1", priority = 1, dataProvider = "test-data-3", enabled = true)
    public void verifyCreateNewCategory(String n, String m) {
//        verifyMenuLeftPresentOnAdminPage
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin("https://admin-demo.nopcommerce.com/login");
        loginPage.clickButtonLogIn("admin@yourstore.com", "admin");
        MenuLeft menuLeft = new MenuLeft(getDriver());
        Assert.assertTrue(menuLeft.verifyMenuLeftPresentOnAdminPage());

//        verifyPresentOnCategoriesPage
        menuLeft.goToScreenCategories();
        CategoriesPage categoriesPage = new CategoriesPage(getDriver());
        Assert.assertTrue(categoriesPage.verifyPresentOnCategoriesPage());

//        verifyMessageCreateNewCategory
        categoriesPage.clickButtonAddNew();
        AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(getDriver());
        addNewCategoryPage.addNewCategory(n);
        Assert.assertTrue(categoriesPage.verifyMessageCreateNewCategory(m));

//        verifyLogOutSuccess
        AdminPage adminPage = new AdminPage(getDriver());
        adminPage.clickLogOut();
        Assert.assertTrue(loginPage.verifyLogOutSuccess("Welcome, please sign in!"));
    }

    @DataProvider(name = "test-data-3")
    public Object[][] getDataTC3() throws Exception {
        return ExcelUtils.getTableArray("DataTest.xlsx", "TC3", 0, 2);
    }

    @Test(groups = {"CreateNewCustomer"}, testName = "TC-2", priority = 2, dataProvider = "test-data-6", enabled = true)
    public void verifyCreateNewCustomer(String n, String des, String s, String p, String o, String m) {
        n = RandomStringUtils.randomAlphanumeric(5);
        des = RandomStringUtils.randomAlphanumeric(6);
        s = RandomStringUtils.randomAlphanumeric(3);
//        verifyMenuLeftPresentOnAdminPage
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin("https://admin-demo.nopcommerce.com/login");
        loginPage.clickButtonLogIn("admin@yourstore.com", "admin");
        MenuLeft menuLeft = new MenuLeft(getDriver());
        Assert.assertTrue(menuLeft.verifyMenuLeftPresentOnAdminPage());

//        verifyPresentOnProductsPage
        menuLeft.goToScreenProducts();
        ProductsPage productsPage = new ProductsPage(getDriver());
        Assert.assertTrue(productsPage.verifyPresentOnProductsPage());

//        verifyMessageCreateNewProduct
        productsPage.clickButtonAddNew();
        AddNewProductPage addNewProductPage = new AddNewProductPage(getDriver());
        addNewProductPage.addNewProduct(n, des, s, p, o);
        Assert.assertTrue(productsPage.verifyMessageCreateNewProduct(m));

//        verifyLogOutSuccess
        AdminPage adminPage = new AdminPage(getDriver());
        adminPage.clickLogOut();
        Assert.assertTrue(loginPage.verifyLogOutSuccess("Welcome, please sign in!"));
    }

    @DataProvider(name = "test-data-6")
    public Object[][] getDataTC6() throws Exception {
        return ExcelUtils.getTableArray("DataTest.xlsx", "TC6", 0, 6);
    }
}
