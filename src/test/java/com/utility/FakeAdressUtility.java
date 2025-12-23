package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AdressPOJO;

public class FakeAdressUtility {
	
	public static void main(String[] args) {
		
	}
	
	public static AdressPOJO getFakeAddress() {
		
		Faker faker=new Faker(Locale.US);
		
		AdressPOJO addressPOJO=new AdressPOJO(faker.company().name(),faker.address().buildingNumber(), faker.address().streetAddress(), faker.address().city(),faker.numerify("#####"),faker.phoneNumber().cellPhone(),faker.phoneNumber().cellPhone(),"other","office address",faker.address().state());
		return addressPOJO;
	}
	

}
