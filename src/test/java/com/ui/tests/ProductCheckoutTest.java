package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;

import com.constants.Size;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase  {
	private static final String SEARCH_TERM="Printed Summer dress";
	private SearchResultPage searchResultPage;
	
	@BeforeMethod(description="User logs into the application and searches for a product")
	public void setup() {
		searchResultPage=homePage.goToLoginPage().doLoginWith("fajaw53481@kwifa.com", "password").searcForAproduct(SEARCH_TERM);
		
	}
	
	@Test(description="verify if the logged in user is able to buy a dress", groups= {"e2e","smoke","sanity"})
	public void checkoutTest() {
		String result=searchResultPage.clickOnTheProductAt(0).changeSizeAndColor(L, 1).addProductToCart().proceedToCheckout().gotToConfirmAddressPage().goToShipmentPage().goToPaymentPage().makePaymentByWire();
		Assert.assertTrue(result.contains("complete"));
		
		
	}

}
