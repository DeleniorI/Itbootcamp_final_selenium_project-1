package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{
	
	@Test(priority = 10)
	public void visitsTheAdminCitiesPageAndListCities() throws InterruptedException {
		String emailAdmin = "admin@admin.com";
		String passwordAdmin = "12345";
		
		navPage.getSignUpBtn().click();
		loginPage.getEmailInput().sendKeys(emailAdmin);
		loginPage.getPasswordInput().sendKeys(passwordAdmin);
		loginPage.getLoginButton().click();
		navPage.getAdminButton().click();
		new Actions(driver).moveToElement(navPage.getCitiesLink()).click().perform();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"), "URL should countain '/admin/cities'");
	}
	
	@Test(priority = 20)
	public void checksInputTypesForCrediteEditNewCity() {
		navPage.getAdminButton().click();
		new Actions(driver).moveToElement(navPage.getCitiesLink()).click().perform();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForNewEditDialogToBeVisible();

		Assert.assertEquals(citiesPage.getNewItemButton().getAttribute("type"), ("text"), "Dialog input should be type text");	
	}
	@Test(priority = 30)
	public void createNewCity() throws InterruptedException {
		String city = "Monika Nikolic's city";
		navPage.getAdminButton().click();
		new Actions(driver).moveToElement(navPage.getCitiesLink()).click().perform();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForNewEditDialogToBeVisible();
		citiesPage.getNewItemButton().sendKeys(city);
		citiesPage.getEditDialogSaveBtn().click();

		messagePopUpPage.waitForPopUpToBeDisplayed();
		Assert.assertTrue(messagePopUpPage.getElementWithNewEditPopUpMessage().getText().contains("Saved successfully"), "Pop up message should be "
				+ "'Saved successfully'");
	}
	
	@Test(priority = 40)
	public void editCity() throws InterruptedException {
		String oldCityName = "Monika Nikolic's city";
		String newCityName = "Monika Nikolic's city Edited";

		navPage.getAdminButton().click();
		new Actions(driver).moveToElement(navPage.getCitiesLink()).click().perform();
		citiesPage.getSearchInput().sendKeys(oldCityName);
		citiesPage.waitForTableRowsToBe(1);
		citiesPage.getEditBtnByRow(1).click();

		citiesPage.getNewItemButton().sendKeys(Keys.CONTROL + "a");
		citiesPage.getNewItemButton().sendKeys(Keys.DELETE);

		citiesPage.getNewItemButton().sendKeys(newCityName);
		citiesPage.getEditDialogSaveBtn().click();

		messagePopUpPage.waitForPopUpToBeDisplayed();
		Assert.assertTrue(messagePopUpPage.getElementWithNewEditPopUpMessage().getText().contains("Saved successfully"), "Pop up message should be "
				+ "'Saved successfully'");
	}
	
	@Test(priority = 50)
	public void searchCity() {
		String cityName = "Monika Nikolic's city Edited";
		navPage.getAdminButton().click();
		new Actions(driver).moveToElement(navPage.getCitiesLink()).click().perform();
		citiesPage.getSearchInput().sendKeys(cityName);
		citiesPage.waitForTableRowsToBe(1);

		Assert.assertEquals(citiesPage.getCellFromRow(1, 2).getText(), cityName);
	}

	@Test(priority = 60)
	public void deleteCity() {
		String cityName = "Monika Nikolic's city Edited";
		navPage.getAdminButton().click();
		new Actions(driver).moveToElement(navPage.getCitiesLink()).click().perform();
		citiesPage.getSearchInput().sendKeys(cityName);
		citiesPage.waitForTableRowsToBe(1);

		Assert.assertEquals(citiesPage.getCellFromRow(1, 2).getText(), cityName);

		citiesPage.getDeleteBtnByRow(1).click();
		messagePopUpPage.waitForWarningPopUp();

		citiesPage.getDialogDeleteBtn().click();
		Assert.assertTrue(messagePopUpPage.getSuccessfullyDeletedPopUp().getText().contains("Deleted successfully"), "Pop up message shoud "
				+ "countain 'Deleted successfully'");

	}


}
