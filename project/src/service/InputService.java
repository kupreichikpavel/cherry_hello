package service;

import models.InputData;
import i18n.I18n;

import java.util.Scanner;

public class InputService {

    private final Scanner scanner;

    public InputService(Scanner scanner) {
        this.scanner = scanner;
    }

    public InputData insertModel() {

        System.out.println(I18n.get().text("enter.source.crypt"));
        String pathFrom = scanner.nextLine();

        System.out.println(I18n.get().text("enter.destination.file"));
        String pathTo = scanner.nextLine();

        System.out.println(I18n.get().text("enter.key"));
        int key = scanner.nextInt();
        scanner.nextLine(); // съесть перевод строки

        return new InputData(pathFrom, pathTo, key);
    }

    public InputData insertPath() {

        System.out.println(I18n.get().text("enter.source.decrypt"));
        String pathFrom = scanner.nextLine();

        System.out.println(I18n.get().text("enter.example.file"));
        String pathTo = scanner.nextLine();

        System.out.println(I18n.get().text("enter.result.file"));
        String result = scanner.nextLine();

        return new InputData(pathFrom, pathTo, result);
    }
}
