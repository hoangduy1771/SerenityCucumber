package stepdefinitions.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.example.LoginPage;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    @Before
    public void initDriver() {
        String browserType = System.getProperty("browserType");
        if (browserType == null) {
            browserType = "chrome";
        }

        switch (browserType.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
        }
    }

    @Given("User navigate to {string}")
    public void userIsOnLoginPage(String url) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get(url);
    }

    @When("User enters {} and {}")
    public void userEntersUserNameAndPassword(String userName, String passWord) {
        loginPage = new LoginPage(driver);
        loginPage.enterUserName(userName);
        loginPage.enterPassword(passWord);

    }
    @When("User clicks on {string} button")
    public void clicksOnLoginButton(String buttonName) {
        loginPage = new LoginPage(driver);
        loginPage.clickOnButton(buttonName);

    }
    @Then("User can navigate to the homepage")
    public void userCanNavigateToTheHomepage() {
        loginPage = new LoginPage(driver);
        loginPage.verifyLogOutButtonDisplayed();

    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}