package ru.praktikum.seleniun;

import org.junit.Test;
import ru.praktikum.selenium.pageobject.MainPage;

public class QuestionsAboutImportantTest extends BaseTest {

    @Test
    public void checkQuestionsAboutImportantTest() {
        new MainPage(webDriver)
            .questionsImportant();

            }

    }

