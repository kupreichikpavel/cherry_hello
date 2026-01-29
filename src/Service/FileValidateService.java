package Service;
import exeption.DuplicateFileException;

import java.nio.file.Path;
import static Consts.Consts.UNAVALIBLE_PATHS;

public class FileValidateService {
    public boolean isAvaliblePath(Path path){
        for (String paths : UNAVALIBLE_PATHS) {
           if(paths.equals(path)){
               return false;
           }
        }
        return true;
    }
    public boolean CheckingDuplicateFiles(Path pathTo,Path pathFrom) {
       if(pathTo.equals(pathFrom)){
          return true;
       }
        return false;
    }
}
