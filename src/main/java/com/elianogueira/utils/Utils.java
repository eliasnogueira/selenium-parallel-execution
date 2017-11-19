package com.elianogueira.utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Utils {

    /**
     * Return a new RemoteWebDriver instance based on the grid for a given browser
     * @param browser a browser that will run the test
     * @return a new RemoteWebDriver instance
     * @throws Exception if the browser is not mapped
     */
    public static WebDriver getDriver(String browser) throws Exception {

        // a composition of the target grid address and port
        String GRID_URL = "http://" + getValueFromConf("") + ":" + getValueFromConf("") + "/wd/hub";

        return new RemoteWebDriver(new URL(GRID_URL), returnCapability(browser));
    }

    /**
     * Return a DesiredCapability for a given browser
     * @param browser the browser name. Allowed browsers are: chrome, firefox, ie-11
     * @return a DesiredCapability
     * @throws Exception if the browser is not mapped
     */
    private static DesiredCapabilities returnCapability(String browser) throws Exception {
        DesiredCapabilities desiredCapabilities;

        switch (browser.toLowerCase()) {

            case "chrome":
                desiredCapabilities = DesiredCapabilities.chrome();
                break;

            case "firefox":
                desiredCapabilities = DesiredCapabilities.firefox();
                break;

            case "ie-11":
                desiredCapabilities = DesiredCapabilities.internetExplorer();
                desiredCapabilities.setPlatform(Platform.WINDOWS);
                break;

            default:
                throw new Exception("Browser not supported or misspelled");
        }

        return desiredCapabilities;
    }

    /**
     * Return a value from conf/config.properties given a property
     * @param property an existing property from config/config.properties
     * @return the value of a property
     */
    private static String getValueFromConf(String property) {
        Properties properties;
        String value = null;
        try {
            properties = new Properties();
            properties.load(new FileReader(new File("conf/config.properties")));

            value =  properties.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
