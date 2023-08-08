package pages.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    protected WebDriver driver;
    private By txt_username = By.id("name");
    private By txt_password = By.id("password");
    private By btn_login = By.id("login");
    private By btn_logout = By.id("logout");

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public void enterUserName(String userName) {
        driver.findElement(txt_username).sendKeys(userName);
    }

    public void enterPassword(String passWord) {
        driver.findElement(txt_password).sendKeys(passWord);
    }

    public void clickOnButton(String buttonName) {
        driver.findElement(btn_login).click();
    }

    public void loginValidUser(String userName, String passWord) {
        driver.findElement(txt_username).sendKeys(userName);
        driver.findElement(txt_password).sendKeys(passWord);
        driver.findElement(btn_login).click();

    }

    public void verifyLogOutButtonDisplayed() {
        driver.findElement(btn_logout).isDisplayed();
    }

}