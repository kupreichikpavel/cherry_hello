package models;

import service.CryptionService;

import java.util.Scanner;

public class InputData {
    private String pathFrom;
    private String pathTo;
    private String result;
    private Integer key;

    private InputData() {
    }

    public InputData(String pathFrom, String pathTo, Integer key) {
        this.pathFrom = pathFrom;
        this.pathTo = pathTo;
        this.key = key;
    }

    public InputData(String pathFrom, String pathTo, String result) {
        this.pathFrom = pathFrom;
        this.pathTo = pathTo;
        this.result = result;
    }

    public String getPathFrom() {
        return pathFrom;
    }

    public void setPathFrom(String pathFrom) {
        this.pathFrom = pathFrom;
    }

    public String getPathTo() {
        return pathTo;
    }

    public void setPathTo(String pathTo) {
        this.pathTo = pathTo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static void extracted(Scanner scanner, CryptionService cryptionService) {
        InputData inputData = new InputData();
        System.out.println("Адрес зашифрованного файла");
        inputData.setPathFrom(scanner.nextLine());
        System.out.println("Адрес файла с примером");
        inputData.setPathTo(scanner.nextLine());
        System.out.println("Aдрес файла с результатом");
        inputData.setResult(scanner.nextLine());
    }
}

