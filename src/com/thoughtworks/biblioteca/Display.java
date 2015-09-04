package com.thoughtworks.biblioteca;

import java.io.PrintStream;
//takes the message and displays the output
public class Display {
    private PrintStream out;

    public Display(PrintStream out) {
        this.out = out;
    }

    public void printMessage(String message) {
        out.println(message);
    }
}
