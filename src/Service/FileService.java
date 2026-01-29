package Service;

import exeption.DuplicateFileException;
import exeption.FileExeption;
import exeption.UnsupportedFileException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


import static java.nio.file.Files.readAllLines;

public class FileService {
    private final FileValidateService fileValidateService;

    public FileService(FileValidateService fileValidateService) {
        this.fileValidateService = fileValidateService;
    }

    public List<String> readFromFile(Path path) throws UnsupportedFileException, IOException, FileExeption {
        if (!Files.exists(path)) {
            throw new FileExeption("Исходного файла не существует");
        }
        List<String> data = new ArrayList<>();
        if (!fileValidateService.isAvaliblePath(path)) {
            throw new UnsupportedFileException("нельзя модифицировать этот файл");
        }
        long size = 0;
        for (String lines : Files.readAllLines(path)) {
            size += lines.length();
            data.add(lines.toLowerCase());
        }
        if (size < 100) {
            throw new UnsupportedFileException("мало текста в переданном файле");
        }
        return data;
    }

    public void writeFromFile(List<String> data, Path pathFrom, Path pathTo) throws DuplicateFileException, FileExeption, IOException {
        if (!Files.exists(pathFrom)) {
            throw new FileExeption("Выходного файла не существует");
        }
        if (fileValidateService.CheckingDuplicateFiles(pathTo, pathFrom)) {
            throw new DuplicateFileException("DuplicateFiles");
        }
        try (BufferedWriter writer = Files.newBufferedWriter(pathFrom)) {
            for (String line : data) {
                writer.write(line);
                writer.flush();
                writer.newLine();
            }
        }
        System.out.println("program 1 done");


    }
}
