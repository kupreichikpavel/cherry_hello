package service;

import i18n.I18n;

import java.util.Scanner;

public class MenuService {
    public void startProject() {
        Scanner scanner = new Scanner(System.in);
        FileValidateService fileValidateService = new FileValidateService();
        SignsService signsService = new SignsService();
        LanguageService languageService = new LanguageService(scanner);
        languageService.chooseLanguage();
        InputService inputService = new InputService(scanner);
        TextAnalysisService textAnalysisService = new TextAnalysisService();
        FileService fileService = new FileService(fileValidateService);
        CryptionService cryptionService = new CryptionService(fileService, signsService, textAnalysisService, languageService);
        boolean exit = true;

        while (exit) {
            printMenu();
            String input = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(I18n.get().text("menu.invalid.choice"));
                continue;
            }
            switch (choice) {
                case 1: {
                    String line= "enter.source.crypt";
                    cryptionService.crypt(inputService.insertModel(line));
                    break;
                }
                case 2: {
                    String line= "enter.source.decryption";
                    cryptionService.decrypt(inputService.insertModel(line));
                    break;
                }
                case 3: {
                    cryptionService.bruteForce(inputService.insertPath());
                    break;
                }
                case 4: {
                    cryptionService.staticAnalyz(inputService.insertPath());
                    break;
                }
                case 0: {
                    System.out.println(I18n.get().text("app.exit"));
                    exit = false;
                    break;
                }
                default:
                    System.out.println(I18n.get().text("menu.invalid.choice"));
            }
        }

    }

    private void printMenu() {
        System.out.println();
        System.out.println(I18n.get().text("menu.title"));
        System.out.println("1 - " + I18n.get().text("menu.encrypt"));
        System.out.println("2 - " + I18n.get().text("menu.decrypt"));
        System.out.println("3 - " + I18n.get().text("menu.bruteforce"));
        System.out.println("4 - " + I18n.get().text("menu.static.analyze"));
        System.out.println("0 - " + I18n.get().text("menu.exit"));
        System.out.print(I18n.get().text("menu.enter.choice") + " ");
    }
}
