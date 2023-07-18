package com.luma.testsuite;


import com.luma.pages.Women;
import com.luma.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WomenTest extends BaseTest {
    Women women;
    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        women =new Women();
    }

    @Test (groups = {"sanity", "regression"})
    public void verifyTheSortByProductNameFilter() {
        // * Mouse Hover on Women Menu
        women.mouseHoverOnWomen();
        //* Mouse Hover on Tops
        women.mouseHoverOnTop();
        //* Click on Jackets
        women.clickOnJacket();
        //* Select Sort By filter “Product Name”
        women.selectProductNameFilter("Product Name");
        // * Verify the products name display in alphabetical order
        Assert.assertEquals(women.getProductList1(), women.getProductList2());
    }

    @Test(groups = {"sanity","smoke", "regression"})
    public void verifyTheSortByPriceFilter(){
        women.mouseHoverOnWomen();
        //* Mouse Hover on Tops
        women.mouseHoverOnTop();
        //* Click on Jackets
        women.clickOnJacket();
        // Select Sort By filter “Price”
        women.selectSortPrice();
        // Verify the products price display inLow to High
        Assert.assertEquals(women.getPriceList1(), women.getPriceList2());
    }
}


