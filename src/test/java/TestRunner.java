import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/main/java/features",
        glue={"stepdefinitions"},
        plugin = {"pretty"},
        tags = "@test",
        monochrome = true
)
public class TestRunner {

}
