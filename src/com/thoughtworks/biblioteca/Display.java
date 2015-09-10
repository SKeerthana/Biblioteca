package com.thoughtworks.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

//for getting input from user and displaying output.
public class Display {
    private PrintStream printStream;
    private InputStream inputStream;

    public Display(PrintStream printStream, InputStream inputStream) {
        this.printStream = printStream;
        this.inputStream = inputStream;
    }

    public void printMessage(String message) {
        printStream.print(message);
    }

    public String getInputFromUser() {
        Scanner sc = new Scanner(inputStream);
        return sc.nextLine();
    }

}
