


import service.*;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileValidateService fileValidateService = new FileValidateService();
        SignsService signsService = new SignsService();
        LanguageService languageService = new LanguageService(scanner);
        languageService.chooseLanguage();
        InputService inputService = new InputService(scanner);
        TextAnalysisService textAnalysisService = new TextAnalysisService();
        FileService fileService = new FileService(fileValidateService);
        CryptionService cryptionService = new CryptionService(fileService, signsService, textAnalysisService, languageService);
        cryptionService.bruteForce(inputService.insertPath());
    }
}