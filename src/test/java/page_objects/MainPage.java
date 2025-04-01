package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtil;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"values_list\"]")
    WebElement userDetailsContainer;

    private final String DETAILS_ATTRIBUTE_NAME = "data-value";
    private final String LIST_ELEMENTS_XPATH = "./li";

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getUserDetailsContainer() {
        return userDetailsContainer;
    }

    public List<String> getUserDetails() {
        WaitUtil.waitForPage(webDriver);
        waitForPageLoad();
        return getUserDetailsContainer()
                .findElements(By.xpath(LIST_ELEMENTS_XPATH))
                .stream()
                .map(e -> e.getDomAttribute(DETAILS_ATTRIBUTE_NAME))
                .filter(e -> checkIfStringContainsOnlyLetters(e))
                .collect(Collectors.toList());
    }

    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(driver -> {
            WebElement element = getUserDetailsContainer().findElement(By.xpath(LIST_ELEMENTS_XPATH));
            String attributeValue = element.getDomAttribute(DETAILS_ATTRIBUTE_NAME);
            return attributeValue == null || !attributeValue.contains("...");
        });
    }

    public boolean checkIfStringContainsOnlyLetters(String name) {

        return true;
    }

}
