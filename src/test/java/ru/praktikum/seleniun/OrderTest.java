package ru.praktikum.seleniun;

import org.junit.Test;
import org.junit.runners.Parameterized;
import ru.praktikum.selenium.pageobject.MainPage;
import ru.praktikum.selenium.pageobject.OrderPage;

public class OrderTest extends BaseTest {

    @Parameterized.Parameters
    public static Object[][] getfillFields() {
        return new Object[][] {
                { "Дмитрий","Дунаев","Санкт-Петербург","87777777777"},
                { "21.05.2023", "не беспокоить"},
        };
    }
    @Test

    public void checkDoOrder() {
        new MainPage(webDriver)
                .clickOrderButton();

        new OrderPage(webDriver)
                .fillFields("Дмитрий","Дунаев","Санкт-Петербург","87777777777");

        new OrderPage(webDriver)
                .fillFieldsRent("21.05.2023", "не беспокоить");
    }
    @Test
    public void checkDoOrder2() {
        new MainPage(webDriver)
                .clickOrderButton();

        new OrderPage(webDriver)
                .fillFields("блаблаблаблабла","йцуфыЙчяЙс","йцуФЫВ-фывячс 1230","81234567821");

        new OrderPage(webDriver)
                .fillFieldsRent("21.05.2023", "не беспокоить");
    }
}