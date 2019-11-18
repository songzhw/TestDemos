package ca.six.tests.books.art.chap2;


class LogAnalyzer {
    public boolean isValidLogFileName(String fileName) {
        if ( fileName.equals("")) {
            throw new IllegalArgumentException("fileName has to be provided. Now it's empty");
        }
        if (!fileName.endsWith(".slf")) {
            return false;
        }
        return true;
    }
}
