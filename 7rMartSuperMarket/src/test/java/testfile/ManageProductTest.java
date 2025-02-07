package testfile;

import org.testng.Assert;
import org.testng.annotations.Test;

import classfile.HomePage;
import classfile.LoginPage;
import classfile.ManageProduct;

public class ManageProductTest extends Base {
	HomePage home;
	ManageProduct manage;

	@Test
	public void verifyValidProductSearch() {
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnField("admin").enterPasswordOnField("admin");
		home = login.clickOnSignInButton();
		manage = home.manageProductClick();
		manage.searchClick().enterTitleOnTitleField("Boost Health & Energy Drink Pouch - 1kg ")
				.enterProductCodeOnField("P555").selectCategoryDropdown().selectSubcategoryDropDown()
				.clickOnSearchButton();
		boolean imageIsDisplayed = manage.isImageDisplayed();
		Assert.assertTrue(imageIsDisplayed, "search not found");
	}

}