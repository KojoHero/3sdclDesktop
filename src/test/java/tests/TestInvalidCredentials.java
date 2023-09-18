package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestInvalidCredentials extends BaseClass {
	WebElement emailField;
	WebElement passwordField;
	WebElement loginButton;

	@BeforeMethod
	public void setupElements() {
		emailField = driver.findElementByAccessibilityId("EmailTextBx");
		passwordField = driver.findElementByAccessibilityId("PasswordPwdBx");
		loginButton = driver.findElementByAccessibilityId("LoginBtn");
		emailField.clear();
		passwordField.clear();

		try {
			WebElement closeButton = driver.findElementByAccessibilityId("CloseButton");
			closeButton.click();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("CloseButton not found. Skipping...");
		}
	}

	@Test
	public void invalidEmailValidPassword() {
		try {
			Thread.sleep(1000);
			emailField.sendKeys("fakeadmin@3sdcl.com");
			passwordField.sendKeys("Password@123");
			loginButton.click();
			Thread.sleep(5000);
			String pageSource = driver.getPageSource();
			String expectedText = "Invalid Credentials. Try Again Later.";
			Assert.assertTrue(pageSource.contains(expectedText));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void validEmailInvalidPassword() {
		try {
			Thread.sleep(1000);
			emailField.sendKeys("admin@3sdcl.com");
			passwordField.sendKeys("Password@1234");
			loginButton.click();
			Thread.sleep(5000);
			String pageSource = driver.getPageSource();
			String expectedText = "Invalid Credentials. Try Again Later.";
			Assert.assertTrue(pageSource.contains(expectedText));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void invalidEmailInvalidPassword() {
		try {
			Thread.sleep(1000);
			emailField.sendKeys("fakeadmin@3sdcl.com");
			passwordField.sendKeys("Password@1234");
			loginButton.click();
			Thread.sleep(5000);
			String pageSource = driver.getPageSource();
			String expectedText = "Invalid Credentials. Try Again Later.";
			Assert.assertTrue(pageSource.contains(expectedText));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void noEmailAndPassword() {
		try {
			Thread.sleep(1000);
			loginButton.click();
			Thread.sleep(1000);
			String pageSource = driver.getPageSource();
			String expectedText = "Email is required.";
			Assert.assertTrue(pageSource.contains(expectedText));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void passwordAndNoEmail() {
		try {
			Thread.sleep(1000);
			passwordField.sendKeys("Password@123");
			loginButton.click();
			Thread.sleep(1000);
			String pageSource = driver.getPageSource();
			String expectedText = "Email is required.";
			Assert.assertTrue(pageSource.contains(expectedText));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void emailAndNoPassword() {
		try {
			Thread.sleep(1000);
			emailField.sendKeys("admin@3sdcl.com");
			loginButton.click();
			Thread.sleep(1000);
			String pageSource = driver.getPageSource();
			String expectedText = "Password is required.";
			Assert.assertTrue(pageSource.contains(expectedText));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
