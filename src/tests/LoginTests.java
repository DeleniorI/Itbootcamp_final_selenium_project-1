package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

	@Test(priority = 10)
	public void visitsTheLoginPage() throws InterruptedException {
		navPage.getLanguageBtn().click();
		new Actions(driver).moveToElement(navPage.getEnglishBtn()).click().perform();

		navPage.getLoginBtn().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Login route should be in URL");
	}

	@Test(priority = 20)
	public void checksInputTypes() throws InterruptedException {
		navPage.getLoginBtn().click();
		Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"), "email",
				"Email input type should be email");
		Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "password",
				"Password input type should be password");
	}

	@Test(priority = 30)
	public void displaysErrorsWhenUserDoesNotExist() throws InterruptedException {
		String email = "non-existing-user@gmal.com";
		String password = "password123";

		navPage.getLoginBtn().click();
		loginPage.getEmailInput().sendKeys(email);
		loginPage.getEmailInput().sendKeys(password);
		loginPage.getLoginButton().click();
		messagePopUpPage.waitUserPopUpToBeVisiable();

		Assert.assertTrue(messagePopUpPage.getElementWithTextMessage().getText().contains("User does not exist"),
				"Pop up message should" + "contain 'User does not exists'");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Login route should be in URL");

	}

	@Test(priority = 40)
	public void displeyErrorsWhenPasswordIsWrong() throws InterruptedException {
		String email = "admin@admin.com";
		String password = "password123";

		navPage.getLoginBtn().click();
		loginPage.getEmailInput().sendKeys(email);
		loginPage.getPasswordInput().sendKeys(password);
		loginPage.getLoginButton().click();
		messagePopUpPage.waitUserPopUpToBeVisiable();

		Assert.assertTrue(messagePopUpPage.getElementWithTextMessage().getText().contains("Wrong password"),
				"Pop up message should " + "countain 'Wrong password'");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Login route should be in URL");
	}

	@Test(priority = 50)
	public void login() throws InterruptedException {
		String email = "admin@admin.com";
		String password = "12345";

		navPage.getLoginBtn().click();
		loginPage.getEmailInput().sendKeys(email);
		loginPage.getPasswordInput().sendKeys(password);
		loginPage.getLoginButton().click();

		Thread.sleep(1500);
		Assert.assertTrue(driver.getCurrentUrl().contains("/home"), "Page should contain '/home' in URL");
	}

	@Test(priority = 60)
	public void logout() throws InterruptedException {
		Assert.assertTrue(navPage.getLogoutBtn().isDisplayed(), "Logout button should be displayed");
		navPage.getLogoutBtn().click();
		Thread.sleep(1500);
	}

}
