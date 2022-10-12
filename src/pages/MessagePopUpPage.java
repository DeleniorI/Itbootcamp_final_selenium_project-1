package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;

	}

	public void waitUserPopUpToBeVisiable() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='status']")));
	}

	public void waitForPopUpToBeDisplayed() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Saved successfully')]")));
	}

	public WebElement getElementWithNewEditPopUpMessage() {
		return this.driver.findElement(By.xpath("//div[contains(text(), 'Saved successfully')]"));
	}

	public WebElement getElementWithTextMessage() {
		return this.driver.findElement(By.xpath("//div[@role='status']//li"));
	}

	public WebElement getCloseBtn() {
		return this.driver.findElement(By.xpath("//div[contains(@class, 'v-snack__content')]/button"));
	}

	public void waitForVerifyAccountPopUpToBeVisible() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'dlgVerifyAccount')]")));
	}

	public WebElement getElementWithVerifyAccountMessage() {
		return this.driver.findElement(By.xpath("//div[contains(@class, 'dlgVerifyAccount')]"));
	}

	public WebElement getPopUpCloseBtn() {
		return this.driver.findElement(By.xpath("//button[contains(@class, 'btnClose')]"));
	}
	public void waitForWarningPopUp() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-card__text')]")));
	}

	public WebElement getWarningPopUpElement() {
		return this.driver.findElement(By.xpath("//div[contains(@class, 'v-card__text')]"));
	}

	public WebElement getSuccessfullyDeletedPopUp() {
		return this.driver.findElement(By.xpath("//div[contains(text(), 'Deleted successfully')]"));
	}
}


