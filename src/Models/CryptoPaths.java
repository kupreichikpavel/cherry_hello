package Models;

import Service.CryptionService;

import java.util.Scanner;

public class CryptoPaths {
 private String pathFrom;
 private String pathTo;
 private String result;

    public CryptoPaths() {
    }

    public CryptoPaths(String pathFrom, String pathTo, String result) {
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
        CryptoPaths cryptoPaths = new CryptoPaths();
        System.out.println("Адрес зашифрованного файла");
        cryptoPaths.setPathFrom(scanner.nextLine());
        System.out.println("Адрес файла с примером");
        cryptoPaths.setPathTo(scanner.nextLine());
        System.out.println("Aдрес файла с результатом");
        cryptoPaths.setResult(scanner.nextLine());
    }
}

