package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class HomePageScooter {
    private final WebDriver driver;
    private static final String BUTTON_ORDER_HEADER = "//*[@class='Button_Button__ra12g']"; //Верхняя кнопка заказа
    private static final String BUTTON_ORDER_FOOTER = "//*[@class='Button_Button__ra12g Button_Middle__1CSJM']"; //Нижняя кнопка заказа
    private static final By COOKIE_BUTTON = By.className("App_CookieButton__3cvqF"); //Кнопка cookie
    private static final By FAQ = By.className("Home_FAQ__3uVm4"); //Место расположения вопросов на странице
    private static final By BUTTON_FAQ_QUESTION_1 = By.id("accordion__heading-0");
    private static final By BUTTON_FAQ_QUESTION_2 = By.id("accordion__heading-1");
    private static final By BUTTON_FAQ_QUESTION_3 = By.id("accordion__heading-2");
    private static final By BUTTON_FAQ_QUESTION_4 = By.id("accordion__heading-3");
    private static final By BUTTON_FAQ_QUESTION_5 = By.id("accordion__heading-4");
    private static final By BUTTON_FAQ_QUESTION_6 = By.id("accordion__heading-5");
    private static final By BUTTON_FAQ_QUESTION_7 = By.id("accordion__heading-6");
    private static final By BUTTON_FAQ_QUESTION_8 = By.id("accordion__heading-7");
    private static final By ANSWER_FAQ_1 = By.id("accordion__panel-0");
    private static final By ANSWER_FAQ_2 = By.id("accordion__panel-1");
    private static final By ANSWER_FAQ_3 = By.id("accordion__panel-2");
    private static final By ANSWER_FAQ_4 = By.id("accordion__panel-3");
    private static final By ANSWER_FAQ_5 = By.id("accordion__panel-4");
    private static final By ANSWER_FAQ_6 = By.id("accordion__panel-5");
    private static final By ANSWER_FAQ_7 = By.id("accordion__panel-6");
    private static final By ANSWER_FAQ_8 = By.id("accordion__panel-7");
    By[] ANSWERS_FAQ = {ANSWER_FAQ_1, ANSWER_FAQ_2, ANSWER_FAQ_3, ANSWER_FAQ_4, ANSWER_FAQ_5, ANSWER_FAQ_6, ANSWER_FAQ_7, ANSWER_FAQ_8};
    By[] BUTTONS_QUESTION = {BUTTON_FAQ_QUESTION_1, BUTTON_FAQ_QUESTION_2, BUTTON_FAQ_QUESTION_3, BUTTON_FAQ_QUESTION_4, BUTTON_FAQ_QUESTION_5, BUTTON_FAQ_QUESTION_6, BUTTON_FAQ_QUESTION_7, BUTTON_FAQ_QUESTION_8};

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonFAQ(int numberQuestion){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(BUTTONS_QUESTION[numberQuestion]));
        driver.findElement(BUTTONS_QUESTION[numberQuestion]).click();
    }

    public String getTextAnswerFAQ(int numberQuestion){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ANSWERS_FAQ[numberQuestion]));
        return driver.findElement(ANSWERS_FAQ[numberQuestion]).getText();
    }

    public void clickButtonOrder(String button) {
        if (Objects.equals(button, BUTTON_ORDER_HEADER)) {
            driver.findElement(By.xpath(button)).click();
        }
        if (Objects.equals(button, BUTTON_ORDER_FOOTER)) {
            WebElement element = driver.findElement(By.className("Home_FinishButton__1_cWm")); //Место расположения нижней кнопки "Заказать"
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(By.xpath(button)).click();
        }
    }

    public void scrollToFAQ() {
        WebElement element = driver.findElement(FAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(FAQ));
    }

    public void clickButtonCookie() {
        driver.findElement(COOKIE_BUTTON).click();
    }



}
