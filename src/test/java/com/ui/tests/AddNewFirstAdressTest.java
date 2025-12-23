package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AdressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AdressPOJO;
import com.utility.FakeAdressUtility;

public class AddNewFirstAdressTest extends TestBase{
	
	private MyAccountPage myAccountPage;
	private AdressPOJO address;

	@BeforeMethod(description="Valid user logs into the appilication")
	public void setup() {
		myAccountPage=homePage.goToLoginPage().doLoginWith("fajaw53481@kwifa.com", "password");
		address=FakeAdressUtility.getFakeAddress();
	
	}
	@Test
	public void addNewAddress() {
		String newAddress=myAccountPage.goToAdressPage().saveAddress(address);
		Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
	}

}
  