package dvorenenko.ru.checks;

import dvorenenko.ru.exception.ErrorExtensionException;

import java.nio.file.Path;

import static dvorenenko.ru.constant.Constant.ERROR_EXTENSION_FILE;
import static dvorenenko.ru.constant.Constant.EXTENSION;

public class CheckPath {

    public void checkPath(Path path) throws ErrorExtensionException {
        if (!checkExtension(path.toString())) {
            throw new ErrorExtensionException(ERROR_EXTENSION_FILE);
        }
    }

    private boolean checkExtension(String extension) {
        for (String s : EXTENSION) {
            if (extension.endsWith(s)) {
                return true;
            }
        }
        return false;
    }

}
