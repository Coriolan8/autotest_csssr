package ru.csssr.blog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.util.concurrent.TimeUnit;

/**
 * Created by Coriolan8 on 12.08.2019.
 */
public class TestHelper {
  WebDriver wd;


  @BeforeMethod
  public void setUp() throws Exception {
    String Browser = BrowserType.FIREFOX;
    if (Browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();    }
    else if (Browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();    }
    else if (Browser.equals(BrowserType.IE)){
      wd = new InternetExplorerDriver();    }
    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    goToSite("http://blog.csssr.ru/qa-engineer/");
  }

  public void goToSite(String url) {
    wd.get(url);
  }

  protected void goToLink() {
    click("Софт для быстрого создания скриншотов");
  }

  protected void goToSecondTab() {
    click("НАХОДИТЬ НЕСОВЕРШЕНСТВА");
  }
  private void click(String linkText) {
    wd.findElement(By.linkText(linkText)).click();
  }
  public void CheckSite(){
    String title = wd.getTitle();
        if (title.equals("Monosnap")) {
          System.out.println("Test Passed");
        }  else{
          System.out.println();
    System.out.println("WRONG LINK - TEST FAILED!");}

  }


  @AfterMethod
  public void tearDown() {
    wd.quit();
  }
//  public static boolean isAlertPresent(FirefoxDriver wd) {
//    try {
//      wd.switchTo().alert();
//      return true;
//    } catch (NoAlertPresentException e) {
//      return false;
//    }
//  }
}
