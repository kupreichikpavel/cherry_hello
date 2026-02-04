package service;

import consts.Consts;
import exception.TextException;
import models.InputData;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static consts.Consts.SPACE;

public class CryptionService {
    public final FileService fileService;
    public final SignsService signsSercice;
    public final TextAnalysisService textAnalysisService;
    public final LanguageService languageService;


    public CryptionService(FileService fileService, SignsService signsService, TextAnalysisService textAnalysisService, LanguageService languageService) {
        this.fileService = fileService;
        this.signsSercice = signsService;
        this.textAnalysisService = textAnalysisService;
        this.languageService = languageService;
    }

    public void crypt(InputData inputData) {
        List<String> resultlines = new ArrayList<>();
        try {
            List<String> dataFormatFile = fileService.readFromFile(Path.of(inputData.getPathFrom()));
            for (String line : dataFormatFile) {
                StringBuilder stringBuilder = new StringBuilder();
                for (char c : line.toCharArray()) {
                    if (signsSercice.isSpecialSymbol(c) || c == ' ') {
                        stringBuilder.append(c);
                        continue;
                    }
                    if (signsSercice.isAlphabetSymbol(c)) {
                        stringBuilder.append(signsSercice.toCrypt(c, inputData.getKey(), languageService.getLanguage()));
                    }
                }
                resultlines.add(stringBuilder.toString());
            }
            fileService.writeFromFile(resultlines, Path.of(inputData.getPathTo()), Path.of(inputData.getPathFrom()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void decrypt(InputData inputData) {
        List<String> resultLines = new ArrayList<>();
        try {
            List<String> dataFormatFile = fileService.readFromFile(Path.of(inputData.getPathFrom()));
            for (String line : dataFormatFile) {
                StringBuilder stringBuilder = new StringBuilder();
                for (char c : line.toCharArray()) {
                    if (signsSercice.isSpecialSymbol(c) || c == SPACE) {
                        stringBuilder.append(c);
                        continue;
                    }
                    if (signsSercice.isAlphabetSymbol(c)) {
                        stringBuilder.append(signsSercice.toCrypt(c, -inputData.getKey(), languageService.getLanguage()));
                    }
                }
                resultLines.add(stringBuilder.toString());
            }
            fileService.writeFromFile(resultLines, Path.of(inputData.getPathTo()), Path.of(inputData.getPathFrom()));

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
                    sb.append(signsSercice.toCrypt(c, -key, languageService.getLanguage()));
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
                    bestCandidate = candidate;
                }
            }
            if (bestMathes == 0) {
                throw new TextException();
            }
            fileService.writeFromFileResult(bestCandidate, Path.of(paths.getPathFrom()), Path.of(paths.getPathTo()), Path.of(paths.getResult()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void staticAnalyz(InputData paths) {
        try {
            List<String> cryptText = fileService.readFromFile(Path.of(paths.getPathFrom()));
            List<String> exampleText = fileService.readFromFile(Path.of(paths.getPathTo()));
            Map<Character, Integer> exampleStats = textAnalysisService.getStatsAfterDotSpace(exampleText);
            int bestMatches = 0;
            List<String> bestCandidate = Collections.emptyList();

            for (int key = 0; key < Consts.ALPHABET_RUSSIAN.size(); key++) {
                List<String> candidate = decryptForLine(cryptText, key);
                Map<Character, Integer> candidateStats =
                        textAnalysisService.getStatsAfterDotSpace(candidate);
                int matches = textAnalysisService.topMatch(exampleStats, candidateStats);
                if (matches > bestMatches) {
                    bestMatches = matches;
                    bestCandidate = candidate;
                }
            }
            if (bestCandidate.isEmpty()) {
                throw new TextException();
            }
            fileService.writeFromFileResult(bestCandidate, Path.of(paths.getPathFrom()), Path.of(paths.getPathTo()), Path.of(paths.getResult()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
