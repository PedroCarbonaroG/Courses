package app;

import java.util.Locale;

import view.Prompt;

public class App {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        new Prompt().startPrompt();
    }
}