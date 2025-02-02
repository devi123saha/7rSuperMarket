package testfile;


import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import constants.Constants;
import classfile.AdminUsersPage;
import classfile.CategoryPage;
import classfile.HomePage;
import classfile.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.SubCategoryPage;

public class SubCategoryTest extends Base {
	HomePage home;
	SubCategoryPage subcategory;
	CategoryPage category;
	AdminUsersPage admin;
	FakerUtility faker = new FakerUtility();

	@Test
	public void verifyUserIsAbleToCreateNewSubCategory() throws IOException, AWTException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		String subCategoryNameField = faker.getFakeFirstName();
		subcategory = home.clickOnSubCategoryButton();
		subcategory.newClick().subcategoryDropdown().enterSubCategoryOnField(subCategoryNameField).chooseFilesClick()
				.clickOnSaveButton();
		boolean statusMessage = subcategory.isCreateSuccessMessageDisplayed();
		Assert.assertTrue(statusMessage, Constants.SUBCATEGORYCREATIONUNSUCCESSFUL);

	}

	@Test
	public void verifyUserIsAbleToSearchSubCategory() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		subcategory = home.clickOnSubCategoryButton();
		String subCategory = ExcelUtility.readStringData(5, 2, "LoginPage");
		subcategory.clickOnSearchButon().searchsubcategoryDropdown().entersubCategoryOnField(subCategory)
				.clickOnSearchButton();
		boolean statusMessage = subcategory.isactivestatusdisplayed();
		Assert.assertTrue(statusMessage, Constants.ERRORMESSAGEFORINVALIDSUBCATEGORYSEARCH);
	}
	
	public void verifyUserIsAbleToDeleteCategory() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		category = home.clickOnCategoryButton();
		category.clickOnDeleteButton();
		boolean deleteMessage = category.isDeleteSuccessfulMessageDisplayed();
		Assert.assertTrue(deleteMessage, Constants.SUBCATEGORYDELETIONUNSUCCESSFUL);
	}
	
	
	
}