package com.luma.pages;

import com.luma.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Women extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-4']")
    WebElement Women;

    @CacheLookup
    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[2]")
    WebElement Top;
    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-11']")
    WebElement Jacket;
    @CacheLookup
    @FindBy(xpath = "//div[2]//div[3]//select[1]")
    WebElement sortBy;
    @CacheLookup
    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]")
    WebElement Price;
    @CacheLookup
    @FindBy(xpath = "//div[2]//div[3]//select[1]")
    WebElement productFilter;
    @CacheLookup
    @FindBy(xpath = "//strong[@class = 'product name product-item-name']")
    List<WebElement> nameList1;
    @CacheLookup
    @FindBy(xpath = "//strong[@class = 'product name product-item-name']")
    List<WebElement> nameList2;
    @CacheLookup
    @FindBy(xpath = "//span[@class='price-wrapper ']//span")
    List<WebElement> priceList1;
    @CacheLookup
    @FindBy(xpath = "//span[@class='price-wrapper ']//span")
    List<WebElement> priceList2;

    public void mouseHoverOnWomen() {
        mouseHoverToElement(Women);
    }

    public void mouseHoverOnTop() {
        mouseHoverToElement(Top);
    }

    public void clickOnJacket() {
        clickOnElement(Jacket);
    }

    // Select Sort By filter “Product Name” alphabetical order
    public void selectSortByProductName(String name) {
        selectByValueFromDropDown(sortBy, name);
    }

    public void selectSortPrice() {
        selectByValueFromDropDown(Price, "price");
    }

    public ArrayList<String> getProductList1() {
        List<WebElement> beforeFilterProductList = nameList1;
        ArrayList<String> beforeFilterProductList1 = new ArrayList<>();
        for (WebElement list : beforeFilterProductList) {
            beforeFilterProductList1.add(String.valueOf(list.getText()));
        }
        Collections.sort(beforeFilterProductList1);
        return beforeFilterProductList1;
    }

    public void selectProductNameFilter(String filterName) {
        selectByVisibleTextFromDropDown(productFilter, filterName);
    }

    public ArrayList<String> getProductList2() {
        List<WebElement> afterFilterProductList = nameList2;
        ArrayList<String> afterFilterProductList1 = new ArrayList<>();
        for (WebElement list1 : afterFilterProductList) {
            afterFilterProductList1.add(String.valueOf(list1.getText()));
        }

        return afterFilterProductList1;
    }


    public ArrayList<Double> getPriceList1() {
        List<WebElement> beforeFilterProductList = priceList1;
        ArrayList<Double> beforeFilterProductList1 = new ArrayList<>();
        for (WebElement value : beforeFilterProductList) {
            beforeFilterProductList1.add(Double.valueOf(value.getText().replace("$", "")));
            beforeFilterProductList1.add(Double.valueOf(value.getText()));
        }
        Collections.sort(beforeFilterProductList1);
        return beforeFilterProductList1;
    }

    public ArrayList<Double> getPriceList2() {
        List<WebElement> afterFilterProductList = priceList2;
        ArrayList<Double> afterFilterProductList1 = new ArrayList<>();
        for (WebElement value : afterFilterProductList) {
            afterFilterProductList1.add(Double.valueOf(value.getText().replace("$", "")));
            afterFilterProductList1.add(Double.valueOf(value.getText()));
        }
        return afterFilterProductList1;
    }

}

