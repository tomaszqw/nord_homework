package tests;

import configuration.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.MainPage;
import utils.SaveToCsv;

import java.io.IOException;
import java.util.*;

public class UiTest {

    protected WebDriver driver;
    MainPage mainPage;

    @BeforeClass
    public void setup() {
        this.driver = WebDriverFactory.getWebDriver();
        this.mainPage = new MainPage(driver);
        driver.get(MainPage.getBasePageUrl());
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    @Test
    public void uiTest() throws IOException {
        List<String> results = mainPage.getUserDetails();
        System.out.println(results);
        Assert.assertEquals(results.size(), 6);

        SaveToCsv.saveToCsv(results);
    }

    @Test
    public void countDuplicates() {
        List<String> nameList =
                new ArrayList<>(Arrays.asList("Malgorzata", "Damian", "Anna", "Jakub", "Tomasz", "Damian", "Anna"));

        Map<String, Integer> duplicatesList = new HashMap<>();

        for (String name : nameList) {
            if (duplicatesList.containsKey(name)) {
                duplicatesList.put(name, duplicatesList.get(name) + 1);
            } else {
                duplicatesList.put(name, 1);
            }

        }

        duplicatesList.forEach((s, i) -> System.out.println("Key: " + s + " Value: " + i));
    }
}
