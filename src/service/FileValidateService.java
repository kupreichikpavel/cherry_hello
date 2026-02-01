package service;


import java.nio.file.Path;

import static consts.Consts.UNAVALIBLE_PATHS;

public class FileValidateService {
    public boolean isAvaliblePath(Path path) {
        return UNAVALIBLE_PATHS
                .stream()
                .noneMatch(paths -> paths.equals(path.toString()));
    }

    public boolean isAvaliblePath(Path pathTo, Path pathFrom, Path pathResult) {
        //todo: ADJFLKJASLSDK
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

    public boolean checkingDuplicateFiles(Path pathTo, Path pathFrom) {
        Path a = canonical(pathTo);
        Path b = canonical(pathFrom);
        return a.equals(b);
    }

    public boolean checkingDuplicateFiles(Path pathTo, Path pathFrom, Path pathResult) {
        Path a = canonical(pathTo);
        Path b = canonical(pathFrom);
        Path c = canonical(pathResult);

        return a.equals(b)
                || a.equals(c)
                || b.equals(c);
    }

    private Path canonical(Path p) {
        return p.normalize().toAbsolutePath();
    }
}
