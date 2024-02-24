package application;

import java.text.ParseException;
import java.util.Locale;

import view.Prompt;

public class Main {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        new Prompt().buildPrompt();
    }
}