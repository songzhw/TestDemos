package ca.six.tests.books.art;

import java.io.InvalidObjectException;

class LogAnalyzer {
    public boolean isValidLogFileName(String fileName) {
        if (!fileName.endsWith(".slf")) {
            return false;
        }
        return true;
    }
}
