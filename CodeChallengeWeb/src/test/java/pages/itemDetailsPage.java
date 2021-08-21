package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class itemDetailsPage {
	protected WebDriver driver;

	@FindBy(id = "search_query_top")
	private WebElement txt_searchString;

	@FindBy(name = "submit_search")
	private WebElement btn_search;

	@FindBy(name = "Submit")
	private WebElement btn_addToCart;

	@FindBy(xpath = "//span[contains(@class, 'continue btn btn-default button exclusive-medium')]")
	private WebElement btn_continueShopping;

	public itemDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterSearchString(String itemName) {
		txt_searchString.sendKeys(itemName);
	}

	public void clickSearch() {
		btn_search.click();
	}

	public void clickItem(String itemName) {
		try {
			driver.findElements(By.linkText(itemName)).get(0).click();
		} catch (NoSuchElementException e) {
			System.out.println("[Fail] No search results found for the item '" + itemName + "'.");
			System.exit(1);
		}
	}

	public void clickAddToCart() {
		btn_addToCart.click();
	}

	public void checkAddToCartStatus() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement img_tick = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//i[@class='icon-ok']")));

		try {
			if (img_tick.isDisplayed()) {
				System.out.println("[Pass] Added item to the cart successfully");
			} else {
				System.out.println("[Fail] Add to cart transaction failed");
				System.exit(1);
			}
		} catch (NoSuchElementException e) {
			System.out.println("[Fail] Add to cart transaction failed");
			System.exit(1);
		}
	}

	public void clickContinueShopping() {
		btn_continueShopping.click();
	}
}
