package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class RentDataPage {
    private final WebDriver driver;
    private static final By DATE = By.xpath("//*[@placeholder='* Когда привезти самокат']"); //Поле ввода даты
    private static final By RENTAL_PERIOD = By.xpath("//*[@class='Dropdown-placeholder'][text()='* Срок аренды']"); //Поле ввода срока аренды
    private static final By SCOOTER_COLOR = By.id("black"); //Поле выбора цвета скутера
    private static final By COMMENT = By.xpath("//*[@placeholder='Комментарий для курьера']"); //Поле ввода комментария
    private static final By ORDER_BUTTON = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][text()='Заказать']"); //Кнопка "Заказать"
    private static final By ACCEPT_ORDER_BUTTON = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM'][text()='Да']"); //Кнопка "Да" для подтверждения заказа
    private static final By CHECK_ORDER_BUTTON = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM'][text()='Посмотреть статус']"); //Кнопка "Посмотреть статус"

    public RentDataPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillingDate() {
        driver.findElement(DATE).click();
        driver.findElement(By.xpath("//*[@role='button'][text()='16']")).click(); // Выбор 16 числа в поле выбора даты
    }

    public void fillingRentalPeriod() {
        driver.findElement(RENTAL_PERIOD).click();
        driver.findElement(By.xpath("//*[@role='option'][text()='сутки']")).click(); // Выбор срока аренды самоката
    }

    public void fillingScooterColor() {
        driver.findElement(SCOOTER_COLOR).click();
    }

    public void fillingComment(String comment) {
        driver.findElement(COMMENT).sendKeys(comment);
    }

    public void clickOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(ORDER_BUTTON));
        driver.findElement(ORDER_BUTTON).click();
    }

    public void clickAcceptOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_ORDER_BUTTON));
        driver.findElement(ACCEPT_ORDER_BUTTON).click();
    }

    public void clickCheckOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(CHECK_ORDER_BUTTON));
        driver.findElement(CHECK_ORDER_BUTTON).click();
    }

    public void fillingRentDataPage(String comment){
        fillingDate();
        fillingRentalPeriod();
        fillingScooterColor();
        fillingComment(comment);
    }
}


