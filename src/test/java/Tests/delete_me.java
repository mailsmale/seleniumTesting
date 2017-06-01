package Tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import pages.RelativityLoginPage;
import utils.rWebDriver;

import java.util.HashMap;

/**
 * Created by im going to use this on 3/8/2016.
 */
public class delete_me {
    public static void main(String[] args) {
        new delete_me().foo("123", "456");
    }

    void foo (String... strings) {
        System.out.println(strings.getClass());
    }
    /*public static void main(String[] args) {
        String a = "_documentProfileEditor__kCuraScrollingDiv_dynamicViewRenderer_ctl54_nameCell";
        int b = a.length();
        String numberOnLayout = a.substring(b-12, b - 9);
        System.out.println(numberOnLayout);
    }*/
   /* RelativityLoginPage loginPage = new RelativityLoginPage();
    @Before
    public void TestSetup() throws InterruptedException {
        loginPage.openLoginPage();
        HashMap<Integer, String> handles = loginPage.getAdditionalWindowWithTheNextUrl("");
        Thread.sleep(5000);
        loginPage.switchToWindowUsingHandle(handles.get(1));
        loginPage.openLoginPage();
        Thread.sleep(3000);
        loginPage.switchToWindowUsingHandle(handles.get(2));
        loginPage.openLoginPage();
        Thread.sleep(3000);
        loginPage.switchToWindowUsingHandle(handles.get(1));
        loginPage.openLoginPage();
        Thread.sleep(3000);
        loginPage.switchToWindowUsingHandle(handles.get(1));
        loginPage.openLoginPage();
        Thread.sleep(8000);
    }

    @AfterClass
    public static void SuiteTardown(){
        rWebDriver.closeWebDriver();
    }

    @Test
    public void TestCase1() {
        System.out.println("hello, im serhii");
    }*/

}
