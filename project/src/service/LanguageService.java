package service;

import i18n.I18n;

import java.util.Scanner;

import static i18n.I18n.fromLanguage;

public class LanguageService {
    private final Scanner scanner;
    private String language;
    private I18n i18n;

    public LanguageService(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getLanguage() {
        return language;
    }



    public void chooseLanguage() {
        System.out.println("Выберете язык программы/Choose language ");
        System.out.println("ru/en");
        String input = scanner.nextLine().trim().toLowerCase();
        this.language = input.equals("ru") ? "ru" : "en";   // всё остальное = en
        this.i18n = fromLanguage(this.language);
        switch (language) {
            case "ru": {
                System.out.println("Выбрал русский язык");
                break;
            }
            case "en": {
                System.out.println("Choose english language");
                break;
            }
        }
    }

    public I18n getI18n() {
        return i18n;
    }
}
