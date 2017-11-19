package com.eliasnogueira.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PeoplePage {

    private WebDriver driver;

    @FindBy(css = ".ui-h2.hero-title")
    private WebElement title;

    @FindBy(css = ".ui-body.hero-description")
    private WebElement description;

    public PeoplePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("@"));

    }

    public String getTitleName() {
        return title.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public String getURLAddress() {
        return driver.getCurrentUrl();
    }
}
