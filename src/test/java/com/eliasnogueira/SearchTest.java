package com.eliasnogueira;

import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.MatcherAssert.*;

import com.elianogueira.utils.Utils;
import com.eliasnogueira.pageobjects.MainPage;
import com.eliasnogueira.pageobjects.PeoplePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SearchTest {

    @Test
    @Parameters("browser")
    public void searchValidPerson(@Optional("chrome") String browser) throws Exception {
        String people = "Elias Nogueira";

        WebDriver driver = Utils.getDriver(browser);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickSearchIcon();
        mainPage.fillSearch(people);
        mainPage.selectPeople(people);

        PeoplePage peoplePage = new PeoplePage(driver);
        assertThat(peoplePage.getTitleName(), equalTo("Elias Nogueira"));
        assertThat(peoplePage.getDescription(), equalTo("Sênior QA Engineer, Agile Coach and Trainer"));
        assertThat(peoplePage.getURLAddress(), containsString("@eliasnogueira"));

        driver.quit();
    }
}
