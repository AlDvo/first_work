package CheckPath;

import MyException.ErrorExtensionException;

import java.nio.file.Path;

import static Constant.Constant.ERROR_EXTENSION_FILE;
import static Constant.Constant.EXTENSION;

public class CheckPath {

    private String getExtension(String text) {
        String extension;
        if (text.lastIndexOf('.') > 1) {
            extension = text.substring(text.lastIndexOf('.') + 1);
            return extension;
        }
        return null;
    }

    private Boolean checkExtension(String extension) {
        boolean match = false;
        for (String s : EXTENSION) {
            if (s.equals(getExtension(extension))) {
                match = true;
            }
        }
        return match;
    }

    public void checkPath(Path path) throws ErrorExtensionException {
        if (!checkExtension(path.toString())) {
            throw new ErrorExtensionException(ERROR_EXTENSION_FILE);
        }
    }

}
