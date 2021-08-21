package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paymentPage {
	protected WebDriver driver;

	@FindBy(id = "total_price")
	private WebElement txt_totalPrice;

	@FindBy(xpath = "//span[contains(text(), 'I confirm my order')]")
	private WebElement btn_confirmOrder;

	@FindBy(className = "page-heading")
	private WebElement txt_pageHeading;

	@FindBy(className = "box")
	private WebElement txt_orderDetails;

	@FindBy(xpath = ".//div[@class='box']/p")
	private WebElement txt_orderStatus;

	public paymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getTotalPrice() {
		try {
			if (txt_totalPrice.isDisplayed()) {
				System.out.println("Total price: " + txt_totalPrice.getText());
			} else {
				System.out.println("[Fail] Payment page is not displayed");
				System.exit(1);
			}
		} catch (NoSuchElementException e) {
			System.out.println("[Fail] Payment page is not displayed");
			System.exit(1);
		}
	}

	public void selPaymentMethod(String paymentmethod) {
		driver.findElement(By.className(paymentmethod)).click();
	}

	public void clickConfirmOrder() {
		btn_confirmOrder.click();
	}

	public void checkOrderSuccess() {
		try {
			if (txt_pageHeading.isDisplayed()) {
				if (txt_pageHeading.getText().equalsIgnoreCase("order confirmation")) {
					System.out.println("[Pass] Order confirmation page is displayed");

					String orderStatus = txt_orderStatus.getText();
					String orderDetails = txt_orderDetails.getText();

					if (orderStatus.equalsIgnoreCase("Your order on My Store is complete.")) {
						System.out.println("[Pass] " + orderDetails.substring(orderDetails.indexOf("order reference"),
								orderDetails.indexOf("in the subject")));
					} else {
						System.out.println("[Fail] " + txt_orderStatus.getText());
					}

//					System.out.println("Order details:");
//					System.out.println(txt_orderDetails.getText());
				}
			} else {
				System.out.println("[Fail] Order confirmation page is not displayed");
				System.exit(1);
			}
		} catch (NoSuchElementException e) {
			System.out.println("[Fail] Order confirmation page is not displayed");
			System.exit(1);
		}
	}
}
