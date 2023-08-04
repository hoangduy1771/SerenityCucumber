package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;

import java.time.Duration;
import java.util.Properties;

public class LoginSteps {
    static final Logger logger = LogManager.getLogger(LoginSteps.class);
    WebDriver driver;
    LoginPage loginPage;
    @Before
    public void initDriver() {
        String browserType = System.getProperty("browserType");

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

        logger.info("Step - User enters userName and passWord - success");
    }
    @When("User clicks on {string} button")
    public void clicksOnLoginButton(String buttonName) {
        loginPage = new LoginPage(driver);
        loginPage.clickOnButton(buttonName);

        logger.info("Step - User clicks on login button");
    }
    @Then("User can navigate to the homepage")
    public void userCanNavigateToTheHomepage() {
        loginPage = new LoginPage(driver);
        loginPage.verifyLogOutButtonDisplayed();

        logger.info("Step - User can navigate to the homepage");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}