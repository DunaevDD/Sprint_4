package ru.praktikum.selenium.pageobject;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static ru.praktikum.selenium.config.Сonfig.APP_URL;
@RunWith(Parameterized.class)
public class MainPage {
     WebDriver webDriver;

    public MainPage(WebDriver webDriver) {this.webDriver = webDriver;
        webDriver.get(APP_URL);
    }

    private  By endPage = By.xpath("//div[text() = \"Вопросы о важном\"]");
    private  By allQuestions = By.xpath("//*[contains(@id, 'accordion__heading')]");

// кнопка заказать верхняя
    private  By buttonOrderUp = By.className("Button_Button__ra12g");
    //кнопка заказать нижняя
    private By buttonOrderDown = By.className("Button_Button__ra12g Button_UltraBig__UU3Lp");

    private By findPage = By.xpath("//div[text()=\"Для кого самокат\"]");

    private By QuOne = By.xpath("//*[text()=\"Сутки — 400 рублей. Оплата курьеру — наличными или картой.\"]");
    private By QuTwo = By.xpath("//*[text()=\"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.\"]");
    private By QuThree = By.xpath("//*[text()=\"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.\"]");
    private By QuFour = By.xpath("//*[text()=\"Только начиная с завтрашнего дня. Но скоро станем расторопнее.\"]");
    private By QuFive = By.xpath("//*[text()=\"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.\"]");
    private By QuSix = By.xpath("//*[text()=\"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.\"]");
    private By QuSeven = By.xpath("//*[text()=\"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.\"]");
    private By QuEight = By.xpath("//*[text()=\"Да, обязательно. Всем самокатов! И Москве, и Московской области.\"]");


    public MainPage clickOrderButton(){
        webDriver.findElement(buttonOrderUp).click();
        new WebDriverWait(webDriver, 10).until(driver -> (driver.findElement(findPage).isDisplayed()));
         return this;
    }

    public void  questionsImportant(){

       webDriver.findElement(buttonOrderUp).sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN,Keys.PAGE_DOWN );
        List<WebElement> elementList = webDriver.findElements(allQuestions);
        String QuOneExepted = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String QuTwoExepted = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String QuThreeExepted = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String QuFourExepted = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String QuFiveExepted = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String QuSixExepted = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String QuSevenExepted = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String QuEightExepted = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

        for (int i = 0; i < elementList.size() ; i++){



            By[] actualResult ={QuOne,QuTwo, QuThree, QuFour, QuFive, QuSix, QuSeven, QuEight};
            String[] exeptedResult = {QuOneExepted, QuTwoExepted, QuThreeExepted,QuFourExepted,QuFiveExepted,QuSixExepted,QuSevenExepted, QuEightExepted};

            elementList.get(i).click();
            int finalI = i;
            new WebDriverWait(webDriver, 10).until(driver -> (driver.findElement(actualResult[finalI]).isDisplayed()));
            Assert.assertEquals(exeptedResult[i], webDriver.findElement(actualResult[i]).getText());

        }

    }
}