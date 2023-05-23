package ru.praktikum.selenium.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;


public class OrderPage {
    WebDriver webDriver;

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //поля ввод персональных данных
    private By nameField = By.xpath("//input[@placeholder=\"* Имя\"]");
    private By lastnameField = By.xpath("//input[@placeholder=\"* Фамилия\"]");
    private By addressField = By.xpath("//input[@placeholder=\"* Адрес: куда привезти заказ\"]");
    private By telephoneNumberField = By.xpath("//input[@placeholder=\"* Телефон: на него позвонит курьер\"]");
    private By metroField = By.xpath("//input[@placeholder=\"* Станция метро\"]");

    private By chooseMetro = By.xpath("//li[@class=\"select-search__row\"][3]");
    // кнопка "далее"
    private By buttonNext = By.xpath("//button[text()=\"Далее\"]");
    //  "проверка"
    private By secondPage = By.xpath("//div[text()=\"Про аренду\"]");///button[text()='Далее']

    //поля аренды
    private By dateRent = By.xpath("//input[@placeholder=\"* Когда привезти самокат\"]");

    private By rentPeriodClick = By.xpath("//div[text()=\"* Срок аренды\"]");
    private By rentPeriodChoose = By.xpath("//div[text()=\"трое суток\"]");
    private By chooseColor = By.id("black");
    private By commentForTheCourier = By.xpath("//input[@placeholder =\"Комментарий для курьера\"]");

    private By buttonDoOrder = By.xpath("//button[2][text() =\"Заказать\"]");
    private By confirmOrder = By.xpath("//button[text() =\"Да\"]");

    private By successOrder = By.xpath("//div[text()=\"Заказ оформлен\"]");





    public OrderPage fillFields(String name, String lastname, String address, String telephoneNumber) {
        webDriver.findElement(metroField).click();
        webDriver.findElement(chooseMetro).click();
        webDriver.findElement(nameField).sendKeys(name);
        webDriver.findElement(lastnameField).sendKeys(lastname);
        webDriver.findElement(addressField).sendKeys(address);
        webDriver.findElement(telephoneNumberField).sendKeys(telephoneNumber);
        webDriver.findElement(buttonNext).click();
        new WebDriverWait(webDriver, 10).until(driver -> (driver.findElement(secondPage).isDisplayed()));
        return this;
    }

        public OrderPage checkSuccessFillFirstPageOrder(){
            boolean isDisplayed  = webDriver.findElement(secondPage).isDisplayed();
            assertTrue(isDisplayed);
            return this;
        }



    public OrderPage fillFieldsRent(String date, String comment) {

        webDriver.findElement(dateRent).sendKeys(date + "\n");
        webDriver.findElement(secondPage).click();
        webDriver.findElement(rentPeriodClick).click();
        webDriver.findElement(rentPeriodChoose).click();
        webDriver.findElement(chooseColor).click();
        webDriver.findElement(commentForTheCourier).sendKeys(comment);
        webDriver.findElement(buttonDoOrder).click();
        new WebDriverWait(webDriver, 10).until(driver -> (driver.findElement(confirmOrder).isDisplayed()));
        webDriver.findElement(confirmOrder).click();
        new WebDriverWait(webDriver, 10).until(driver -> (driver.findElement(successOrder).isDisplayed()));
        return this;
    }
        public OrderPage checkSuccessFillSecondPageOrder(){
            boolean isDisplayed  = webDriver.findElement(successOrder).isDisplayed();
            assertTrue(isDisplayed);
            return this;
        }

    }


