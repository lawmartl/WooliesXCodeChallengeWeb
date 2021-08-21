package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	protected WebDriver driver;

	@FindBy(className = "login")
	private WebElement lnk_signin;

	@FindBy(id = "email")
	private WebElement txt_username;

	@FindBy(id = "passwd")
	private WebElement txt_password;

	@FindBy(id = "SubmitLogin")
	private WebElement btn_login;

	@FindBy(className = "logout")
	private WebElement lnk_signout;

	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void checkHomePage() {
		try {
			if (lnk_signin.isDisplayed()) {
				System.out.println("[Pass] Home page is displayed");
			} else {
				System.out.println("[Fail] Home page is not displayed");
				System.exit(1);
			}
		} catch (NoSuchElementException e) {
			System.out.println("[Fail] Home page is not displayed");
			System.exit(1);
		}
	}

	public void clickSignin() {
		lnk_signin.click();
	}

	public void checkLoginPage() {
		try {
			if (txt_username.isDisplayed()) {
				System.out.println("[Pass] Login page is displayed");
			} else {
				System.out.println("[Fail] Login page is not displayed");
				System.exit(1);
			}
		} catch (NoSuchElementException e) {
			System.out.println("[Fail] Login page is not displayed");
			System.exit(1);
		}
	}

	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}

	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void clickLogin() {
		btn_login.click();
	}

	public void checkLoginSuccessful() {
		try {
			if (lnk_signout.isDisplayed()) {
				System.out.println("[Pass] Login is successful");
			} else {
				System.out.println("[Fail] Login is unsuccessful");
				System.exit(1);
			}
		} catch (NoSuchElementException e) {
			System.out.println("[Fail] Login is unsuccessful");
			System.exit(1);
		}
	}
}
