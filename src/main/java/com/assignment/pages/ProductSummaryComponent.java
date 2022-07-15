package com.assignment.pages;

import com.assignment.utils.SeleniumActions;
import org.openqa.selenium.By;

public final class ProductSummaryComponent {


    private final By drpdwnQuantity = By.id("quantity");
    private final By btnAddToCart = By.id("add-to-cart-button");
    private final By priceOfItem = By.id("price_inside_buybox");

    public ProductSummaryComponent selectQty(int qty){
        SeleniumActions.selectValueInDropDown(drpdwnQuantity, e->e.selectByValue(String.valueOf(qty)));
        return this;
    }
    public void clickAddToCart(){
        SeleniumActions.waitAndClick(btnAddToCart,"Add to cart");
    }

    public Double getPriceOfOneItem(){
        return Double.valueOf(removeRupeeSymbol(SeleniumActions.getText(priceOfItem)));
    }

    private String removeRupeeSymbol(String price){
        return price.substring(1);
    }

}
