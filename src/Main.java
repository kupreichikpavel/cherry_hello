import Service.CryptionService;
import Service.FileService;
import Service.FileValidateService;
import Service.InputService;

import java.util.List;
import java.util.Scanner;

import static Consts.Consts.*;

public class Main {
    /*1)Шифрование / расшифровка. Программа должна зашифровывать и расшифровывать текст, используя заданный криптографический ключ.
        Программа должна получать путь к текстовому файлу с исходным текстом и на его основе создавать файл с зашифрованным текстом.
        Шифрование / расшифровка. Программа должна зашифровывать и расшифровывать текст, используя заданный криптографический ключ.
        Программа должна получать путь к текстовому файлу с исходным текстом и на его основе создавать файл с зашифрованным текстом.*/
    /*2)Криптоанализ методом brute force
Программа должна взламывать зашифрованный текст, переданный в виде текстового файла.
Если пользователь выбирает brute force (брутфорс, поиск грубой силой), программа должна самостоятельно, путем перебора, подобрать ключ и расшифровать текст.
Подумай, какой критерий программа должна воспринимать как сигнал успешного подбора ключа.
Возможно, нужно обратить внимание на пробелы между словами или правильность использования знаков пунктуации.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileValidateService fileValidateService = new FileValidateService();
        InputService inputService = new InputService(scanner);
        FileService fileService = new FileService(fileValidateService);
        CryptionService cryptionService = new CryptionService(fileService);


         final List<String> UNAVALIBLE_PATHS = List.of();
        System.out.println(UNAVALIBLE_PATHS);
//        int num = 1;
//        switch (num) {
//            case 1:
//                cryptionService.crypt(inputService.createCryproModel(ENTER_SOURSE_CRYPT_FILE));
//                break;
//            case 2:
//                cryptionService.decrypt(inputService.createCryproModel(ENTER_SOURCE_DECRYPTO_FILE));
//                break;
//            case 3:
//                cryptionService.bruteForce(inputService.createCryptoPath());
//                break;
//            case 4:
//                cryptionService.staticAnalyz(inputService.createCryptoPath());
//                break;
//            default: {
//                System.out.println("meow");
//            }
//        }
    }
}

