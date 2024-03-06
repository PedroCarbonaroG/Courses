package application;

import java.util.Locale;

import view.Prompt;

public class Main {
    
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        new Prompt().startPrompt();
    }
}