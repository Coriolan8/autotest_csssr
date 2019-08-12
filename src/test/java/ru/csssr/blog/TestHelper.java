package ru.csssr.blog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;

/**
 * Created by Coriolan8 on 12.08.2019.
 */
public class TestHelper {
  private WebDriver wd;

  void createBrowser(BrowserType browserType) {
    switch (browserType) {
      case FIREFOX:
        wd = new FirefoxDriver();
        break;
      case CHROME:
        wd = new ChromeDriver();
        break;
      case IE:
      default:
        wd = new InternetExplorerDriver();
        break;
    }
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
        if (! title.equals("Monosnap")) {
             System.out.println("WRONG LINK!!");}

  }


  @AfterMethod
  public void tearDown() {
    wd.quit();
  }
}
