package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.checkoutPage;
import pages.itemDetailsPage;
import pages.loginPage;
import pages.paymentPage;

public class Order {
	WebDriver driver = null;
	loginPage login;
	itemDetailsPage itemDetails;
	checkoutPage checkout;
	paymentPage payment;

	@Given("application is launched")
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}

	@And("^user is logged in using (.*) and (.*)$")
	public void login(String username, String password) {
		login = new loginPage(driver);
		login.checkHomePage();
		login.clickSignin();
		login.checkLoginPage();
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickLogin();
		login.checkLoginSuccessful();
	}

	@And("^user add (.*) to the cart$")
	public void searchAndAddItem(String itemName) {
		itemDetails = new itemDetailsPage(driver);
		itemDetails.enterSearchString(itemName);
		itemDetails.clickSearch();
		itemDetails.clickItem(itemName);
		itemDetails.clickAddToCart();
		itemDetails.checkAddToCartStatus();
		itemDetails.clickContinueShopping();
	}

	@When("user proceed to checkout")
	public void checkout() {
		checkout = new checkoutPage(driver);
		checkout.clickCart();
		checkout.checkCartItemCount();
		checkout.clickProceed();
		checkout.clickProceedAddress();
		checkout.tickAgree();
		checkout.clickProceedCarrier();
	}

	@And("^user selects payment method as (.*)$")
	public void payment(String paymentmethod) {
		payment = new paymentPage(driver);
		payment.getTotalPrice();
		payment.selPaymentMethod(paymentmethod);
		payment.clickConfirmOrder();
	}

	@Then("order is completed")
	public void verifyOrder() {
		payment.checkOrderSuccess();
		driver.close();
		driver.quit();
	}
}
