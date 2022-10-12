package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public SignUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getNameInput() {
		return this.driver.findElement(By.id("name"));
	}

	public WebElement getPasswordInput() {
		return this.driver.findElement(By.id("password"));
	}

	public WebElement getEmailInput() {
		return this.driver.findElement(By.id("email"));
	}

	public WebElement getConfirmPasswordInput() {
		return this.driver.findElement(By.id("confirmPassword"));
	}

	public WebElement getSignMeUpButton() {
		return this.driver.findElement(By.xpath("//button[@type='submit']"));
	}

}
