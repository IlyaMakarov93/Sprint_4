package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

class HomePageScooter {
    private final WebDriver driver;
    private static final String BUTTON_ORDER_HEADER = "//*[@class='Button_Button__ra12g']"; //Верхняя кнопка заказа
    private static final String BUTTON_ORDER_FOOTER = "//*[@class='Button_Button__ra12g Button_Middle__1CSJM']"; //Нижняя кнопка заказа
    private static final By COOKIE_BUTTON = By.className("App_CookieButton__3cvqF"); //Кнопка cookie
    private static final By FAQ = By.className("Home_FAQ__3uVm4"); //Место расположения вопросов на странице


    HomePageScooter(WebDriver driver) {
        this.driver = driver;
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

    public void clickQuestionButton(int numQuestion) {
        driver.findElement(By.id("accordion__heading-" + numQuestion)).click();
    }

}

class PersonalDataPage {
    private final WebDriver driver;
    private static final By FIRST_NAME = By.xpath("//*[@placeholder='* Имя']"); //Поле ввода имени
    private static final By LAST_NAME = By.xpath("//*[@placeholder='* Фамилия']"); //Поле ввода фамилии
    private static final By ADDRESS = By.xpath("//*[@placeholder='* Адрес: куда привезти заказ']"); //Поле ввода адреса
    private static final By SUBWAY_STATION = By.xpath("//*[@placeholder='* Станция метро']"); //Поле ввода станции

    private static final By PHONE_NUMBER = By.xpath("//*[@placeholder='* Телефон: на него позвонит курьер']"); // Поле ввода телефона

    private static final By BUTTON_NEXT = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Кнопка "Далее"

    PersonalDataPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillingFirstName(String firstName) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
    }

    public void fillingLastName(String lastName) {
        driver.findElement(LAST_NAME).sendKeys(lastName);
    }

    public void fillingAddress(String address) {
        driver.findElement(ADDRESS).sendKeys(address);
    }

    public void fillingSubwayStation() {
        driver.findElement(SUBWAY_STATION).click();
        driver.findElement(By.xpath("//button[@value='1']")).click(); //Выбор первой станции в списке
    }

    public void fillingPhoneNumber(String phoneNumber) {
        driver.findElement(PHONE_NUMBER).sendKeys(phoneNumber);
    }

    public void clickButtonNext() {
        driver.findElement(BUTTON_NEXT).click();
    }
}

class RentDataPage {
    private final WebDriver driver;
    private static final By DATE = By.xpath("//*[@placeholder='* Когда привезти самокат']"); //Поле ввода даты
    private static final By RENTAL_PERIOD = By.xpath("//*[@class='Dropdown-placeholder'][text()='* Срок аренды']"); //Поле ввода срока аренды
    private static final By SCOOTER_COLOR = By.id("black"); //Поле выбора цвета скутера
    private static final By COMMENT = By.xpath("//*[@placeholder='Комментарий для курьера']"); //Поле ввода комментария
    private static final By ORDER_BUTTON = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][text()='Заказать']"); //Кнопка "Заказать"
    private static final By ACCEPT_ORDER_BUTTON = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM'][text()='Да']"); //Кнопка "Да" для подтверждения заказа
    private static final By CHECK_ORDER_BUTTON = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM'][text()='Посмотреть статус']"); //Кнопка "Посмотреть статус"

    RentDataPage(WebDriver driver) {
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
}


