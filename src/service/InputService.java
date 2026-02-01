package service;

import models.InputData;

import java.util.Scanner;

import static consts.Consts.ENTER_KEY;

public class InputService {
    private final Scanner scanner;

    public InputService(Scanner scanner) {
        this.scanner = scanner;
    }

    public InputData insertModel(String source) {
        System.out.println("Адрес зашифрованного файла");
        var pathFrom = scanner.nextLine();
        System.out.println("Адрес файла с примером");
        var pathTo = scanner.nextLine();
        System.out.println(ENTER_KEY);
        var key = scanner.nextInt();
        return new InputData(pathFrom, pathTo, key);
    }

    public InputData insertPath() {
        System.out.println("Адрес зашифрованного файла");
        var pathFrom = scanner.nextLine();
        System.out.println("Адрес файла с примером");
        var pathTo = scanner.nextLine();
        System.out.println("Aдрес файла с результатом");
        var result = scanner.nextLine();
        return new InputData(pathFrom, pathTo, result);
    }
}


