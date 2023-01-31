package org.example;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class TestOrder {
    private static final String URL = "https://qa-scooter.praktikum-services.ru/"; // URL адресс сайта
    private static final String BUTTON_ORDER_HEADER = "//*[@class='Button_Button__ra12g']"; //Верхняя кнопка "Заказать"
    private static final String BUTTON_ORDER_FOOTER = "//*[@class='Button_Button__ra12g Button_Middle__1CSJM']"; // Нижняя кнопка "Заказать"
    private static final By SUCCESSFUL_ORDER_WINDOW = By.className("Order_Modal__YZ-d3"); // Окно успешного оформления заказа
    private final WebDriver driver;
    private final String orderButton;

    public TestOrder(WebDriver driver, String orderButton) {
        this.driver = driver;
        this.orderButton = orderButton;
    }

    @Parameterized.Parameters
    public static Object[][] getResponse() {
        return new Object[][]{
                {new FirefoxDriver(), BUTTON_ORDER_HEADER},
                {new FirefoxDriver(), BUTTON_ORDER_FOOTER},
                {new ChromeDriver(), BUTTON_ORDER_HEADER},
                {new ChromeDriver(), BUTTON_ORDER_FOOTER}
        };
    }

    @Test
    public void checkOrder() {
        driver.get(URL);
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.clickButtonCookie();
        homePageScooter.clickButtonOrder(orderButton);
        PersonalDataPage orderFillingPage = new PersonalDataPage(driver);
        orderFillingPage.fillingPersonalDataPage("Илья","Макаров", "Москва", "+79250705166");
        orderFillingPage.clickButtonNext();
        RentDataPage rentDataPage = new RentDataPage(driver);
        rentDataPage.fillingRentDataPage("Хочу самокат");
        rentDataPage.clickOrderButton();
        rentDataPage.clickAcceptOrderButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESSFUL_ORDER_WINDOW));
        String textOrder = driver.findElement(SUCCESSFUL_ORDER_WINDOW).getText();
        MatcherAssert.assertThat(textOrder, containsString("Заказ оформлен"));
    }

    @After
    public void teardown() {
        RentDataPage rentDataPage = new RentDataPage(driver);
        rentDataPage.clickCheckOrderButton();
        driver.quit();
    }
}
