package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
//	Polje za unos email-a
//	Polje za unos lozinke
//	Dugme za login.

	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getEmailInput() {
		return this.driver.findElement(By.id("name"));
	}

	public WebElement getPasswordInput() {
		return this.driver.findElement(By.id("password"));
	}

	public WebElement getLoginButton() {
		return this.driver.findElement(By.xpath("//button[@type='submit']"));

	}

}
