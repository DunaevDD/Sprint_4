package ru.praktikum.seleniun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.selenium.pageobject.MainPage;
import ru.praktikum.selenium.pageobject.OrderPage;


@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {
    private final String name;
    private final String lastname;
    private final String address;
    private final String telephoneNumber;
    private final String date;
    private final String comment;

    public OrderTest(String name, String lastname, String address, String telephoneNumber, String date, String comment) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.date = date;
        this.comment = comment;


    }


    @Parameterized.Parameters
    public static Object[][] getfillFields() {
        return new Object[][] {
                { "Дунаев","Дмитрий", "Санкт-Петербург","87777777777", "21.05.2023", "не беспокоить"},
                {"блаблаблаблабла","йцуфыЙчяЙс","йцуФЫВ-фывячс 1230","81234567821", "01.01.4023", "Беспокоить"}
        };
    }
    @Test
    public void checkDoOrderButtonUp() {
        new MainPage(webDriver)
                .clickOrderButtonUp();

        new OrderPage(webDriver)
                .fillFields(name,lastname,address,telephoneNumber)
                .checkSuccessFillFirstPageOrder()
                .fillFieldsRent(date, comment )
                .checkSuccessFillSecondPageOrder();
    }

    @Test
    public void checkDoOrderButtonDown() {
        new MainPage(webDriver)
                .clickOrderButtonDown();

        new OrderPage(webDriver)
                .fillFields(name,lastname,address,telephoneNumber)
                .checkSuccessFillFirstPageOrder()
                .fillFieldsRent(date, comment )
                .checkSuccessFillSecondPageOrder();
    }
}