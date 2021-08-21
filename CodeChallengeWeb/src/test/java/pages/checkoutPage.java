package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutPage {
	protected WebDriver driver;

	@FindBy(partialLinkText = "Cart")
	private WebElement lnk_cart;

	@FindBy(id = "summary_products_quantity")
	private WebElement txt_cartItemCount;

	@FindBy(linkText = "Proceed to checkout")
	private WebElement lnk_proceed;

	@FindBy(name = "processAddress")
	private WebElement lnk_proceedAddress;

	@FindBy(name = "cgv")
	private WebElement chk_agree;

	@FindBy(name = "processCarrier")
	private WebElement lnk_proceedCarrier;

	public checkoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickCart() {
		lnk_cart.click();
	}

	public void checkCartItemCount() {
		try {
			if (txt_cartItemCount.isDisplayed()) {
				if (txt_cartItemCount.getText().equalsIgnoreCase("2 products")) {
					System.out.println("[Pass] Number of items in the cart: " + txt_cartItemCount.getText());
				} else {
					System.out.println("[Fail] Number of items in the cart: " + txt_cartItemCount.getText()
							+ ". Expected count is 2.");
					System.exit(1);
				}
			} else {
				System.out.println("[Fail] Cart is not displayed");
				System.exit(1);
			}
		} catch (NoSuchElementException e) {
			System.out.println("[Fail] Cart is not displayed");
			System.exit(1);
		}
	}

	public void clickProceed() {
		lnk_proceed.click();
	}

	public void clickProceedAddress() {
		lnk_proceedAddress.click();
	}

	public void tickAgree() {
		chk_agree.click();
	}

	public void clickProceedCarrier() {
		lnk_proceedCarrier.click();
	}
}
