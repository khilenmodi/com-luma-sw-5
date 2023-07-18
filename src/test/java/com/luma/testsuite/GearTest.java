package com.luma.testsuite;


import com.luma.pages.Gear;
import com.luma.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GearTest extends BaseTest {
    Gear gear;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        gear = new Gear();
    }

    @Test(groups = {"sanity", "smoke", "regression"})

    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        gear.mouseHooverOnGearMenu();
        //Thread.sleep(1000);
        gear.clickOnBags();
        //Thread.sleep(1000);
        gear.clickOnProductNameOvernightDuffle();

        String expectedText = "Overnight Duffle";
        String actualText = gear.getTextOvernightDuffle();
        Assert.assertEquals(actualText, expectedText);

        gear.changeQuantity("3");
        gear.clickAddToCart();

        String expectedCartMessage = "You added Overnight Duffle to your shopping cart.";
        String actualCartMessage = gear.getTextToVerifyText();
        Assert.assertEquals(actualCartMessage, expectedCartMessage);

        gear.clickOnShoppingCart();

        String expectedOvernightDuffleMessage = "Overnight Duffle";
        String actualOvernightDuffleMessage = gear.getTextToVerifyOvernightDuffleInTheCart();
        Assert.assertEquals(actualOvernightDuffleMessage, expectedOvernightDuffleMessage);

        String expectedQuantityInTheCart = "3";
        String actualQuantityInTheCart = gear.getTextToVerifyQuantityInTheCart();
        Assert.assertEquals(actualQuantityInTheCart, expectedQuantityInTheCart);

        // verify the amount $135.00
        String expectedTotalAmount = "$135.00";
        String actualTotalAmount = gear.getTextToVerifyTotalAmountInTheCart();
        Assert.assertEquals(actualTotalAmount, expectedTotalAmount);
        // change the qty to 5
        gear.changeTheQuantity("5");
        gear.clickOnUpdateShoppingCart();
        // * Verify the product price ‘$135
        String expectedUpdatedTotalAmount = "$135.00";
        String actualUpdatedTotalAmount = gear.getTextToVerifyTotalAmountInTheCartAfterUpdatingQty();
        Assert.assertEquals(actualUpdatedTotalAmount, expectedUpdatedTotalAmount);
    }

}


