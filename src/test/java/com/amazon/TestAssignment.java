package com.amazon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.amazon.base.BaseTestModule;
import com.amazon.base.WrappedWebElement;
import com.amazon.components.BrandSection;
import com.amazon.components.BrandSection.BrandNames;
import com.amazon.components.CategoryRefinements.A_SectionHeaderItems;
import com.amazon.components.HamburgerMenuContent;
import com.amazon.components.HamburgerMenuContent.HamburgerMenuSBDItems;
import com.amazon.components.HamburgerMenuContent.HamburgerMenuSubItems;
import com.amazon.components.HamburgerMenuContent.HamburgerMenuTitles;
import com.amazon.pages.CategoryPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.ResultsPage;
import com.amazon.pages.ResultsPage.SortBy;

public class TestAssignment extends BaseTestModule {

	@Tag("smokeTest")
	@DisplayName("This test is as per requirement of the assignment")
	@Test
	void testProductSortAndProductDetail() throws InterruptedException {
		//open the url
		getDriver().get(getUrl());
		
		//create home page object
		HomePage page = (HomePage) getPage(getDriver(), HomePage.class);
		HamburgerMenuContent menuContent = page.getTopNavBar().clickHamburegerMenu();
		//Clicking SeeAll in menu to make sure all elements are loaded
		menuContent.clickSeeAll();
		//Scrolling the enum shop by department in view
		menuContent.scrollToHaburgerTitle(HamburgerMenuTitles.SHOP_BY_DEPARTMENT);
		//Scrolling the sub menu TV_APPLIANCES_ELECTRONICS in to view
		menuContent.scrollToHaburgerItem(HamburgerMenuSBDItems.TV_APPLIANCES_ELECTRONICS);
		menuContent.clickHamburgerMenuItem(HamburgerMenuSBDItems.TV_APPLIANCES_ELECTRONICS);
		
		//returned CategoryPage object
		CategoryPage categoryPage = menuContent.clickHamburgerMenuSubItem(HamburgerMenuSubItems.TELEVISIONS);
		// brandSectionParent is actually the parent of the Brand Label. This used to further 
		// find actual brand filter under it
		WrappedWebElement brandSectionParent = categoryPage.getRefinementSection()
				.getASectionsComponent(A_SectionHeaderItems.BRANDS);
		brandSectionParent.scrollIntoView();
		// Created seperate filter component for brand filter
		//Idea here is that later we can have common class which later be extended by all filter
		// to perform some common or specific actions
		BrandSection brandSectionComp = new BrandSection(getDriver(), brandSectionParent);
		brandSectionComp.clickBrandNameFilter(BrandNames.SAMSUNG);
		
		//create Results page object
		ResultsPage resultPage = (ResultsPage) getPage(getDriver(), ResultsPage.class);
		resultPage.sortBy(SortBy.PRICE_HIGH_TO_LOW);
		resultPage.openAndSwitchToResultItemIndex(1);
		
		//create Product page object
		ProductPage productPage = (ProductPage) getPage(getDriver(), ProductPage.class);
		if (productPage.isAboutThisItemPresent()) {
			assertEquals(productPage.getAboutThisItemLabel(), "About this item");
			System.out.println(productPage.getAboutThisItemSectionText());
		} else {
			System.out.println("The current selected product does not have 'About this item' section. product url : "
					+ productPage.getCurrentUrl());
		}

	}

}
