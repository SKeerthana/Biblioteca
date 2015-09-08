package com.thoughtworks.biblioteca;

public class CheckoutMenuOption implements MenuOption{
    private Biblioteca biblioteca;
    private Display display;

    public CheckoutMenuOption(Biblioteca biblioteca, Display display) {
        this.biblioteca = biblioteca;
        this.display = display;
    }
    @Override
    public void performOperation() {
    }
}
