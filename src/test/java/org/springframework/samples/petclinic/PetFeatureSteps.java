package org.springframework.samples.petclinic;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;

public class PetFeatureSteps {
    private HtmlUnitDriver driver;
    private LoginPage loginPage;

    @Before
    public void before() {
        driver = new org.openqa.selenium.htmlunit.HtmlUnitDriver();
        driver.get(SeleniumTest.getBase());
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Given("^user has valid account$")
    public void user_has_valid_account() throws Throwable {
    }

    @When("^use login with correct username and password$")
    public void use_login_with_correct_username_and_password() throws Throwable {
        loginPage.login("username", "password");
    }

    @Then("^user can access the home page$")
    public void user_can_access_the_home_page() throws Throwable {
    }

}
