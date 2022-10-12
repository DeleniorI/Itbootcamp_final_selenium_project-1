package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public CitiesPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;

	}

	public WebElement getNewItemButton() {
		return this.driver.findElement(By.xpath("//button[contains(@class, 'btnNewItem')]"));
	}

	public WebElement getSearchInput() {
		return this.driver.findElement(By.id("search"));
	}

	public void waitForNewEditDialogToBeVisible() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-dialog dlgNewEditItem')]")));
	}

	public void waitDeleteDialogToBeVisible() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'delete this item')]")));
	}

	public WebElement getEditDialogSaveBtn() {
		return this.driver.findElement(By.xpath("//button[contains(@class, 'btnSave')]"));
	}

	public WebElement getDialogDeleteBtn() {
		return this.driver
				.findElement(By.xpath("//div[@class='v-dialog v-dialog--active']//button[contains(@class, 'red')]"));
	}

	public void waitForTableRowsToBe(int row) {
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table/tbody//tr"), row));
	}

	public WebElement getCellFromRow(int row, int column) {
		return this.driver.findElement(By.xpath("//table/tbody/tr[" + row + "]/td[" + column + "]"));
	}

	public WebElement getEditBtnByRow(int row) {
		return this.driver.findElement(By.xpath("//table/tbody//tr[" + (row) + "]//button[@id='edit']"));
	}

	public WebElement getDeleteBtnByRow(int row) {
		return this.driver.findElement(By.xpath("//table/tbody//tr[" + row + "]//button[@id='delete']"));
	}

}
