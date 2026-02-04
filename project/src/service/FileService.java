package service;

import exception.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private final FileValidateService fileValidateService;


    public FileService(FileValidateService fileValidateService) {
        this.fileValidateService = fileValidateService;
    }

    public List<String> readFromFile(Path path) throws UnsupportedFileException, IOException, FileInputExeception, TextException {
        if (!Files.exists(path)) {
            throw new FileInputExeception();
        }
        List<String> data = new ArrayList<>();
        if (!fileValidateService.isAvaliblePath(path)) {
            throw new UnsupportedFileException();
        }
        long size = 0;
        for (String lines : Files.readAllLines(path)) {
            size += lines.length();
            data.add(lines.toLowerCase());
        }
        if (size < 100) {
            throw new TextException();
        }
        return data;
    }

    public void writeFromFile(List<String> data, Path pathFrom, Path pathTo) throws DuplicateFileTextException, FileInputExeception, IOException {
        if (!Files.exists(pathFrom)) {
            throw new FileInputExeception();
        }
        if (fileValidateService.checkingDuplicateFiles(pathTo, pathFrom)) {
            throw new DuplicateFileTextException();
        }
        try (BufferedWriter writer = Files.newBufferedWriter(pathFrom)) {
            for (String line : data) {
                writer.write(line);
                writer.flush();
                writer.newLine();
            }
        }
        System.out.println("program done");
    }

    public void writeFromFileResult(List<String> data, Path pathFrom, Path pathTo, Path pathResult) throws DuplicateFileTextException, IOException, UnsupportedFileException, FileOutputException, FileResultException {

        if (!Files.exists(pathFrom)) {
            throw new FileOutputException();
        }
        if (!Files.exists(pathResult)) {
            throw new FileResultException();
        }
        if (!fileValidateService.isAvaliblePath(pathFrom, pathTo, pathResult)) {
            throw new UnsupportedFileException();
        }
        if (fileValidateService.checkingDuplicateFiles(pathTo, pathFrom, pathResult)) {
            throw new DuplicateFileTextException();
        }
        try (BufferedWriter writer = Files.newBufferedWriter(pathResult)) {

            for (String line : data) {
                writer.write(line);
                writer.flush();
                writer.newLine();
            }
        }
        System.out.println("program 3 done");
    }
}