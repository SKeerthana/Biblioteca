package com.thoughtworks.biblioteca.options;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitMenuOptionTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitIfOptionTwoIsChosen() {
        exit.expectSystemExit();
        QuitMenuOption quitMenuOption = new QuitMenuOption();
        quitMenuOption.performOperation();
    }
}
