package CheckPath;

import MyException.ErrorExtensionException;

import java.nio.file.Path;

import static Constant.Constant.ERROR_EXTENSION_FILE;
import static Constant.Constant.EXTENSION;

public class CheckPath {

    private Boolean checkExtension(String extension) {
        for (String s : EXTENSION) {
            if (extension.endsWith(s)) {
                return true;
            }
        }
        return false;
    }

    public void checkPath(Path path) throws ErrorExtensionException {
        if (!checkExtension(path.toString())) {
            throw new ErrorExtensionException(ERROR_EXTENSION_FILE);
        }
    }

}
