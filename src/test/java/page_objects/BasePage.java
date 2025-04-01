package page_objects;

import org.openqa.selenium.WebDriver;

public class BasePage extends BasePageObject {

    private final static String BASE_PAGE_URL = "https://randomuser.me/";

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public static String getBasePageUrl() {
        return BASE_PAGE_URL;
    }
}
