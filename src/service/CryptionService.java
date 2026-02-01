package service;

import models.InputData;
import consts.Consts;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CryptionService {
    public static final char SPACE = ' ';
    public final FileService fileService;
    public final SignsService signsSercice;
    public final TextAnalysisService textAnalysisService;


    public CryptionService(FileService fileService, SignsService signsService, TextAnalysisService textAnalysisService) {
        this.fileService = fileService;
        this.signsSercice = signsService;
        this.textAnalysisService = textAnalysisService;
    }

    public void crypt(CryptoModel cryptoModel) {
        List<String> resultlines = new ArrayList<>();
        try {
            List<String> dataFormatFile = fileService.readFromFile(Path.of(cryptoModel.getPathFrom()));
            for (String line : dataFormatFile) {
                StringBuilder stringBuilder = new StringBuilder();
                for (char c : line.toCharArray()) {
                    if (signsSercice.isSpecialSymbol(c) || c == ' ') {
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
        List<String> resultLines = new ArrayList<>();
        try {
            List<String> dataFormatFile = fileService.readFromFile(Path.of(cryptoModel.getPathFrom()));
            for (String line : dataFormatFile) {
                StringBuilder stringBuilder = new StringBuilder();
                for (char c : line.toCharArray()) {
                    if (signsSercice.isSpecialSymbol(c) || c == SPACE) {
                        stringBuilder.append(c);
                        continue;
                    }
                    if (signsSercice.isAlphabetSymbol(c)) {
                        stringBuilder.append(signsSercice.decryptCaesar(c, cryptoModel.getKey()));
                    }
                }
                resultLines.add(stringBuilder.toString());
            }
            fileService.writeFromFile(resultLines, Path.of(cryptoModel.getPathTo()), Path.of(cryptoModel.getPathFrom()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> decryptForLine(List<String> list, int key) {
        List<String> resultlines = new ArrayList<>();
        for (String line : list) {
            StringBuilder sb = new StringBuilder();
            for (char c : line.toCharArray()) {
                if (signsSercice.isSpecialSymbol(c) || c == ' ') {
                    sb.append(c);
                } else if (signsSercice.isAlphabetSymbol(c)) {
                    sb.append(signsSercice.decryptCaesar(c, key));
                } else {
                    sb.append(c);
                }
            }
            resultlines.add(sb.toString());
        }
        return resultlines;
    }


    public void bruteForce(InputData paths) {
        try {
            List<String> cryptText = fileService.readFromFile(Path.of(paths.getPathFrom()));
            List<String> exampleText = fileService.readFromFile(Path.of(paths.getPathTo()));
            int bestKey = -1;
            int bestMathes = 0;
            List<String> bestCandidate = Collections.emptyList();
            Map<String, Integer> exampleWords;
            exampleWords = textAnalysisService.getMostPopularWords(exampleText);

            for (int key = 0; key < Consts.ALPHABET_RUSSIAN.size(); key++) {
                List<String> candidate = decryptForLine(cryptText, key);
                Map<String, Integer> cryptPopularWords = textAnalysisService.getMostPopularWords(candidate);
                int mathes = textAnalysisService.compareMaps(cryptPopularWords, exampleWords);
                if (mathes > bestMathes) {
                    bestMathes = mathes;
                    bestKey = key;
                    bestCandidate = candidate;
                }
            }
            if (bestMathes == 0) {
                System.out.println("Не могу расшифровать текст");
                return;
            }
            fileService.writeFromFileResult(bestCandidate, Path.of(paths.getPathFrom()), Path.of(paths.getPathTo()), Path.of(paths.getResult()));
            System.out.println("DONE key = " + bestKey);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void staticAnalyz(InputData paths) {
    }
}
