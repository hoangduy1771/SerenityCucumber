package utils.junitcase;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//add RunWith to run this test case with serenity.properties
@RunWith(SerenityRunner.class)
public class TestWithJunit {

    @Managed
    WebDriver driver;

    @Test
    public void doLogin() throws InterruptedException {
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("Hello");
        Thread.sleep(5000);
    }



}
