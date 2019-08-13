package ru.csssr.blog;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Coriolan8 on 12.08.2019.
 */
public class CheckWrongLinkofSoft extends TestHelper {

  @BeforeMethod
  public void setup() {
    createBrowser(BrowserType.CHROME);
  }



  @Test
  public void testCheckLink()  {
    goToSecondTab();
    goToLink();
    CheckSite();


  }


}
