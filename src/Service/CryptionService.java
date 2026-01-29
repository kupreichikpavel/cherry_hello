package Service;

import Models.CryptoModel;
import Models.CryptoPaths;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CryptionService {
    public final FileService fileService;
    public final SignsService signsSercice;

    public CryptionService(FileService fileService, SignsService signsService) {
        this.fileService = fileService;
        this.signsSercice = signsService;
    }

    public void crypt(CryptoModel cryptoModel) {
        List<String> resultlines = new ArrayList<>();
        try {
            List<String> dataFormatFile = fileService.readFromFile(Path.of(cryptoModel.getPathFrom()));
            for (String line : dataFormatFile) {
                StringBuilder stringBuilder = new StringBuilder();
                for (char c : line.toCharArray()) {
                    if (signsSercice.isSpecialSymbol(c)) {
                        stringBuilder.append(c);
                        continue;
                    }
                    if (signsSercice.isAlphabetSymbol(c)) {
                        stringBuilder.append(signsSercice.encryptCaesar(c, cryptoModel.getKey()));
                    }
                }
                resultlines.add(stringBuilder.toString());
            }
            fileService.writeFromFile(resultlines, Path.of(cryptoModel.getPathTo()), Path.of(cryptoModel.getPathFrom()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void decrypt(CryptoModel cryptoModel) {
        List<String> resultlines = new ArrayList<>();
        try {
            List<String> dataFormatFile = fileService.readFromFile(Path.of(cryptoModel.getPathTo()));
            for (String line : dataFormatFile) {
                StringBuilder stringBuilder = new StringBuilder();
                for (char c : line.toCharArray()) {
                    if (signsSercice.isSpecialSymbol(c)) {
                        stringBuilder.append(c);
                        continue;
                    }
                    if (signsSercice.isAlphabetSymbol(c)) {
                        stringBuilder.append(signsSercice.encryptCaesar(c, cryptoModel.getKey()));
                    }
                }
                resultlines.add(stringBuilder.toString());
            }
            fileService.writeFromFile(resultlines, Path.of(cryptoModel.getPathTo()), Path.of(cryptoModel.getPathFrom()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void bruteForce(CryptoPaths paths) {

    }

    public void staticAnalyz(CryptoPaths paths) {
    }
}
