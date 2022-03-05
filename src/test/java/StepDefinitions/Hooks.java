package StepDefinitions;

import POM.LoginPage;
import Utilities.Driver;
import Utilities.ReadFromConfigFile;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    LoginPage loginPage = new LoginPage();

    @Before(order = 1)
    public void navigateToLoginPage(){
        loginPage.navigateTo(ReadFromConfigFile.getValueFor("loginpage"));
        loginPage.clickAcceptCookiesButton();
        loginPage.maximizeWindow();
    }

    @Before(order = 2)
    public void login(){
        loginPage.inputUsername(ReadFromConfigFile.getValueFor("username"));
        loginPage.inputPassword(ReadFromConfigFile.getValueFor("password"));
        loginPage.clickLoginButton();
    }

    @After
    public void tearDown(){
        Driver.quitDriver();
    }
}
