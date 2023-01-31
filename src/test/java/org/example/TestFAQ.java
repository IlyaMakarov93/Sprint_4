package org.example;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestFAQ {
    private static final String URL = "https://qa-scooter.praktikum-services.ru/"; // URL сайта
    private final String answerText;
    private final int numberQuestion;
    private final boolean expected;

    public TestFAQ(int numberQuestion, String answerText, boolean expected) {
        this.numberQuestion = numberQuestion;
        this.answerText = answerText;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getResponse() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", true},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", true},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", true},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", true},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", true},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", true},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", true},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области.", true}
        };
    }

    WebDriver driver = new ChromeDriver();

    @Test
    public void checkFAQ() {
        driver.get(URL);
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.clickButtonCookie();
        homePageScooter.scrollToFAQ();
        for (int i = 0; i < 7; i++) {
            homePageScooter.clickButtonFAQ(numberQuestion);
            String actual = homePageScooter.getTextAnswerFAQ(numberQuestion);
            assertEquals(expected, Objects.equals(actual, answerText));
        }
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
