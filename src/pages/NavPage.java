package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {
//	Home link
//	About link
//	My profile link
//	Admin dugme
//	Cities link iz padajuceg Admin menija
//	Users link iz padajuceg Admin menija
//	Sign up dugme
//	Login dugme
//	Logout dugme
//	Dugme za izbor jezika
//	EN dugme iz padajuceg menija za izbor jezika
//	ES dugme iz padajuceg menija za izbor jezika
//	FR dugme iz padajuceg menija za izbor jezika
//	CN dugme iz padajuceg menija za izbor jezika

	private WebDriver driver;
	private WebDriverWait wait;

	public NavPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getHomeLink() {
		return this.driver.findElement(By.xpath("//a[@href='/home']"));
	}

	public WebElement getAboutLink() {
		return this.driver.findElement(By.xpath("//a[@href='/about']"));
	}

	public WebElement getMyProfileLink() {
		return this.driver.findElement(By.xpath(("//a[@href='/profile']")));
	}

	public WebElement getAdminButton() {
		return this.driver.findElement(By.xpath(("//button[contains(@class,'btnAdmin')]")));
	}

	public WebElement getCitiesLink() {
		return this.driver.findElement(By.xpath("//a[@href='/admin/cities']"));
	}

	public WebElement getUsersLink() {
		return this.driver.findElement(By.xpath("//a[@href='/admin/users']"));
	}

	public WebElement getSignUpBtn() {
		return this.driver.findElement(By.xpath("//a[@href='/signup']"));
	}

	public WebElement getLoginBtn() {
		return this.driver.findElement(By.xpath("//a[@href='/login']"));
	}

	public WebElement getLogoutBtn() {
		return this.driver.findElement(By.xpath("//button[contains(@class, 'btnLogout')]"));
	}

	public WebElement getLanguageBtn() {
		return this.driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation')]"));
	}

	public WebElement getEnglishBtn() {
		return this.driver.findElement(By.xpath("//div[text()='EN']"));
	}

	public WebElement getFranceBtn() {
		return this.driver.findElement(By.xpath("//div[text()='FR']"));
	}

	public WebElement getSpanishBtn() {
		return this.driver.findElement(By.xpath("//div[text()='ES']"));
	}

	public WebElement getChineseBtn() {
		return this.driver.findElement(By.xpath("//div[text()='CN']"));
	}
}
