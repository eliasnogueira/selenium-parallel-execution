package com.eliasnogueira.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "label[title='Search Medium'] > span[class*='svgIcon--search']")
    private WebElement searchIcon;

    @FindBy(css = "input[type='search']")
    private WebElement searchInput;

    public MainPage(WebDriver driver) {
        this.driver = driver;

        driver.get("http://medium.com");

        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, 5);
    }


    public void clickSearchIcon() {
        searchIcon.click();
    }

    public void fillSearch(String query) {
        searchInput.sendKeys(query);
    }

    public void selectPeople(String name) {
        By xpathExpression = By.xpath("//span[@class='avatar-text' and text()='" + name + "']");

        wait.until(ExpectedConditions.presenceOfElementLocated(xpathExpression));
        driver.findElement(xpathExpression).click();
    }
}
