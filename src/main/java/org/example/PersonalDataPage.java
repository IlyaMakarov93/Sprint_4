package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDataPage {
    private final WebDriver driver;
    private static final By FIRST_NAME = By.xpath("//*[@placeholder='* Имя']"); //Поле ввода имени
    private static final By LAST_NAME = By.xpath("//*[@placeholder='* Фамилия']"); //Поле ввода фамилии
    private static final By ADDRESS = By.xpath("//*[@placeholder='* Адрес: куда привезти заказ']"); //Поле ввода адреса
    private static final By SUBWAY_STATION = By.xpath("//*[@placeholder='* Станция метро']"); //Поле ввода станции
    private static final By PHONE_NUMBER = By.xpath("//*[@placeholder='* Телефон: на него позвонит курьер']"); // Поле ввода телефона
    private static final By BUTTON_NEXT = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Кнопка "Далее"

    public PersonalDataPage(WebDriver driver) {
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

    public void fillingPersonalDataPage(String firstName, String lastName, String address, String phoneNumber ){
        fillingFirstName(firstName);
        fillingLastName(lastName);
        fillingAddress(address);
        fillingSubwayStation();
        fillingPhoneNumber(phoneNumber);
    }
}
