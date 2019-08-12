package ru.csssr.blog;
import org.testng.annotations.Test;

/**
 * Created by Coriolan8 on 12.08.2019.
 */
public class CheckWongLinkofSoft extends TestHelper {


  @Test
  public void testCheckLink()  {
    goToSecondTab();
    goToLink();
    CheckSite();


  }


}
