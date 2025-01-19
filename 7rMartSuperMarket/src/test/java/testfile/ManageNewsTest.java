package testfile;

import org.testng.Assert;
import org.testng.annotations.Test;

import classfile.HomePage;
import classfile.LoginPage;
import classfile.ManageNews;

public class ManageNewsTest extends Base {
	ManageNews news;
	HomePage home;

	@Test
	public void verifyUserIsAbleToCreateNews() {
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnField("admin").enterPasswordOnField("admin");
		home = login.clickOnSignInButton();
		news = home.clickOnManageNews();
		news.ClickOnNewButton().enterNewsOnField("hello").clickOnSaveButton();
		boolean alertmessage = news.isAlertMessageDisplayed();
		Assert.assertTrue(alertmessage, "news creation is unsuccessful");
	}
}