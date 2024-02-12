package dvorenenko.ru.checks;

import dvorenenko.ru.constant.Constant;
import dvorenenko.ru.exception.ErrorExtensionException;

import java.nio.file.Path;

public class CheckPath {

    public void checkPath(Path path) throws ErrorExtensionException {
        if (!checkExtension(path.toString())) {
            throw new ErrorExtensionException(Constant.ERROR_EXTENSION_FILE);
        }
    }

    private boolean checkExtension(String extension) {
        for (String availableExtension : Constant.EXTENSION) {
            if (extension.endsWith(availableExtension)) {
                return true;
            }
        }
        return false;
    }
}
