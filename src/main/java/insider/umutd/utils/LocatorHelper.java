package insider.umutd.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class LocatorHelper {
    ConfigReader configReader;

    public LocatorHelper(){
        configReader=new ConfigReader();
    }

    public WebElement findElement(String locatorKey, WebDriver driver){
        WebElement element = null;
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            File folder =new File(configReader.getFilePath("locatorPath"));
            File[] listOfFiles= folder.listFiles();

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile() && file.getName().toLowerCase().endsWith(".json")) {
                        String jsonContent = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())), StandardCharsets.UTF_8);
                        JSONArray jsonArray = new JSONArray(jsonContent);

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject locatorInfo = jsonArray.getJSONObject(i);

                            String key = locatorInfo.getString("key");
                            String type = locatorInfo.getString("type");
                            String value = locatorInfo.getString("value");

                            if (key.equals(locatorKey)) {
                                switch (type) {
                                    case "id":
                                        element = webDriverWait
                                                .until(ExpectedConditions.presenceOfElementLocated(By.id(value)));
                                        ((JavascriptExecutor) driver).executeScript(
                                                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                                                element);
                                        break;
                                    case "css":
                                        element = webDriverWait
                                                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(value)));
                                        ((JavascriptExecutor) driver).executeScript(
                                                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                                                element);
                                        break;
                                    case "xpath":
                                        element = webDriverWait
                                                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
                                        ((JavascriptExecutor) driver).executeScript(
                                                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                                                element);
                                        break;
                                    case "class":
                                        element = webDriverWait
                                                .until(ExpectedConditions.presenceOfElementLocated(By.className(value)));
                                        ((JavascriptExecutor) driver).executeScript(
                                                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                                                element);
                                        break;
                                    default:
                                        Assert.fail("Locator type Not found");
                                }
                            }
                            if (element != null) {
                                break;
                            }
                        }
                    }
                    if (element != null) {
                        break;
                    }
                }
            }

        } catch (JSONException | NoSuchElementException | IOException e) {
            Assert.fail("A Error Found");
        }
        if (element == null) {
            Assert.fail(locatorKey + " element not found!");
        }

        return element;

    }

    public By findElementInfoBy(String locatorKey) {
        By by = null;
        boolean elementFound = false;

        try {
            File folder = new File(configReader.getFilePath("locatorPath"));
            File[] listOfFiles = folder.listFiles();

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile() && file.getName().toLowerCase().endsWith(".json")) {
                        String jsonContent = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())), StandardCharsets.UTF_8);
                        JSONArray jsonArray = new JSONArray(jsonContent);

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject locatorInfo = jsonArray.getJSONObject(i);

                            String key = locatorInfo.getString("key");
                            String type = locatorInfo.getString("type");
                            String value = locatorInfo.getString("value");

                            if (key.equals(locatorKey)) {
                                switch (type) {
                                    case "id":
                                        by = By.id(value);
                                        break;
                                    case "css":
                                        by = By.cssSelector(value);
                                        break;
                                    case "xpath":
                                        by = By.xpath(value);
                                        break;
                                    case "class":
                                        by = By.className(value);
                                        break;
                                    default:
                                        Assert.fail("Locator type Not found");
                                }
                                elementFound = true;
                                break;
                            }
                        }
                    }
                    if (elementFound) {
                        break;
                    }
                }
            }
            if (!elementFound) {
                Assert.fail("element not found!");
            }
        } catch (JSONException | NoSuchElementException | IOException e) {
            Assert.fail("A Error Found: " + e.getMessage());
        }

        return by;
    }

}
