package Service;


import java.nio.file.Path;

import static Consts.Consts.UNAVALIBLE_PATHS;

public class FileValidateService {
    public boolean isAvaliblePath(Path path) {
        for (String paths : UNAVALIBLE_PATHS) {
            if (paths.equals(path.toString())) {
                return false;
            }
        }
        return true;
    }

    public boolean isAvaliblePath(Path pathTo, Path pathFrom, Path pathResult) {
        for (String paths : UNAVALIBLE_PATHS) {
            if (paths.equals(pathFrom.toString())) {
                return false;
            }
            if (paths.equals(pathTo.toString())) {
                return false;
            }
            if (paths.equals(pathResult.toString())) {
                return false;
            }
        }
        return true;
    }
    private Path canonical(Path p) {
        return p.normalize().toAbsolutePath();
    }
    public boolean CheckingDuplicateFiles(Path pathTo, Path pathFrom) {
        Path a = canonical(pathTo);
        Path b = canonical(pathFrom);
        return a.equals(b);
    }



    public boolean CheckingDuplicateFiles(Path pathTo, Path pathFrom, Path pathResult) {
        Path a = canonical(pathTo);
        Path b = canonical(pathFrom);
        Path c = canonical(pathResult);

        return a.equals(b) || a.equals(c) || b.equals(c);
    }
}
