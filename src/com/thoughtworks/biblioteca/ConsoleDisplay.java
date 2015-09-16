package com.thoughtworks.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

//for getting input from user and displaying output.
public class ConsoleDisplay {
    private PrintStream printStream;
    private Scanner scanner;

    public ConsoleDisplay(PrintStream printStream, InputStream inputStream) {
        this.printStream = printStream;
        this.scanner = new Scanner(inputStream);
    }

    public void printMessage(String message) {
        printStream.print(message);
    }

    public String getInputFromUser() {
        return scanner.nextLine();
    }

}
