package com.pageFactory;

public class Constants {
    String Xpath_Todays_Deals = "//a[contains(text(),\"Today's Deals\")]";
    String Xpath_Hamburger_Menu = "//a[@id='nav-hamburger-menu']";
    String Xpath_TvAppliancesDept_Link = "//a[@class='hmenu-item']/div[contains(text(),'TV, Appliances, Electronics')]";
    String Xpath_Televisions = "//a[contains(text(),'Televisions')]";
    String Xpath_Samsung_Branch_Checkbox = "//span[contains(text(),'Samsung')]/preceding-sibling::div";
    String Xpath_Second_Result_Item = "//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']//a";
    String Xpath_Sort_Items_Price = "//span[@aria-label='Sort by:']";
    String Xpath_Sort_Price_LowToHigh = "//a[contains(text(),'Price: Low to High')]";
    String Xpath_About_Item_Header = "//h1[contains(text(),' About this item ')]";
    String Xpath_About_Item_Text = "//h1[contains(text(),' About this item ')]/following-sibling::ul";
}
