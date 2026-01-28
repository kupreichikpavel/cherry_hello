package Service;

import Models.CryptoModel;
import Models.CryptoPaths;

import java.util.Scanner;

import static Consts.Consts.ENTER_DESTINATIOON_FILE;
import static Consts.Consts.ENTER_KEY;

public class InputService {
    private final Scanner scanner;

    public InputService(Scanner scanner) {
        this.scanner = scanner;
    }

    public CryptoModel createCryproModel(String source) {
        CryptoModel cryptoModel = new CryptoModel();
        System.out.println(source);
        cryptoModel.setPathFrom(scanner.nextLine());
        System.out.println(ENTER_DESTINATIOON_FILE);
        cryptoModel.setPathTo(scanner.nextLine());
        System.out.println(ENTER_KEY);
        cryptoModel.setKey(scanner.nextInt());
        return cryptoModel;
    }

    public CryptoPaths createCryptoPath() {
        CryptoPaths cryptoPaths = new CryptoPaths();
        System.out.println("Адрес зашифрованного файла");
        cryptoPaths.setPathFrom(scanner.nextLine());
        System.out.println("Адрес файла с примером");
        cryptoPaths.setPathTo(scanner.nextLine());
        System.out.println("Aдрес файла с результатом");
        cryptoPaths.setResult(scanner.nextLine());
        return cryptoPaths;
    }
}


