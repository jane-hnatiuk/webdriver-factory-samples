package ru.stqa.selenium.factory.samples;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.selenium.factory.WebDriverPool;

public class VariousBrowsersWebDriverSample {

  @AfterClass
  public static void stopAllBrowsers() {
    WebDriverPool.DEFAULT.dismissAll();
  }

  @Test
  public void test1() {
    doSomething(WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.firefox()));
  }

  @Test
  public void test2() {
    doSomething(WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.internetExplorer()));
  }

  @Test
  public void test3() {
    doSomething(WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.chrome()));
  }

  private void doSomething(WebDriver driver) {
    driver.get("http://seleniumhq.org/");
    driver.findElement(By.name("q")).sendKeys("selenium");
    driver.findElement(By.id("submit")).click();
    new WebDriverWait(driver, 30).until(
        ExpectedConditions.titleContains("Google Custom Search"));
  }

}
