package Service;

import exeption.FileExeption;
import exeption.UnsupportedFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


import static java.nio.file.Files.readAllLines;

public class FileService {
      private final FileValidateService fileValidateService;

    public FileService(FileValidateService fileValidateService) {
        this.fileValidateService = fileValidateService;
    }

    public List<String> readFromFile(Path path, boolean needToCheck) throws FileExeption, UnsupportedFileException,IOException {
      if(fileValidateService.isAvaliblePath(path)){
          throw  new UnsupportedFileException("нельзя мод");
      }
        if(needToCheck){
        long size = 0;
        for (String lines : Files.readAllLines(path)){
            size +=lines.length();
        }
          if(size < 1000){
              throw new UnsupportedFileException("мало текста");
          }
      }
      return null;
    }

    public void writeFromFile(List<String> data, Path path){
    }
}
