package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestValidCredential extends BaseClass {
	WebElement emailField;
	WebElement passwordField;
	WebElement loginButton;

    @BeforeMethod
    public void setupElements() {
        emailField = driver.findElementByAccessibilityId("EmailTextBx");
        passwordField = driver.findElementByAccessibilityId("PasswordPwdBx");
        loginButton = driver.findElementByAccessibilityId("LoginBtn");
    }

    @Test
    public void validLogin() {
        try {
            Thread.sleep(1000);
            emailField.sendKeys("admin@3sdcl.com");
            passwordField.sendKeys("Password@123");
            loginButton.click();

            Thread.sleep(5000);
            
            String pageSource = driver.getPageSource();
			String expectedText = "Welcome to e-ADAPP";
			Assert.assertTrue(pageSource.contains(expectedText));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
