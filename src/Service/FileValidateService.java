package Service;

import java.nio.file.Path;
import java.util.List;

public class FileValidateService {
    private final List<String> UNAVALIBLE_PATHS = List.of();
    public boolean isAvaliblePath(Path path){
        for (String paths : UNAVALIBLE_PATHS) {
           if(paths.equals(path)){
               return false;
           }
        }
        return true;
    }
}
